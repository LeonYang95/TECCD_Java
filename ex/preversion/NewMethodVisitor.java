package ccd;

import antlr.Java8BaseVisitor;
import antlr.Java8Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.*;

public class NewMethodVisitor extends Java8BaseVisitor<Integer> {
    private static int methodLimitedLine = Integer.valueOf(PropsLoader.getProperty("ccd.methodLimitedLine"));
    private int startLine;
    private String pathFilename;//方法所在文件的路径以及文件名
    private Jedis redis;

    private List<String> vectorSequence = new ArrayList<>();//方法规则结点的index序列
    private int blockIndex = 0;
    private int methodIndex = 0;

    @Override
    public Integer visitMethodHeader(Java8Parser.MethodHeaderContext ctx) {
        methodIndex++;
        startLine = ctx.start.getLine();
        return visitChildren(ctx);
    }

    @Override
    public Integer visitBlockStatement(Java8Parser.BlockStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitMethodBody(Java8Parser.MethodBodyContext ctx) {
        System.out.println("visitMethodBody...");
        Stack<ParseTree> stack = new Stack<>();
        stack.push(ctx);
        int ruleIndex;
        Map<String, List<Integer>> rlMap = new HashMap<>();
        while(!stack.empty()){
            ParseTree node = stack.pop();
            if(node instanceof RuleNode){
                ruleIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if(RuleFilter.ruleFilter().containsKey(ruleIndex)){//过滤与克隆关系不大的规则结点
                    vectorSequence.add(ruleIndex+"");
                }
                if(ruleIndex == Java8Parser.RULE_blockStatement){
                    ParserRuleContext ct = (ParserRuleContext)node;
                    int blockType = ct.getParent().getParent().getParent().getRuleContext().getRuleIndex();//是否是直接从属方法的语句
                    if(blockType == Java8Parser.RULE_methodBody){
                        blockIndex++;
                        String blockKey = methodIndex + "" + blockIndex;
                        Stack<ParseTree> blockStack = new Stack<>();
                        blockStack.push(ct);
                        int blockRuleIndex;
                        while (!blockStack.empty()) {
                            ParseTree blockNode = blockStack.pop();
                            if (blockNode instanceof RuleNode) {
                                blockRuleIndex = ((RuleNode) blockNode).getRuleContext().getRuleIndex();
                                if (RuleFilterForLine.ruleFilter().containsKey(blockRuleIndex)) {
                                    if (!rlMap.keySet().contains(blockKey)) {
                                        List<Integer> rlList = new ArrayList<>();
                                        rlList.add(blockRuleIndex);
                                        rlMap.put(blockKey, rlList);
                                    } else {
                                        rlMap.get(blockKey).add(blockRuleIndex);
                                    }
                                }
                                for (int len = blockNode.getChildCount(), i = len - 1; i >= 0; i--) {
                                    blockStack.push(blockNode.getChild(i));
                                }
                            }
                        }
                    }
                }
                for(int len = node.getChildCount(), i = len - 1; i >= 0; i --){
                    stack.push(node.getChild(i));
                }
            }
        }
        String value="";
        StringBuilder methodLineNodes = new StringBuilder();
        for (Map.Entry<String, List<Integer>> entry : rlMap.entrySet()) {
            if(entry.getValue().size() > 0){
                String str = entry.getValue().toString();
                String lineNodes = str.substring(1, str.length()-1);
                methodLineNodes.append(lineNodes+";");
            }
        }
//        value = methodLineNodes.toString();

        if(methodLineNodes.length() > 0){
            value = methodLineNodes.deleteCharAt(methodLineNodes.length()-1).toString();
        }

        /*for (Map.Entry<Integer,  List<Integer>> entry : resultMap.entrySet()) {
            if(entry.getValue().size() > 0){
                String str = entry.getValue().toString();
                String lineNodes = str.substring(1, str.length()-1);
                methodLineNodes.append(lineNodes+";");
            }
        }
        if(methodLineNodes.length() > 0){
            value = methodLineNodes.deleteCharAt(methodLineNodes.length()-1).toString();
        }*/

        System.out.println("value: "+value);
        blockIndex = 0;
        return visitChildren(ctx);
    }


/*
    @Override
    public Integer visitMethodBody(Java8Parser.MethodBodyContext ctx) {
        int stopLine = ctx.stop.getLine();
        if((stopLine - startLine + 1) < methodLimitedLine)//方法代码行过滤阈值, 低于阈值的不参与检测
            return null;
        String key = pathFilename + "(" + startLine + "-" + stopLine + ")";
        String value = "";
        Stack<ParseTree> stack = new Stack<>();
        stack.push(ctx);
        int ruleIndex, ruleNodeLine;
        Map<Integer, List<Integer>> rlMap = new HashMap();
        while(!stack.empty()){
            ParseTree node = stack.pop();
            if(node instanceof RuleNode){
                ParserRuleContext ct = (ParserRuleContext)node;
                ruleIndex = ((RuleNode) node).getRuleContext().getRuleIndex();

                if(RuleFilterForLine.ruleFilter().containsKey(ruleIndex)){
                    ruleNodeLine = ct.start.getLine();
                    if(!rlMap.keySet().contains(ruleNodeLine)){
                        List<Integer> rlList = new ArrayList<>();
                        rlList.add(ruleIndex);
                        rlMap.put(ruleNodeLine, rlList);
                    }else {
                        rlMap.get(ruleNodeLine).add(ruleIndex);
                    }
                }

                if(RuleFilter.ruleFilter().containsKey(ruleIndex)){//过滤与克隆关系不大的规则结点
                    vectorSequence.add(ruleIndex+"");
                }

                for(int len = node.getChildCount(), i = len - 1; i >= 0; i --){
                    stack.push(node.getChild(i));
                }
            }
        }

        Map<Integer, List<Integer>> resultMap = sortMapByKey(rlMap);
        StringBuilder methodLineNodes = new StringBuilder();
        for (Map.Entry<Integer,  List<Integer>> entry : resultMap.entrySet()) {
            if(entry.getValue().size() > 0){
                String str = entry.getValue().toString();
                String lineNodes = str.substring(1, str.length()-1);
                methodLineNodes.append(lineNodes+";");
            }
        }
        if(methodLineNodes.length() > 0){
            value = methodLineNodes.deleteCharAt(methodLineNodes.length()-1).toString();
        }
        System.out.println("value: "+value+";");
        redis.set(key, value+";"+StringUtils.join(vectorSequence, ","));
        return visitChildren(ctx);
    }
*/

    private Map<Integer, List<Integer>> sortMapByKey(Map<Integer, List<Integer>> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, List<Integer>> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    void setPathFilename(String pathFilename) {
        this.pathFilename = pathFilename;
    }
    void setRedis(Jedis redis) {
        this.redis = redis;
    }
}

class MapKeyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer s1, Integer s2) {
        return s1.compareTo(s2);
    }
}
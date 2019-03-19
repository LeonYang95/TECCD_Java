package ccd.h1h2;

import antlr.Java8BaseVisitor;
import antlr.Java8Parser;
import ccd.PropsLoader;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import redis.clients.jedis.Jedis;

import java.util.Stack;

public class MethodVisitorH1H2 extends Java8BaseVisitor<Integer> {
    private static int methodLimitedLine = Integer.valueOf(PropsLoader.getProperty("ccd.methodLimitedLine"));
    private final String ccdSeparate = "ccdMethodSeparate";
    private int startLine;
    private String pathFilename;//方法所在文件的路径以及文件名
    private Jedis redis;

    @Override
    public Integer visitMethodHeader(Java8Parser.MethodHeaderContext ctx) {
        startLine = ctx.start.getLine();
        return visitChildren(ctx);
    }

    @Override
    public Integer visitMethodBody(Java8Parser.MethodBodyContext ctx) {
        //将AST转化成network形式:
        int stopLine = ctx.stop.getLine();
        if((stopLine - startLine + 1) < methodLimitedLine)//方法代码行过滤阈值, 低于阈值的不参与检测
            return null;
        String key = pathFilename + "(" + startLine + "-" + stopLine + ")";
        Stack<ParseTree> stack = new Stack<>();
        stack.push(ctx);
        int ruleIndex;
        StringBuilder h1 = new StringBuilder();
        StringBuilder h2 = new StringBuilder();
        StringBuilder line = new StringBuilder();
        int beforeLine = -1;
        while(!stack.empty()){
            ParseTree node = stack.pop();
            //beta优化: 按代码行序列相似求beta
            if(node instanceof RuleNode){
                int nodeIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if (RuleFilterForLine.ruleFilter().containsKey(nodeIndex)) {
                    ParserRuleContext ct = (ParserRuleContext)node;
                    int currentLine = ct.getStart().getLine();
                    if(beforeLine == -1){
                        beforeLine = currentLine;
                    }
                    if(currentLine != beforeLine){
                        line.deleteCharAt(line.length()-1);
                        line.append(";").append(nodeIndex+",");
                        beforeLine = currentLine;
                    }else {
                        line.append(nodeIndex+",");
                    }
                }
            }
            //Rule Node
            if(node instanceof RuleNode){
                ruleIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if (ccd.h1.RuleFilterForLine.ruleFilter().containsKey(ruleIndex)) {
                    h1.append(ruleIndex + ",");
                }
            }
            if(node instanceof RuleNode){
                ruleIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if(ruleIndex == Java8Parser.RULE_blockStatement){
                    ParserRuleContext ct = (ParserRuleContext)node;
                    //是否是直接从属方法的语句
                    int blockType = ct.getParent().getParent().getParent().getRuleContext().getRuleIndex();
                    if(blockType == Java8Parser.RULE_methodBody){
                        Stack<ParseTree> blockStack = new Stack<>();
                        blockStack.push(ct);
                        int blockRuleIndex;
                        while (!blockStack.empty()) {
                            ParseTree blockNode = blockStack.pop();
                            if (blockNode instanceof RuleNode) {
                                blockRuleIndex = ((RuleNode) blockNode).getRuleContext().getRuleIndex();
                                if (RuleFilterForLine.ruleFilter().containsKey(blockRuleIndex)) {
                                    h2.append(blockRuleIndex+",");
                                }
                                for (int len = blockNode.getChildCount(), i = len - 1; i >= 0; i--) {
                                    blockStack.push(blockNode.getChild(i));
                                }
                            }
                        }
                        h2.deleteCharAt(h2.length()-1);
                        h2.append(";");
                    }
                }
                for(int len = node.getChildCount(), i = len - 1; i >= 0; i --){
                    stack.push(node.getChild(i));
                }
            }
        }
        if(h1.length()>=1){//method h1
            h1.deleteCharAt(h1.length()-1);
        }
        if(h2.length()>=1){//method h2
            h2.deleteCharAt(h2.length()-1);
        }
        if(line.length()>=1){//method line
            line.deleteCharAt(line.length()-1).append(";");
        }
        String value = line.toString() +ccdSeparate+ h1.toString() + ccdSeparate + h2.toString();
        redis.set(key, value);

//        System.out.println("h1:");
//        System.out.println(h1.toString());
//        System.out.println("h2:");
//        String[] h2show = h2.toString().split(";");
//        for (int i = 0; i < h2show.length; i++) {
//            System.out.println((i+1)+": "+h2show[i]);
//        }
//        System.out.println("line:");
//        System.out.println(line.toString());
//        System.out.println("value: "+value);
//        System.out.println("=================================");

        return visitChildren(ctx);
    }

    public void setPathFilename(String pathFilename) {
        this.pathFilename = pathFilename;
    }
    public void setRedis(Jedis redis) {
        this.redis = redis;
    }
}

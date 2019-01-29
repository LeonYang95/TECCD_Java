package ccd;

import antlr.Java8BaseVisitor;
import antlr.Java8Lexer;
import antlr.Java8Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.*;

public class NewMethodVisitor extends Java8BaseVisitor<Integer> {
    private static int methodLimitedLine = Integer.valueOf(PropsLoader.getProperty("ccd.methodLimitedLine"));
    private int startLine;
    private String pathFilename;//方法所在文件的路径以及文件名
    private Jedis redis;

    @Override
    public Integer visitMethodHeader(Java8Parser.MethodHeaderContext ctx) {
        startLine = ctx.start.getLine();
        return visitChildren(ctx);
    }

    @Override
    public Integer visitBlockStatement(Java8Parser.BlockStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitMethodBody(Java8Parser.MethodBodyContext ctx) {
        int stopLine = ctx.stop.getLine();
        if((stopLine - startLine + 1) < methodLimitedLine)//方法代码行过滤阈值, 低于阈值的不参与检测
            return null;
        String key = pathFilename + "(" + startLine + "-" + stopLine + ")";
        Stack<ParseTree> stack = new Stack<>();
        stack.push(ctx);
        int ruleIndex;
        Map<Integer, List<String>> clMap = new HashMap<>();
        List<String> vectorSequence = new ArrayList<>();//方法规则结点的index序列
        while(!stack.empty()){
            ParseTree node = stack.pop();
            if(node instanceof TerminalNode){
                int tokenType = ((TerminalNode) node).getSymbol().getType();
                if(!(tokenType>=Java8Lexer.LPAREN && tokenType<=Java8Lexer.URSHIFT_ASSIGN)){
                    int line = ((TerminalNode) node).getSymbol().getLine();
                    if (!clMap.keySet().contains(line)) {
                        List<String> clList = new ArrayList<>();
                        clList.add(node.getText());
                        clMap.put(line, clList);
                    } else {
                        clMap.get(line).add(node.getText());
                    }
                }
            }
            if(node instanceof RuleNode){
                ruleIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if(RuleFilter.ruleFilter().containsKey(ruleIndex)){//过滤与克隆关系不大的规则结点
                    vectorSequence.add(ruleIndex+"");
                }
                for(int len = node.getChildCount(), i = len - 1; i >= 0; i --){
                    stack.push(node.getChild(i));
                }
            }
        }
        StringBuilder methodLineTokens = new StringBuilder();
        for (Map.Entry<Integer, List<String>> entry : clMap.entrySet()) {
            if(entry.getValue().size() > 0){
                String str = entry.getValue().toString();
                String lineTokens = str.substring(1, str.length()-1);
                methodLineTokens.append(lineTokens+";");
            }
        }
        redis.set(key, methodLineTokens+"ccdSeparate"+StringUtils.join(vectorSequence, ","));
        System.out.println(methodLineTokens+"ccdSeparate"+StringUtils.join(vectorSequence, ","));
        return visitChildren(ctx);
    }

    void setPathFilename(String pathFilename) {
        this.pathFilename = pathFilename;
    }

    void setRedis(Jedis redis) {
        this.redis = redis;
    }
}

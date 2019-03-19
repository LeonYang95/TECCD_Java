package ccd.h1;

import antlr.Java8BaseVisitor;
import antlr.Java8Lexer;
import antlr.Java8Parser;
import ccd.PropsLoader;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import redis.clients.jedis.Jedis;

import java.util.Stack;

public class MethodVisitorH1Token extends Java8BaseVisitor<Integer> {
    private static int methodLimitedLine = Integer.valueOf(PropsLoader.getProperty("ccd.methodLimitedLine"));
    private final String ccdSeparate = "ccdMethodSeparate";
    private int startLine;
    private String pathFilename;//方法所在文件的路径以及文件名
    private Jedis redis;

//    @Override
//    public Integer visitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
//        startLine = ctx.start.getLine();
//        return visitChildren(ctx);
//    }

    @Override
    public Integer visitMethodHeader(Java8Parser.MethodHeaderContext ctx) {
        startLine = ctx.start.getLine();
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
        StringBuilder statement = new StringBuilder();
        StringBuilder line = new StringBuilder();
        int beforeLine = -1;
        while(!stack.empty()){
            ParseTree node = stack.pop();
            //beta优化: 按代码行序列相似求beta
            //token
            if(node instanceof TerminalNode){
                int tokenType = ((TerminalNode) node).getSymbol().getType();
                if(!(tokenType>= Java8Lexer.LPAREN && tokenType<=Java8Lexer.URSHIFT_ASSIGN)){
                    if(RuleFilterForLine.tokenFilter().containsKey(tokenType)){
                        tokenType = Java8Lexer.INT;
                    }
                    ParserRuleContext ct = (ParserRuleContext)node.getParent();
                    int currentLine = ct.getStart().getLine();
                    if(beforeLine == -1){
                        beforeLine = currentLine;
                    }
                    if(currentLine != beforeLine){
                        line.deleteCharAt(line.length()-1);
                        line.append(";").append(tokenType+",");
                        beforeLine = currentLine;
                    }else {
                        line.append(tokenType+",");
                    }
                }
            }
            //Rule Node
            if(node instanceof RuleNode){
                ruleIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if (RuleFilterForLine.ruleFilter().containsKey(ruleIndex)) {
                    statement.append(ruleIndex + ",");
                }
                for(int len = node.getChildCount(), i = len - 1; i >= 0; i --){
                    stack.push(node.getChild(i));
                }
            }
        }
        if(statement.length()>=1){//method statements
            statement.deleteCharAt(statement.length()-1);
        }
        if(line.length()>=1){//method line
            line.deleteCharAt(line.length()-1).append(";");
        }
        String value = line.toString() +ccdSeparate+ statement.toString();
        redis.set(key, value);
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

package ccd.linenode;

import antlr.Java8BaseVisitor;
import antlr.Java8Parser;
import ccd.PropsLoader;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import redis.clients.jedis.Jedis;

import java.util.Stack;

public class LineVisitor extends Java8BaseVisitor<Integer> {
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
    public Integer visitMethodBody(Java8Parser.MethodBodyContext ctx) {
        int stopLine = ctx.stop.getLine();
        if((stopLine - startLine + 1) < methodLimitedLine)//方法代码行过滤阈值, 低于阈值的不参与检测
            return null;
        String key = pathFilename + "(" + startLine + "-" + stopLine + ")";
        Stack<ParseTree> stack = new Stack<>();
        stack.push(ctx);
        StringBuilder linenodes = new StringBuilder();
        int beforeLine = -1;
        while(!stack.empty()){
            ParseTree node = stack.pop();
            if(node instanceof RuleNode){
                int nodeIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if (RuleFilterForLine.ruleFilter().containsKey(nodeIndex)) {
                    ParserRuleContext ct = (ParserRuleContext)node;
                    int currentLine = ct.getStart().getLine();
                    if(beforeLine == -1){
                        beforeLine = currentLine;
                    }
                    if(currentLine != beforeLine){
                        linenodes.deleteCharAt(linenodes.length()-1);
                        linenodes.append(";").append(nodeIndex+",");
                        beforeLine = currentLine;
                    }else {
                        linenodes.append(nodeIndex+",");
                    }
                }
            }
            for(int len = node.getChildCount(), i = len - 1; i >= 0; i --){
                stack.push(node.getChild(i));
            }
        }
        if(linenodes.length()>=1){//method line
            linenodes.deleteCharAt(linenodes.length()-1);
        }
        String value = linenodes.toString();
        String[] show = linenodes.toString().split(";");
//        for (int i = 0; i < show.length; i++) {
//            System.out.println((i+1)+": "+show[i]);
//        }
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

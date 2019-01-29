package ccd;

import antlr.Java8BaseVisitor;
import antlr.Java8Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.*;

public class MethodVisitor extends Java8BaseVisitor<Integer> {
    private static int methodLimitedLine = Integer.valueOf(PropsLoader.getProperty("ccd.methodLimitedLine"));
    private int startLine;
    private String pathFilename;//方法所在文件的路径以及文件名
    private Jedis redis;


    @Override
    public Integer visitMethodHeader(Java8Parser.MethodHeaderContext ctx) {
        startLine = ctx.start.getLine();
        return startLine;
    }

    @Override
    public Integer visitMethodBody(Java8Parser.MethodBodyContext ctx){
        int stopLine = ctx.stop.getLine();
        if((stopLine - startLine + 1) < methodLimitedLine)//方法代码行过滤阈值, 低于阈值的不参与检测
            return null;
        String key = pathFilename + "(" + startLine + "-" + stopLine + ")";
        List<String> vectorSequence = new ArrayList<>();//方法规则结点的index序列
        Stack<ParseTree> stack = new Stack<>();
        stack.push(ctx);
        Integer ruleIndex;

        while(!stack.empty()){
            ParseTree node = stack.pop();
            if(node instanceof RuleNode){
                ruleIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if(RuleFilter.ruleFilter().containsKey(ruleIndex)){
                    vectorSequence.add(ruleIndex+"");
                }
                for(int len = node.getChildCount(), i = len - 1; i >= 0; i --){
                    stack.push(node.getChild(i));
                }
            }
        }
        redis.set(key, StringUtils.join(vectorSequence, ","));
        return visitChildren(ctx);
    }

    public void setPathFilename(String pathFilename) {
        this.pathFilename = pathFilename;
    }

    public void setRedis(Jedis redis) {
        this.redis = redis;
    }
}
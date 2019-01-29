package ccd;


import antlr.Java8BaseVisitor;
import antlr.Java8Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import util.RedisUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MethodVisitor extends Java8BaseVisitor<Integer> {
    public static final int LIMITED_LINE = 10;//方法代码行过滤阈值, 低于阈值的不参与检测
    private String pathFilename;//方法所在文件的路径以及文件名

    int startLine = 0;
    int stopLine = 0;
//    Jedis jedis = RedisUtil.getInstance();

    @Override
    public Integer visitMethodHeader(Java8Parser.MethodHeaderContext ctx) {
        startLine = ctx.start.getLine();
        return visitChildren(ctx);
    }

    @Override
    public Integer visitMethodBody(Java8Parser.MethodBodyContext ctx){
        stopLine = ctx.stop.getLine();
        if((stopLine - startLine + 1) < LIMITED_LINE){return null;}
        String key = pathFilename + "(" + startLine + "-" + stopLine + ")";
        Stack<ParseTree> stack = new Stack<>();
        List<String> rulenodenames = new ArrayList<>();
        List<String> showNodeSeq = new ArrayList<>();
        stack.push(ctx);
        Integer ruleIndex;
        while(!stack.empty()){
            ParseTree node = stack.pop();
            if(node instanceof RuleNode){
                ruleIndex = ((RuleNode) node).getRuleContext().getRuleIndex();
                if(RuleFilter.ruleFilter().containsKey(ruleIndex)){
                    String roleName = RuleFilter.ruleFilter().get(((RuleNode) node).getRuleContext().getRuleIndex());
                    rulenodenames.add(roleName);
//                    showNodeSeq.add(RuleFilter.ruleFilter().get(((RuleNode) node).getRuleContext().getRuleIndex()));
                }
                for(int len = node.getChildCount(), i = len - 1; i >= 0; i --){
                    stack.push(node.getChild(i));
                }
            }
        }
        try {
            PrintWriter file = new PrintWriter(new FileOutputStream("F:\\ccd_experiment\\data\\maven.txt", true));
            for(int i = 0; i < rulenodenames.size(); i++){
                file.print(rulenodenames.get(i)+" ");
            }
            file.println();
            file.flush();
            file.close();
        }catch (Exception e){
            e.printStackTrace();
        }

//        String value = StringUtils.join(vectorSequence, ",");
//        jedis.set(key, value);
        return visitChildren(ctx);
    }


    public String getPathFilename() {
        return pathFilename;
    }
    public void setPathFilename(String pathFilename) {
        this.pathFilename = pathFilename;
    }
}
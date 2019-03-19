package ccd;

import antlr.Java8Lexer;
import antlr.Java8Parser;
import ccd.blockstat.BlockStatVisitor;
import ccd.h1.MethodVisitorH1RuleNode;
import ccd.h1.MethodVisitorH1Token;
import ccd.h1h2.MethodVisitorH1H2;
import ccd.h2.MethodVisitorH2RuleNode;
import ccd.linenode.LineVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import redis.clients.jedis.Jedis;
import util.RedisUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WorkThread extends Thread{
    private List<String> fileList;
    private int threadId;

    public WorkThread(List<String> fileList, int threadId) {
        this.fileList = fileList;
        this.threadId = threadId;
    }

    public void run(){
        CharStream inputStream;
        Java8Parser parser;
        ParseTree parseTree;
//        MethodVisitorH1RuleNode methodVisitor = new MethodVisitorH1RuleNode();
//        MethodVisitorH2 methodVisitor = new MethodVisitorH2();
//        LineVisitor methodVisitor = new LineVisitor();
        MethodVisitorH1RuleNode methodVisitor = new MethodVisitorH1RuleNode();
//        MethodVisitorH2RuleNode methodVisitor = new MethodVisitorH2RuleNode();
//        BlockStatVisitor methodVisitor = new BlockStatVisitor();
//        MethodVisitorH1H2 methodVisitor = new MethodVisitorH1H2();
        Jedis redis = RedisUtil.getJedis();
        int fileSize = fileList.size();
        int i = 0;
        for (String file : fileList) {
            try {
                inputStream = CharStreams.fromFileName(file);
                parser = new Java8Parser(new CommonTokenStream(new Java8Lexer(inputStream)));
                parseTree = parser.compilationUnit();
                methodVisitor.setPathFilename(file);
                methodVisitor.setRedis(redis);
                methodVisitor.visit(parseTree);
//                是否对扫描过的文件进行删除
//                File f = new File(file);
//                if(f.exists()&&f.isFile())
//                    f.delete();
                i++;
                System.out.println("thread"+threadId+": "+i+"/"+fileSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread"+threadId+"结束时间: "+new SimpleDateFormat("yyy-MM-dd hh:mm:ss")
                .format(new Date(System.currentTimeMillis())));
        RedisUtil.returnResource(redis);
    }
}

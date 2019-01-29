import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TThread {
    @Test
    public void testDistributeTask(){
        List<String> fileList = new ArrayList<>();
        fileList.add("a");
        fileList.add("b");
        fileList.add("c");
        fileList.add("d");
        fileList.add("e");
        fileList.add("f");
        fileList.add("g");
        fileList.add("h");
        fileList.add("i");
        fileList.add("j");
        fileList.add("k");
        fileList.add("l");
        fileList.add("m");
        fileList.add("n");
        fileList.add("o");
        fileList.add("p");
        //分发解析任务给4个线程, 并执行解析
        List<String>[] taskListPerThread = distributeTasks(fileList, 4);
        for (int i = 0; i < taskListPerThread.length; i++) {
            System.out.println("index:"+(i+1));
            for (int j = 0; j < taskListPerThread[i].size(); j++) {
                System.out.println(taskListPerThread[i].get(j));
            }
        }
    }

    public static List<String>[] distributeTasks(List<String> fileList, int threadCount) {
        int fileSize = fileList.size();
        int minTaskCount = fileList.size() / threadCount;
        int remainTaskCount = fileList.size() % threadCount;
        int actualThreadCount = minTaskCount > 0 ? threadCount:remainTaskCount;
        List<String>[] taskListPerThread = new List[actualThreadCount];
        int partition = fileSize / actualThreadCount;
        for (int i = 0; i < taskListPerThread.length; i++) {
            int index =  partition * i;
            System.out.println(index+" "+(index+partition));
            taskListPerThread[i] = new ArrayList<>();
            taskListPerThread[i].addAll(fileList.subList(index, index + partition));
        }
        if(remainTaskCount > 0){
            taskListPerThread[taskListPerThread.length - 1].addAll(fileList.subList(fileSize-remainTaskCount, fileSize));
        }
        return taskListPerThread;
    }

}

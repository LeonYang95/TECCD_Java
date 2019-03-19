import org.junit.Test;
import util.CSVUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TEva {

    @Test
    public void testEva(){
//        List<String> detectdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\baoji.csv"));
        List<String> detectdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\MethodVisitorH1RuleNodelenv.csv"));
//        List<String> detectdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\LineVisitor.csv"));

//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_jedit.csv"));
//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_opennlp.csv"));
        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_ant.csv"));
//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_maven.csv"));
//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_common.csv"));
//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_jdk.csv"));

        System.out.println("detectdata: "+detectdata.size());
        System.out.println("benchdata: "+benchdata.size());
        int tpnum = 0;
        for (int i = 0; i < detectdata.size(); i++) {
            for (int j = 0; j < benchdata.size(); j++) {
                if(isEqual(detectdata.get(i), benchdata.get(j))){
                    tpnum ++;
                }
            }
        }
////        FP:
//        for (int i = 0; i < detectdata.size(); i++) {
//            System.out.print("i: "+i+", ");
//            for (int j = 0; j < benchdata.size(); j++) {
//                if(isEqual(detectdata.get(i), benchdata.get(j))){
//                    System.out.println("tpnum: "+tpnum);
//                }
//            }
//        }
//        System.out.println("error: ");
//        System.out.println(detectdata.get(0));
//        System.out.println(detectdata.get(3));
//        System.out.println(detectdata.get(13));
//        F:\ccd_experiment\final\ant_1.10.1\,EchoProperties.java,481,511,F:\ccd_experiment\final\ant_1.10.1\,Depend.java,217,245
//        F:\ccd_experiment\final\ant_1.10.1\,EchoProperties.java,481,511,F:\ccd_experiment\final\ant_1.10.1\,ResourceUtils.java,769,805
//        F:\ccd_experiment\final\ant_1.10.1\,Delete.java,755,776,F:\ccd_experiment\final\ant_1.10.1\,TokenFilter.java,373,402
//        System.out.println(detectdata.get(21));


        for (int i = 0; i < benchdata.size(); i++) {
            System.out.print("i: "+i+", ");
            for (int j = 0; j < detectdata.size(); j++) {
                if(isEqual(benchdata.get(i), detectdata.get(j))){
                    System.out.println("*******: ");
                }
            }
        }
//
        System.out.println("miss: ");
        System.out.println(benchdata.get(1));
        System.out.println(benchdata.get(2));
        System.out.println(benchdata.get(5));
        System.out.println(benchdata.get(6));
        System.out.println(benchdata.get(19));
        System.out.println(benchdata.get(18));
        System.out.println(benchdata.get(65));
        System.out.println(benchdata.get(169));


        System.out.println("tpnum: "+tpnum);
        double recall = (double)tpnum / (double)benchdata.size();
        double precision = (double)tpnum / (double)detectdata.size();

        System.out.println("recall: "+recall);
        System.out.println("precision: "+precision);

    }

    public boolean isEqual(String l, String r){
        String[] as = l.split(",");
        String dleft = as[0] + as[1] + as[2] + as[3];
        String dright = as[4] + as[5] + as[6] + as[7];
        String[] bs = r.split(",");
        String bleft = bs[0] + bs[1] + bs[2] + bs[3];
        String bright = bs[4] + bs[5] + bs[6] + bs[7];
        boolean left = dleft.equals(bleft) && dright.equals(bright);
        boolean right = dleft.equals(bright) && dright.equals(bleft);
        return left || right;
    }

}

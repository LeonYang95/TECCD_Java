import org.junit.Test;
import util.CSVUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TEva {

    @Test
    public void testEva(){
        List<String> detectdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\result.csv"));

//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_jedit.csv"));
        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_opennlp.csv"));
//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_ant.csv"));
//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_maven.csv"));
//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_common.csv"));
//        List<String> benchdata = CSVUtils.importCsv(new File("C:\\Users\\Administrator\\Desktop\\exp\\bench\\bench_jdk.csv"));

        System.out.println("detectdata: "+detectdata.size());
        System.out.println("benchdata: "+benchdata.size());
        int tpnum = 0;
        for (int i = 0; i < detectdata.size(); i++) {
//            System.out.print("i: "+i+", ");
            for (int j = 0; j < benchdata.size(); j++) {
                if(isEqual(detectdata.get(i), benchdata.get(j))){
                    tpnum ++;
//                    System.out.println("tpnum: "+tpnum);
                }
            }
        }

//        System.out.println(detectdata.get(6));
//        System.out.println(detectdata.get(18));
//        System.out.println(detectdata.get(20));
//        System.out.println(detectdata.get(21));


//        for (int i = 0; i < benchdata.size(); i++) {
//            System.out.print("i: "+i+", ");
//            for (int j = 0; j < detectdata.size(); j++) {
//                if(isEqual(benchdata.get(i), detectdata.get(j))){
//                    System.out.println("*******: ");
//                }
//            }
//        }

//        System.out.println("miss: ");
//        System.out.println(benchdata.get(1363));
//        System.out.println(benchdata.get(1364));
//        System.out.println(benchdata.get(1365));
//        System.out.println(benchdata.get(1347));
//        System.out.println(benchdata.get(1348));
//        System.out.println(benchdata.get(1349));

        System.out.println("tpnum: "+tpnum);
        double recall = (double)tpnum / (double)benchdata.size();
        double precision = (double)tpnum / (double)detectdata.size();

        System.out.println("recall: "+recall);
        System.out.println("precision: "+precision);

    }

    public boolean isEqual(String l, String r){
        String[] as = l.split(",");
        String dleft = as[0] + as[1] + as[2];
        String dright = as[3] + as[4] + as[5];
        String[] bs = r.split(",");
        String bleft = bs[0] + bs[1] + bs[2];
        String bright = bs[3] + bs[4] + bs[5];

        boolean left = dleft.equals(bleft) && dright.equals(bright);
        boolean right = dleft.equals(bright) && dright.equals(bleft);

        return left || right;

    }

//    i: 1239, i: 1240, *******:
//    i: 1241, *******:
//    i: 1242, *******:
//    i: 1243, *******:
//    i: 1244, i: 1245, *******:
//    i: 1246, *******:
//    i: 1247, *******:
//    i: 1248, i: 1249, *******:
//    i: 1250, i: 1251, *******:
//    i: 1252, *******:
//    i: 1253, *******:
//    i: 1254, *******:
//    i: 1255, *******:
//    i: 1256, i: 1257, i: 1258, *******:
//    i: 1259, i: 1260, i: 1261, i: 1262, *******:
//    i: 1263, *******:
//    i: 1264, i: 1265, *******:
//    i: 1266, i: 1267, *******:
//    i: 1268, i: 1269, i: 1270, i: 1271, *******:
//    i: 1272, *******:
//    i: 1273, *******:
//    i: 1274, *******:
//    i: 1275, *******:
//    i: 1276, *******:
//    i: 1277, i: 1278, *******:
//    i: 1279, i: 1280, i: 1281, *******:
//    i: 1282, i: 1283, *******:
//    i: 1284, *******:
//    i: 1285, i: 1286, i: 1287, *******:
//    i: 1288, i: 1289, i: 1290, i: 1291, *******:
//    i: 1292, i: 1293, *******:
//    i: 1294, *******:
//    i: 1295, *******:
//    i: 1296, *******:
//    i: 1297, *******:
//    i: 1298, i: 1299, *******:
//    i: 1300, *******:
//    i: 1301, *******:
//    i: 1302, i: 1303, i: 1304, *******:
//    i: 1305, *******:
//    i: 1306, i: 1307, *******:
//    i: 1308, i: 1309, i: 1310, *******:
//    i: 1311, *******:
//    i: 1312, *******:
//    i: 1313, i: 1314, i: 1315, *******:
//    i: 1316, *******:
//    i: 1317, *******:
//    i: 1318, *******:
//    i: 1319, i: 1320, *******:
//    i: 1321, *******:
//    i: 1322, *******:
//    i: 1323, *******:
//    i: 1324, i: 1325, *******:
//    i: 1326, i: 1327, i: 1328, *******:
//    i: 1329, *******:
//    i: 1330, *******:
//    i: 1331, *******:
//    i: 1332, *******:
//    i: 1333, i: 1334, *******:
//    i: 1335, *******:
//    i: 1336, *******:
//    i: 1337, i: 1338, i: 1339, *******:
//    i: 1340, *******:
//    i: 1341, *******:
//    i: 1342, *******:
//    i: 1343, *******:
//    i: 1344, *******:
//    i: 1345, *******:
//    i: 1346, *******:
//    i: 1347, i: 1348, i: 1349, i: 1350, i: 1351, i: 1352, i: 1353, *******:
//    i: 1354, *******:
//    i: 1355, *******:
//    i: 1356, *******:
//    i: 1357, i: 1358, i: 1359, i: 1360, i: 1361, *******:
//    i: 1362, *******:
//    i: 1363, *******:
//    i: 1364, i: 1365, i: 1366, i: 1367, i: 1368, i: 1369, *******:
}

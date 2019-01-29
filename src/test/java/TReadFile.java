import ccd.PropsLoader;
import org.junit.Test;
import util.FileUtil;

import java.util.List;

public class TReadFile {

    @Test
    public void testReadJavaFile(){
        String path = PropsLoader.getProperty("ccd.path");
        String fileType = PropsLoader.getProperty("ccd.fileType");
        FileUtil fileUtil = new FileUtil();
        List<String> fileList = fileUtil.readfile(path, fileType);
        System.out.println("文件个数:"+fileList.size());
        System.out.println("fileList: "+fileList);
        for (String file:fileList) {
            System.out.println(file);
        }
    }
}

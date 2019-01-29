package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    /**
     * 读取某个文件夹下的所有文件
     */
    List<String> fileNames = new ArrayList<>();
    public List<String> readfile(String filePath, String fileType){
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return fileNames;
            }
            if (!file.isDirectory()) {//给的就是一个文件
                String fileName = file.getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                if(suffix.equals(fileType)){
                    fileNames.add(filePath + File.separator + file);
                }
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filePath + File.separator + filelist[i]);
                    if (!readfile.isDirectory()) {
                        String fileName = readfile.getName();
                        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                        if(suffix.equals(fileType)){
                            fileNames.add(filePath + File.separator + filelist[i]);
                        }

                    } else if (readfile.isDirectory()) {
                        readfile(filePath + File.separator + filelist[i], fileType);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileNames;
    }

}
package ccd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsLoader {
    private static Properties properties;

    static{
        try {
            String rootPath = System.getProperty("user.dir").replace("\\", "/");
            FileInputStream in = new FileInputStream(rootPath+"/config.properties");
            properties = new Properties();
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}

package org.TREE.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    static FileInputStream fs;
    static Properties prop = new Properties();

    public static String getConfigValue(String fileName, String configKey) {
        try {
            fs = new FileInputStream(fileName);
            prop.load(fs);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return prop.getProperty(configKey);
    }
}



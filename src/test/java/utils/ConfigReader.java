package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final static Properties properties;

    static {
        try (InputStream in = new FileInputStream("config.properties")) {
            properties = new Properties();
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot find properties file!");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

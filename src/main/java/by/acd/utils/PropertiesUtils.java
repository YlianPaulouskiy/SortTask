package by.acd.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (var inputStream = PropertiesUtils.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

}

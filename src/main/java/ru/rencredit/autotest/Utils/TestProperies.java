package ru.rencredit.autotest.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperies {
    private final Properties properties = new Properties();
    private static TestProperies INSTANCE = null;

    private TestProperies() {
        try {
            File file = new File("settings.properties");
            InputStream is = new FileInputStream(file);
            properties.load(is);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public static TestProperies getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TestProperies();
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}
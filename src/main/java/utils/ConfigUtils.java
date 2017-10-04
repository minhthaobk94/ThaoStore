package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Config {
    void getConfiguration() {
        Properties properties = new Properties();
        OutputStream out = null;
        try {
            out = new FileOutputStream("config.properties");
            properties.setProperty("datasource.driver-class-name", "com.mysql.jdbc.Driver");
            properties.setProperty("datasource.url", "jdbc:mysql://localhost/thaotodo?user=root&password=123456");
            properties.setProperty("datasource.username", "root");
            properties.setProperty("datasource.password", "123456");

            properties.store(out, "null");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}

package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    InputStream in = null;
    Properties properties = new Properties();

    public String getDataSourceUrl() {
        String dataSourceUrl = "";
        try {
            in = getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(in);
            dataSourceUrl = properties.getProperty("datasource.url");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataSourceUrl;
    }

    public String getDriverClassName() {
        String driverClassName = "";
        in = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(in);
            driverClassName = properties.getProperty("datasource.driver-class-name");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return driverClassName;
    }

    private String getUsername() {
        String userName = "";
        in = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(in);
            userName = properties.getProperty("datasource.username");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userName;
    }

    private String getPassword() {
        String userName = "";
        in = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(in);
            userName = properties.getProperty("datasource.password");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userName;
    }
}

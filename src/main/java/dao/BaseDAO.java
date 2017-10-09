package dao;

import utils.ConfigUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO implements DataSource {
    private Connection connection;
    ConfigUtils configUtils = new ConfigUtils();

    public BaseDAO() {
        connection = this.connect();
    }

    private Connection connect() {
        Connection connection = null;
        try {
            Class.forName(configUtils.getDriverClassName());
            connection = DriverManager.getConnection(configUtils.getDataSourceUrl());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

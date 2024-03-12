package com.movie.app.configs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseConfiguration {

    private static DatabaseConfiguration INSTANCE;
    private static ArrayList<IEntityBuider> entities;

    private static Connection connection;

    private String url;
    private String user;
    private String password;

    private DatabaseConfiguration() {
    }

    private DatabaseConfiguration(String host, int port, String user, String password, String dbName) {
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        this.user = user;
        this.password = password;
    }

    public static DatabaseConfiguration config(String host, int port, String user, String password, String dbName) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseConfiguration(host, port, user, password, dbName);
            entities = new ArrayList<>();
        }
        return INSTANCE;
    }

    public Connection connect() {
        this.close();
        try {
            DatabaseConfiguration.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            System.exit(-1);
        }
        return DatabaseConfiguration.connection;
    }

    public void close() {
        if (DatabaseConfiguration.connection != null) {
            try {
                DatabaseConfiguration.connection.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                System.exit(-1);
            }
        }
    }

    public DatabaseConfiguration addEntity(IEntityBuider entityBuider) {
        DatabaseConfiguration.entities.add(entityBuider);
        return INSTANCE;
    }

    public void buildEntity() {
        entities.forEach((entity) -> {
            try {
                DBQuery dBQuery = new DBQuery(INSTANCE);
                dBQuery.exec_query(entity.toString());
            } catch (SQLException ex) {
                INSTANCE.close();
                System.out.println("Error: " + ex);
                System.exit(-1);
            }
        });
    }

    public void log() {
        System.out.println("Check connection: " + DatabaseConfiguration.connection);
    }
}

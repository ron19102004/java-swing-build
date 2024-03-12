package com.movie.app.configs.db;

import com.movie.app.configs.ApplicationConfiguration;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DBQuery {

    private final DatabaseConfiguration dbConfig;

    public DBQuery() {
        this.dbConfig = ApplicationConfiguration.getInstance().databaseConfiguration();
    }

    public DBQuery(DatabaseConfiguration dbConfig) {
        this.dbConfig = dbConfig;
    }

    public boolean exec_query(String query) throws SQLException {
        int affectedRecords = 0;
        try {
            PreparedStatement preparedStatement = this.dbConfig.connect().prepareStatement(query);
            affectedRecords = preparedStatement.executeUpdate();
        } finally {
            this.dbConfig.close();
        }
        return affectedRecords > 0;
    }

    public boolean update(String query, Map<String, Object> data) throws SQLException {
        int affectedRecords = 0;
        try {
            PreparedStatement preparedStatement = this.dbConfig.connect().prepareStatement(query);
            int indexParam = 0;
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                indexParam += 1;
                preparedStatement.setObject(indexParam, entry.getValue());
            }
            affectedRecords = preparedStatement.executeUpdate();
        } finally {
            this.dbConfig.close();
        }
        return affectedRecords > 0;
    }

    public boolean save(String tableName, Map<String, Object> data) throws SQLException {
        int affectedRecords = 0;
        int indexParam = 0;
        StringBuilder query = new StringBuilder();
        query
                .append("INSERT INTO ")
                .append(tableName)
                .append("(");
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            indexParam++;
            query
                    .append("`")
                    .append(tableName)
                    .append(".")
                    .append(entry.getKey())
                    .append("`");
            if (indexParam == data.size()) {
                query.append(")");
            } else {
                query.append(",");
            }
        }
        query.append(" VALUES (");
        while (indexParam > 0) {
            query.append("?");
            if (indexParam != 1) {
                query.append(",");
            } else {
                query.append(" )");
            }
            indexParam--;
        }
        try {
            PreparedStatement preparedStatement = this.dbConfig.connect().prepareStatement(query.toString());
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                indexParam++;
                preparedStatement.setObject(indexParam, entry.getValue());
            }
            affectedRecords = preparedStatement.executeUpdate();
        } finally {
            this.dbConfig.close();
        }
        return affectedRecords > 0;
    }
}

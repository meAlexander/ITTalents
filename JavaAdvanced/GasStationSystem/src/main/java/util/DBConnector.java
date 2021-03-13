package util;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static DBConnector instance;
    private Connection connection;
    private DBCredentials credentials;

    public static DBConnector getInstance() {
        if (DBConnector.instance == null) {
            DBConnector.instance = new DBConnector();
        }
        return DBConnector.instance;
    }

    private DBConnector() {
        loadCredentials();
        if (this.credentials != null) {
            initConnection();
        }
    }

    private void initConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + credentials.host + ":" + credentials.port + "/" + credentials.schema, credentials.username, credentials.password);
            System.out.println("Connection initialized!");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to use MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error communicating with MySQL Database. " + e.getMessage());
        }
    }

    private static class DBCredentials {
        private String host;
        private int port;
        private String username;
        private String password;
        private String schema;
    }

    private void loadCredentials() {
        Gson gson = new Gson();
        try {
            DBCredentials credentials = gson.fromJson(new FileReader("db_settings.json"), DBCredentials.class);
            if (credentials == null) {
                System.out.println("Credentials missing in configuration file");
                return;
            }
            this.credentials = credentials;
        } catch (FileNotFoundException e) {
            System.out.println("Error reading credentials. " + e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                initConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Closing connection failed - " + e.getMessage());
        }
        this.connection = null;
    }
}
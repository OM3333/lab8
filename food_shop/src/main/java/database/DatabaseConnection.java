package database;

import pl.umcs.oop.lec7.database.DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements DataConnection {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

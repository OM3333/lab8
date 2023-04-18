package pl.umcs.oop.lec7.database;

import java.sql.Connection;

public interface DataConnection {
    public Connection getConnection();
    public void connect();
    public void disconnect();
}

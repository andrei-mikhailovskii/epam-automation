package db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static java.sql.Connection con;

    private static void registerDriver() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver registered");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found" + e);
        }
    }

    private static java.sql.Connection create() {
        registerDriver();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=TA_DB;encrypt=false;trustServerCertificate=true;user=user1;password=qwerty123!");
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.err.println("Connection failed " + e);
        }
        return con;
    }

    // if connection is null, then create new connection
    public static java.sql.Connection getConnection() {
        if (con == null) return create();
        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                System.err.println("Connection closing error");
            }
        }
    }
}

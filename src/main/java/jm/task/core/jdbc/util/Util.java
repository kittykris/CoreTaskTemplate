package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static Connection connection = makeJDBCConnection();

    private static Connection makeJDBCConnection() {
        if (connection == null) {
            try {
                Class.forName(MYSQL_DRIVER);
                connection = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Problem with connection");
            }
        }
        return connection;
    }

    public static Connection getJDBCConnection() {
        return connection;
    }
}

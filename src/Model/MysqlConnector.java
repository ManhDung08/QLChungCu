
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Using Singleton Pattern to optimize this class
public class MysqlConnector {
    private static MysqlConnector instance = null;
    private Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/qlchungcu";
    private final String userName = "root";
    private final String password = "";

    private MysqlConnector() {
        // Private constructor to prevent external instantiation.
    }

    public static MysqlConnector getInstance() {
        if (instance == null) {
            instance = new MysqlConnector();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }

    public void closeDB() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
}
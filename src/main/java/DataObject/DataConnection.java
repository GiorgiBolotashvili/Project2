package DataObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    Connection connection = null;

    String url = "jdbc:sqlserver://DESKTOP-RAKV3PT;Database=Users";
    String user = "TestAutomation";
    String password = "TestAutomation123";

    public Connection CreateConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            System.out.println("Error cennecting to the database");
            throwables.printStackTrace();
        }

        System.out.println("CreateConnection");
        return connection;
    }
}

package rs.itbootcamp.connection; /**
 * Project KitchenSQL, Package PACKAGE_NAME, Class DatabaseConnection, Created by Milovan 14.9.2021.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn = null;

    static{
        String url = "jdbc:postgresql://localhost:5432/our_kitchen?user=postgres&password=sqlroot";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}


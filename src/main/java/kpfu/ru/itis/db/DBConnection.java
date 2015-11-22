package kpfu.ru.itis.db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static java.sql.Connection con = null;
    static {
        try {
            Class.forName(Provider.DRIVER);
            con = DriverManager.getConnection(Provider.CONNECTION_URL, Provider.USERNAME, Provider.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static java.sql.Connection getCon() {
        return con;
    }
}

import config.DbConnectionConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            testConnectToDatabase(DbConnectionConfig.getDbHost(), DbConnectionConfig.getDbUsername(), DbConnectionConfig.getDbUserPassword(), DbConnectionConfig.getJdbcDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testConnectToDatabase(String dbHost, String dbUser, String dbPassword, String jdbc) throws SQLException {
        Connection dbConnecttion = null;
        try {
            Class.forName(jdbc);
            dbConnecttion = DriverManager.getConnection(dbHost, dbUser, dbPassword);

            if (dbConnecttion != null) {
                System.out.println("Veritabanına baglanıldı");
                dbConnecttion.close();
            } else {
                System.out.println("Veritabanına erişim hatalı");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbConnecttion != null) {
                dbConnecttion.close();
            }
        }
    }
}

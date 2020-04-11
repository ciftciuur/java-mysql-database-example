package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionManagement {

    /*
        bu metod final olarak belırlenmıs ," dbhost-dbusername-dbpassword-dbjdbc " 4 parametre ile bir conneciton nesnesi oluşturur ve bu nesneyi döner
     */
    public static Connection connectToDatabase() {
        Connection dbConnection = null;
        try {
            Class.forName(DbConnectionConfigParam.getJdbcDriver());
            dbConnection = DriverManager.getConnection(DbConnectionConfigParam.getDbHost(), DbConnectionConfigParam.getDbUsername(), DbConnectionConfigParam.getDbUserPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbConnection;
    }


    /*
        Bu metod dışarıdan verılen açık database baglantısını kapatır
     */
    public static void killDbConnection(Connection connection) throws SQLException {
        //veritabanı baglantısı hala mevcutsa baglantıyı yok eder
        if (connection != null) {
            connection.close();
            System.out.println("Veritabanı bağlantısı silindi");
        }

    }
}

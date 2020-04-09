package config;

public class DbConnectionConfig {

    private final static String DB_HOST = "jdbc:mysql://remotemysql.com:3306/BiEfcKCYFs?useSSL=false";
    private final static String DB_USERNAME = "BiEfcKCYFs";
    private final static String DB_USER_PASSWORD = "iVm6eDkLab";
    private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static String getDbHost() {
        return DB_HOST;
    }

    public static String getDbUsername() {
        return DB_USERNAME;
    }

    public static String getDbUserPassword() {
        return DB_USER_PASSWORD;
    }

    public static String getJdbcDriver() {
        return JDBC_DRIVER;
    }
}

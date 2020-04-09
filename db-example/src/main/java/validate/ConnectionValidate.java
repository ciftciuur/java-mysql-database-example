package validate;

import java.sql.Connection;

public class ConnectionValidate {


    public static boolean validateConnection(Connection connection) {
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }
}

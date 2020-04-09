import config.DbConnectionManagement;
import entity.Employee;
import query.InsertQueryApi;
import query.SelectQueryApi;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            Employee tempEmployee = new Employee("Ahmet", "Aksoy", "M", new Date(), new Date());
            Connection connection = DbConnectionManagement.connectToDatabase();
            InsertQueryApi.insertOneRecord(tempEmployee, connection);
            DbConnectionManagement.killDbConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}

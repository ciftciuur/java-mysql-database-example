package query;

import config.DbConnectionManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteQueryApi {


    public static void deleteRecord(int recordId) {
        try {
            PreparedStatement preparedStatement = DbConnectionManagement.connectToDatabase().prepareStatement("DELETE FROM employee WHERE id= ?");

            if (SelectQueryApi.findByEmployeeId(recordId) != null) {//bu recordId'de kayıt varsa eğer
                preparedStatement.setInt(1, recordId);
                int deleteRowCount = preparedStatement.executeUpdate();
                System.out.println(deleteRowCount + "rows deleted !");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

package query;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteQueryApi {


    public static void deleteRecord(int recordId, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id= ?");

            if (SelectQueryApi.findByEmployeeId(recordId, connection) != null) {//bu recordId'de kayıt varsa eğer
                preparedStatement.setInt(1, recordId);
                int deleteRowCount = preparedStatement.executeUpdate();
                System.out.println(deleteRowCount + "rows deleted !");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

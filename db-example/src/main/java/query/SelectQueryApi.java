package query;

import entity.Employee;
import validate.ConnectionValidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQueryApi {


    /*
         bu fonksiyon dışarıdan gelen tablo içindeki en son kaydın recordId'sını döner
         fonksiyonun yazılma nedeni kayıt eklenirken son id'li kaydın recordId'sını 1 arttırabılmek için
     */
    public static int resultLastRecordId(Connection connection) {
        int lastId = 0;
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("SELECT id FROM employee");
            resultSet.last();
            lastId = resultSet.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lastId;
    }


}

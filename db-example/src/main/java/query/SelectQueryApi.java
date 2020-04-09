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

    /*
    bu fonksiyon dışarıdan parametre olarak verılmıs olan id'nin veritabanında olup olmadıgına bakar
    eger verilen id'de kayıt varsa o kaydın recordId'sını döner

    --- Neden bu fonksiyonu kullanmalıyız ----
    1-> Kayıt silerken o kaydın veritabanında olup olmadığı önemlidir çünkü olmayan kayıdı silmeye calısırsak hata alırız
    2-> Kayıt eklerken aynı id'de kayıt olabilir bu seferde hata alırız  ve kayıt ekleyemeyebiliriz
    3-> Kayıt güncellerken o kaydın olup olmadığı önemlidir sonuçta kayıt yoksa eğer güncelleme işlemi yapılmaz o kaydın ılk eklenmesi gerekir
     */
    public static Integer findByEmployeeId(int id, Connection connection) {
        Integer recordId = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id= ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                recordId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recordId;
    }

}

package query;

import config.DbConnectionManagement;
import entity.Employee;
import validate.ConnectionValidate;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;

public class InsertQueryApi {


    /*
       Bu fonksiyon dışarıdan parametre olarak verılmıs olan kullanıcıyı veritabanına kayıt eder
    */
    public static void insertOneRecord(Employee employee) {
        try {
            if (employee != null) {//gönderilen kaydın boş olup olmamasına bakıldı
                if (ConnectionValidate.validateConnection(DbConnectionManagement.connectToDatabase())) {//baglantının basarılı ıle true
                    PreparedStatement preparedStatement = DbConnectionManagement.connectToDatabase().prepareStatement("INSERT INTO employee (id,name,lastName,gender,birthDate,hireDate) VALUES (?,?,?,?,?,?)");
                /*
                    TODO burada son kayıdı bulup idsini alıp yenı kayıt ekleren son kaydın id'sini +1 yapmak gereklı auto +1 yükselicek her personel kaydı
                 */
                    //son eklenen kaydın ıdsını aldı 1 arttırıp yeni kayıt oluşturdu
                    preparedStatement.setLong(1, SelectQueryApi.resultLastRecordId() + 1);

                    preparedStatement.setString(2, employee.getName());
                    preparedStatement.setString(3, employee.getLastName());
                    preparedStatement.setString(4, employee.getGender());
                    preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));
                    preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
                    int insertedRowCount = preparedStatement.executeUpdate();//verilen sql sorgusu ve parametreleri çalıştırır

                    System.out.println(insertedRowCount + " record inserted!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

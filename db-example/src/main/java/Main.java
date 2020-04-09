import config.DbConnectionManagement;
import entity.Employee;
import query.DeleteQueryApi;
import query.InsertQueryApi;
import query.SelectQueryApi;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            //database'e baglantı kurar ve bir adet connection nesnesi yaratır
            Connection connection = DbConnectionManagement.connectToDatabase();


            /*10 idli kayıdın silme işlemini yapar

             DeleteQueryApi.deleteRecord(10, connection);
             */

            /* verilen id'nin veri tabanında olup olmadıgını kontrol eder

            if (SelectQueryApi.findByEmployeeId(10, connection)!=null) {
                System.out.println("Kayıt bulundu");
            } else {
                System.out.println("Kayıt bulunamadı");
            }

             */

            /* yeni kayıt ekleme yapar

            Employee tempEmployee = new Employee("Ahmet", "Aksoy", "M", new Date(), new Date());
            InsertQueryApi.insertOneRecord(tempEmployee, connection);

            */
            //database baglantısını kapatır
            DbConnectionManagement.killDbConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}

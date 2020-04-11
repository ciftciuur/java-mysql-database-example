package query;

import config.DbConnectionManagement;
import entity.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class UpdateQueryApi {

    public static void updateRecord(Employee employee) {
        try {

            //employee id'de kayıt varsa eğer guncelleme işlemi yapılıcak
            if (SelectQueryApi.findByEmployeeId(employee.getId().intValue()) != null) {
                PreparedStatement preparedStatement =
                        DbConnectionManagement.connectToDatabase().prepareStatement("UPDATE employee SET name = ?, lastName = ?, gender = ?, birthDate= ?,hireDate= ? WHERE id = ? ");

                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getLastName());
                preparedStatement.setString(3, employee.getGender());
                preparedStatement.setDate(4, new Date(employee.getBirthDate().getTime()));
                preparedStatement.setDate(5, new Date(employee.getHireDate().getTime()));
                preparedStatement.setInt(6, employee.getId().intValue());
                int updatedRowCount = preparedStatement.executeUpdate();
                System.out.println(updatedRowCount + " rows updated!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

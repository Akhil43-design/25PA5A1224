package Week3;

import java.sql.*;

public class StoredProcedureDemo {

    static String url = "jdbc:mysql://localhost:3306/companydb";
    static String user = "root";
    static String password = "Akhil@9866";

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(url, user, password);

            CallableStatement cs1 = con.prepareCall("{call insert_employee(?,?,?)}");

            cs1.setInt(1, 101);
            cs1.setString(2, "Akhil");
            cs1.setDouble(3, 50000);

            cs1.execute();

            System.out.println("Record Inserted");

            CallableStatement cs2 = con.prepareCall("{call get_salary(?,?)}");

            cs2.setInt(1, 101);

            cs2.registerOutParameter(2, Types.DOUBLE);

            cs2.execute();

            double salary = cs2.getDouble(2);

            System.out.println("Salary = " + salary);

            cs1.close();
            cs2.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
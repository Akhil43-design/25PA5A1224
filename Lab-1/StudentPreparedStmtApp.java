package week2;

import java.sql.*;

public class StudentPreparedStmtApp {

    static String url = "jdbc:mysql://localhost:3306/studentdb";
    static String user = "root";
    static String password = "Akhil@9866";

    public static void display(Connection con) throws Exception {

        String sql = "SELECT * FROM Student";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        System.out.println("RollNo\tName\tAddress");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" +
                    rs.getString(2) + "\t" +
                    rs.getString(3));
        }

        rs.close();
        ps.close();
    }

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Student(RollNo INT PRIMARY KEY, Name VARCHAR(30), Address VARCHAR(50))");

            st.executeUpdate("INSERT IGNORE INTO Student VALUES(1,'Ravi','Hyderabad')");
            st.executeUpdate("INSERT IGNORE INTO Student VALUES(2,'Sita','Chennai')");
            st.executeUpdate("INSERT IGNORE INTO Student VALUES(3,'Kiran','Bangalore')");

            System.out.println("Initial Records");
            display(con);

            PreparedStatement ps = con.prepareStatement("INSERT INTO Student VALUES(?,?,?)");

            ps.setInt(1, 4);
            ps.setString(2, "Meena");
            ps.setString(3, "Pune");
            ps.executeUpdate();

            ps.setInt(1, 5);
            ps.setString(2, "Ramesh");
            ps.setString(3, "Mumbai");
            ps.executeUpdate();

            System.out.println("\nTwo Records Inserted");

            PreparedStatement ps1 = con.prepareStatement("UPDATE Student SET Address=? WHERE RollNo=?");

            ps1.setString(1, "Delhi");
            ps1.setInt(2, 2);

            ps1.executeUpdate();

            System.out.println("One Record Updated");

            PreparedStatement ps2 = con.prepareStatement("DELETE FROM Student WHERE RollNo=?");

            ps2.setInt(1, 3);

            ps2.executeUpdate();

            System.out.println("One Record Deleted");

            System.out.println("\nFinal Records");

            display(con);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
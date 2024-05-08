import java.sql.Connection;
import java.sql.DriverManager;


public class Baglanti {
    public static void main(String[] args) {
        System.out.println("hello world");

        String user = "user", pass = "password";
        String conUrl = "jdbc:mysql://localhost:3306/reservation_system_db";

        try {
            Connection conn = DriverManager.getConnection(conUrl, user, pass);
            System.out.println("Connected..");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

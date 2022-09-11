
import java.sql.Connection;
import java.sql.*;

public class Database {
    protected Connection con;

    public Database() {
        String jdbcURL = "jdbc:mysql://localhost/java2";
        String jdbcUsername = "root";
        String jdbcPassword = ""; //please change information to connect to DB
        try {
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection to database failed");
        }
    }
}
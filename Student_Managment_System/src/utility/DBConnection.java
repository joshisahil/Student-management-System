package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    // Database URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management";

    // MySQL Username
    private static final String USER = "root";

    // MySQL Password
    private static final String PASSWORD = "Password";

    // Method to get database connection
    public static Connection getConnection()
    {
        Connection connection = null;

        try
        {
            // Load MySQL JDBC Driver (optional for JDBC 4.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);

        }
        catch (ClassNotFoundException e)
        {
            System.out.println(
                    "MySQL JDBC Driver Not Found!");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Database Connection Failed!");
            e.printStackTrace();
        }

        return connection;
    }

    // Test Connection
    public static void main(String[] args)
    {
        Connection con = getConnection();

        if (con != null)
        {
            System.out.println(
                    "Database Connected Successfully!");
        }
        else
        {
            System.out.println(
                    "Connection Failed!");
        }
    }
}

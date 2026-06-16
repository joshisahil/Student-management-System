package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DBConnection;

public class AdminDAO
{
    public boolean login(String username,
                         String password)
    {
        String query =
                "SELECT * FROM admin " +
                "WHERE username=? " +
                "AND password=?";

        try(Connection con =
                    DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            return rs.next();
        }
        catch(SQLException e)
        {
            System.out.println(
                    e.getMessage());
        }

        return false;
    }
}

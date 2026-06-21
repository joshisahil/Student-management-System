package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.DBConnection;

public class PlacementDAO
{
    public boolean addStudentToPlacement(
            int studentId,
            String companyName,
            String jobRole,
            double packageAmount)
    {
        try(Connection conn =
                DBConnection.getConnection())
        {
            String fetchQuery =
                    "SELECT * FROM students " +
                    "WHERE student_id = ?";

            PreparedStatement fetchPs =
                    conn.prepareStatement(fetchQuery);

            fetchPs.setInt(1, studentId);

            ResultSet rs =
                    fetchPs.executeQuery();

            if(!rs.next())
            {
                System.out.println(
                        "Student Not Found!");
                return false;
            }

            String insertQuery =
                    "INSERT INTO placements " +
                    "(student_id, student_name, age, gender, email, mobile, address, company_name, job_role, package_amount, placement_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE())";

            PreparedStatement insertPs =
                    conn.prepareStatement(insertQuery);

            insertPs.setInt(
                    1,
                    rs.getInt("student_id"));

            insertPs.setString(
                    2,
                    rs.getString("student_name"));

            insertPs.setInt(
                    3,
                    rs.getInt("age"));

            insertPs.setString(
                    4,
                    rs.getString("gender"));

            insertPs.setString(
                    5,
                    rs.getString("email"));

            insertPs.setString(
                    6,
                    rs.getString("mobile"));

            insertPs.setString(
                    7,
                    rs.getString("address"));

            insertPs.setString(
                    8,
                    companyName);

            insertPs.setString(
                    9,
                    jobRole);

            insertPs.setDouble(
                    10,
                    packageAmount);

            return insertPs.executeUpdate() > 0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
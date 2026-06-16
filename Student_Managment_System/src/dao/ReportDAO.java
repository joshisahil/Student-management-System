package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DBConnection;

public class ReportDAO
{
    // Total Students
    public void totalStudents()
    {
        String query =
                "SELECT COUNT(*) AS total " +
                "FROM students";

        try(Connection con =
                    DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs =
                    ps.executeQuery())
        {
            if(rs.next())
            {
                System.out.println(
                        "Total Students : "
                        + rs.getInt("total"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Total Courses
    public void totalCourses()
    {
        String query =
                "SELECT COUNT(*) AS total " +
                "FROM courses";

        try(Connection con =
                    DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs =
                    ps.executeQuery())
        {
            if(rs.next())
            {
                System.out.println(
                        "Total Courses : "
                        + rs.getInt("total"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void studentsPerCourse()
    {
        String query =
                "SELECT c.course_name, " +
                "COUNT(e.student_id) AS total_students " +
                "FROM courses c " +
                "LEFT JOIN enrollments e " +
                "ON c.course_id = e.course_id " +
                "GROUP BY c.course_name";

        try(Connection con =
                    DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs =
                    ps.executeQuery())
        {
            System.out.println(
                    "\n===== STUDENTS PER COURSE =====");

            while(rs.next())
            {
                System.out.println(
                        rs.getString("course_name")
                        + " : "
                        + rs.getInt("total_students"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void feeDefaulters()
    {
        String query =
                "SELECT s.student_name, " +
                "f.remaining_fee " +
                "FROM fees f " +
                "JOIN students s " +
                "ON f.student_id = s.student_id " +
                "WHERE f.remaining_fee > 0";

        try(Connection con =
                    DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs =
                    ps.executeQuery())
        {
            System.out.println(
                    "\n===== FEE DEFAULTERS =====");

            while(rs.next())
            {
                System.out.println(
                        rs.getString("student_name")
                        + " | Remaining : "
                        + rs.getDouble("remaining_fee"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void attendancePercentage()
    {
        String query =
                "SELECT s.student_name, " +
                "ROUND((SUM(CASE " +
                "WHEN a.status='Present' THEN 1 ELSE 0 END) " +
                "*100.0 / COUNT(*)),2) AS percentage " +
                "FROM attendance a " +
                "JOIN students s " +
                "ON a.student_id=s.student_id " +
                "GROUP BY s.student_name";

        try(Connection con =
                    DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs =
                    ps.executeQuery())
        {
            System.out.println(
                    "\n===== ATTENDANCE PERCENTAGE =====");

            while(rs.next())
            {
                System.out.println(
                        rs.getString("student_name")
                        + " : "
                        + rs.getDouble("percentage")
                        + "%");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
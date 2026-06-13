package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Enrollment;
import utility.DBConnection;

public class EnrollmentDAO
{
    // Add Enrollment
    public boolean addEnrollment(Enrollment enrollment)
    {
        String query =
                "INSERT INTO enrollments(student_id, course_id) " +
                "VALUES (?, ?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, enrollment.getStudentId());
            ps.setInt(2, enrollment.getCourseId());

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Adding Enrollment: "
                    + e.getMessage());
        }

        return false;
    }

    // Get Enrollment By ID
    public Enrollment getEnrollmentById(int enrollmentId)
    {
        String query =
                "SELECT * FROM enrollments " +
                "WHERE enrollment_id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, enrollmentId);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                return new Enrollment(
                        rs.getInt("enrollment_id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Enrollment: "
                    + e.getMessage());
        }

        return null;
    }

    // Get All Enrollments
    public ArrayList<Enrollment> getAllEnrollments()
    {
        ArrayList<Enrollment> enrollments =
                new ArrayList<>();

        String query =
                "SELECT * FROM enrollments";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                Enrollment enrollment =
                        new Enrollment(
                                rs.getInt("enrollment_id"),
                                rs.getInt("student_id"),
                                rs.getInt("course_id"));

                enrollments.add(enrollment);
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Enrollments: "
                    + e.getMessage());
        }

        return enrollments;
    }

    // Delete Enrollment
    public boolean deleteEnrollment(int enrollmentId)
    {
        String query =
                "DELETE FROM enrollments " +
                "WHERE enrollment_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, enrollmentId);

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Deleting Enrollment: "
                    + e.getMessage());
        }

        return false;
    }

    // Get Courses By Student ID
    public ArrayList<Integer> getCoursesByStudent(
            int studentId)
    {
        ArrayList<Integer> courseIds =
                new ArrayList<>();

        String query =
                "SELECT course_id " +
                "FROM enrollments " +
                "WHERE student_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                courseIds.add(
                        rs.getInt("course_id"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Courses: "
                    + e.getMessage());
        }

        return courseIds;
    }

    // Get Students By Course ID
    public ArrayList<Integer> getStudentsByCourse(
            int courseId)
    {
        ArrayList<Integer> studentIds =
                new ArrayList<>();

        String query =
                "SELECT student_id " +
                "FROM enrollments " +
                "WHERE course_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                studentIds.add(
                        rs.getInt("student_id"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Students: "
                    + e.getMessage());
        }

        return studentIds;
    }
    
    public void displayEnrollmentReport()
    {
        String query =
                "SELECT e.enrollment_id, " +
                "s.student_name, " +
                "c.course_name " +
                "FROM enrollments e " +
                "JOIN students s " +
                "ON e.student_id = s.student_id " +
                "JOIN courses c " +
                "ON e.course_id = c.course_id";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs = ps.executeQuery())
        {
            System.out.println(
                    "\n===== ENROLLMENT REPORT =====");

            while(rs.next())
            {
                System.out.println(
                        "Enrollment ID : "
                        + rs.getInt("enrollment_id"));

                System.out.println(
                        "Student Name  : "
                        + rs.getString("student_name"));

                System.out.println(
                        "Course Name   : "
                        + rs.getString("course_name"));

                System.out.println(
                        "----------------------------");
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Generating Report: "
                    + e.getMessage());
        }
    }
}

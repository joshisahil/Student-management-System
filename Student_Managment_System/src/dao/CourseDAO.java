package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Course;
import utility.DBConnection;

public class CourseDAO
{
    // Add Course
    public boolean addCourse(Course course)
    {
        String query =
                "INSERT INTO courses(course_name, duration, fees) " +
                "VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query))
        {
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDuration());
            ps.setDouble(3, course.getFees());

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Error Adding Course: "
                    + e.getMessage());
        }

        return false;
    }

    // Get Course By ID
    public Course getCourseById(int courseId)
    {
        String query =
                "SELECT * FROM courses " +
                "WHERE course_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query))
        {
            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                return new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("duration"),
                        rs.getDouble("fees"));
            }
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Error Fetching Course: "
                    + e.getMessage());
        }

        return null;
    }

    // Get All Courses
    public ArrayList<Course> getAllCourses()
    {
        ArrayList<Course> courses =
                new ArrayList<>();

        String query = "SELECT * FROM courses";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query);
             ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                Course course =
                        new Course(
                                rs.getInt("course_id"),
                                rs.getString("course_name"),
                                rs.getString("duration"),
                                rs.getDouble("fees"));

                courses.add(course);
            }
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Error Fetching Courses: "
                    + e.getMessage());
        }

        return courses;
    }

    // Update Course
    public boolean updateCourse(Course course)
    {
        String query =
                "UPDATE courses " +
                "SET course_name=?, duration=?, fees=? " +
                "WHERE course_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query))
        {
            ps.setString(1,
                    course.getCourseName());

            ps.setString(2,
                    course.getDuration());

            ps.setDouble(3,
                    course.getFees());

            ps.setInt(4,
                    course.getCourseId());

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Error Updating Course: "
                    + e.getMessage());
        }

        return false;
    }

    // Delete Course
    public boolean deleteCourse(int courseId)
    {
        String query =
                "DELETE FROM courses " +
                "WHERE course_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query))
        {
            ps.setInt(1, courseId);

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Error Deleting Course: "
                    + e.getMessage());
        }

        return false;
    }
}

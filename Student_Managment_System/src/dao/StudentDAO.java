package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;
import utility.DBConnection;

public class StudentDAO
{
    // Add Student
    public boolean addStudent(Student student)
    {
        String query = "INSERT INTO students "
                + "(student_name, age, gender, email, mobile, address) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query))
        {
            ps.setString(1, student.getStudentName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getMobile());
            ps.setString(6, student.getAddress());

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            System.out.println("Error Adding Student: "
                    + e.getMessage());
        }

        return false;
    }

    // View Student By ID
    public Student getStudentById(int studentId)
    {
        String query =
                "SELECT * FROM students WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query))
        {
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                return new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("address"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error Fetching Student: "
                    + e.getMessage());
        }

        return null;
    }

    // View All Students
    public ArrayList<Student> getAllStudents()
    {
        ArrayList<Student> students =
                new ArrayList<>();

        String query = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query);
             ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("address"));

                students.add(student);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error Fetching Students: "
                    + e.getMessage());
        }

        return students;
    }

    // Update Student
    public boolean updateStudent(Student student)
    {
        String query =
                "UPDATE students SET "
                + "student_name=?, "
                + "age=?, "
                + "gender=?, "
                + "email=?, "
                + "mobile=?, "
                + "address=? "
                + "WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query))
        {
            ps.setString(1, student.getStudentName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getMobile());
            ps.setString(6, student.getAddress());
            ps.setInt(7, student.getStudentId());

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            System.out.println("Error Updating Student: "
                    + e.getMessage());
        }

        return false;
    }

    // Delete Student
    public boolean deleteStudent(int studentId)
    {
        String query =
                "DELETE FROM students WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(query))
        {
            ps.setInt(1, studentId);

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            System.out.println("Error Deleting Student: "
                    + e.getMessage());
        }

        return false;
    }
}
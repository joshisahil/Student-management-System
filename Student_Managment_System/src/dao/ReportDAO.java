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
    
    // Dashboard report
    public void dashboardReport()
    {
        try(Connection con =
                    DBConnection.getConnection())
        {
            // Total Students
            String studentQuery =
                    "SELECT COUNT(*) FROM students";

            PreparedStatement ps1 =
                    con.prepareStatement(studentQuery);

            ResultSet rs1 =
                    ps1.executeQuery();

            rs1.next();

            int totalStudents =
                    rs1.getInt(1);

            // Total Courses
            String courseQuery =
                    "SELECT COUNT(*) FROM courses";

            PreparedStatement ps2 =
                    con.prepareStatement(courseQuery);

            ResultSet rs2 =
                    ps2.executeQuery();

            rs2.next();

            int totalCourses =
                    rs2.getInt(1);

            // Total Enrollments
            String enrollmentQuery =
                    "SELECT COUNT(*) FROM enrollments";

            PreparedStatement ps3 =
                    con.prepareStatement(enrollmentQuery);

            ResultSet rs3 =
                    ps3.executeQuery();

            rs3.next();

            int totalEnrollments =
                    rs3.getInt(1);

            // Total Attendance Records
            String attendanceQuery =
                    "SELECT COUNT(*) FROM attendance";

            PreparedStatement ps4 =
                    con.prepareStatement(attendanceQuery);

            ResultSet rs4 =
                    ps4.executeQuery();

            rs4.next();

            int totalAttendance =
                    rs4.getInt(1);

            // Fee Defaulters
            String feeQuery =
                    "SELECT COUNT(*) " +
                    "FROM fees " +
                    "WHERE remaining_fee > 0";

            PreparedStatement ps5 =
                    con.prepareStatement(feeQuery);

            ResultSet rs5 =
                    ps5.executeQuery();

            rs5.next();

            int feeDefaulters =
                    rs5.getInt(1);

            System.out.println(
                    "\n================================");

            System.out.println(
                    " STUDENT MANAGEMENT DASHBOARD ");

            System.out.println(
                    "================================");

            System.out.println(
                    "Total Students      : "
                    + totalStudents);

            System.out.println(
                    "Total Courses       : "
                    + totalCourses);

            System.out.println(
                    "Total Enrollments   : "
                    + totalEnrollments);

            System.out.println(
                    "Attendance Records  : "
                    + totalAttendance);

            System.out.println(
                    "Fee Defaulters      : "
                    + feeDefaulters);

            System.out.println(
                    "================================");
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Generating Dashboard: "
                    + e.getMessage());
        }
    }

    public void enrollmentReport()
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
                        "---------------------------");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void attendanceReport()
    {
        String query =
                "SELECT s.student_name, " +
                "a.attendance_date, " +
                "a.status " +
                "FROM attendance a " +
                "JOIN students s " +
                "ON a.student_id = s.student_id";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs = ps.executeQuery())
        {
            System.out.println(
                    "\n===== ATTENDANCE REPORT =====");

            while(rs.next())
            {
                System.out.println(
                        "Student Name : "
                        + rs.getString("student_name"));

                System.out.println(
                        "Date         : "
                        + rs.getDate("attendance_date"));

                System.out.println(
                        "Status       : "
                        + rs.getString("status"));

                System.out.println(
                        "---------------------------");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void feeReport()
    {
        String query =
                "SELECT s.student_name, " +
                "f.total_fee, " +
                "f.paid_fee, " +
                "f.remaining_fee " +
                "FROM fees f " +
                "JOIN students s " +
                "ON f.student_id = s.student_id";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs = ps.executeQuery())
        {
            System.out.println(
                    "\n===== FEE REPORT =====");

            while(rs.next())
            {
                System.out.println(
                        "Student Name  : "
                        + rs.getString("student_name"));

                System.out.println(
                        "Total Fee     : "
                        + rs.getDouble("total_fee"));

                System.out.println(
                        "Paid Fee      : "
                        + rs.getDouble("paid_fee"));

                System.out.println(
                        "Remaining Fee : "
                        + rs.getDouble("remaining_fee"));

                System.out.println(
                        "---------------------------");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
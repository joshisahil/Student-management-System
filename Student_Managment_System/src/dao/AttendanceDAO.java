package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Attendance;
import utility.DBConnection;

public class AttendanceDAO
{
    // Add Attendance
	public boolean addAttendance(Attendance attendance)
	{
	    String query =
	            "INSERT INTO attendance " +
	            "(student_id, attendance_date, status) " +
	            "VALUES (?, ?, ?)";

	    try(Connection con = DBConnection.getConnection();
	        PreparedStatement ps =
	                con.prepareStatement(query))
	    {
	        ps.setInt(1, attendance.getStudentId());
	        ps.setDate(2, attendance.getAttendanceDate());
	        ps.setString(3, attendance.getStatus());

	        return ps.executeUpdate() > 0;
	    }
	    catch(SQLException e)
	    {
	        System.out.println(
	                "Error Adding Attendance: "
	                + e.getMessage());
	    }

	    return false;
	}

    // Get Attendance By ID
    public Attendance getAttendanceById(int attendanceId)
    {
        String query =
                "SELECT * FROM attendance " +
                "WHERE attendance_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, attendanceId);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                return new Attendance(
                        rs.getInt("attendance_id"),
                        rs.getInt("student_id"),
                        rs.getDate("attendance_date"),
                        rs.getString("status"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Attendance: "
                    + e.getMessage());
        }

        return null;
    }

    // Get All Attendance
    public ArrayList<Attendance> getAllAttendance()
    {
        ArrayList<Attendance> attendanceList =
                new ArrayList<>();

        String query =
                "SELECT * FROM attendance";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                Attendance attendance =
                        new Attendance(
                                rs.getInt("attendance_id"),
                                rs.getInt("student_id"),
                                rs.getDate("attendance_date"),
                                rs.getString("status"));

                attendanceList.add(attendance);
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Attendance: "
                    + e.getMessage());
        }

        return attendanceList;
    }

    // Delete Attendance
    public boolean deleteAttendance(int attendanceId)
    {
        String query =
                "DELETE FROM attendance " +
                "WHERE attendance_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, attendanceId);

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Deleting Attendance: "
                    + e.getMessage());
        }

        return false;
    }

    // Get Attendance By Student ID
    public ArrayList<Attendance> getAttendanceByStudent(
            int studentId)
    {
        ArrayList<Attendance> attendanceList =
                new ArrayList<>();

        String query =
                "SELECT * FROM attendance " +
                "WHERE student_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Attendance attendance =
                        new Attendance(
                                rs.getInt("attendance_id"),
                                rs.getInt("student_id"),
                                rs.getDate("attendance_date"),
                                rs.getString("status"));

                attendanceList.add(attendance);
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Student Attendance: "
                    + e.getMessage());
        }

        return attendanceList;
    }

    // Attendance Report
    public void displayAttendanceReport()
    {
        String query =
                "SELECT a.attendance_id, " +
                "s.student_name, " +
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
                        "Attendance ID : "
                        + rs.getInt("attendance_id"));

                System.out.println(
                        "Student Name  : "
                        + rs.getString("student_name"));

                System.out.println(
                        "Date          : "
                        + rs.getDate("attendance_date"));

                System.out.println(
                        "Status        : "
                        + rs.getString("status"));

                System.out.println(
                        "-----------------------------");
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

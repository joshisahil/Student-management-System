package service;

import java.util.ArrayList;

import dao.AttendanceDAO;
import model.Attendance;

public class AttendanceService
{
    private AttendanceDAO attendanceDAO;

    public AttendanceService()
    {
        attendanceDAO = new AttendanceDAO();
    }

    // Add Attendance
    public boolean addAttendance(Attendance attendance)
    {
        if(attendance.getStudentId() <= 0)
        {
            System.out.println("Invalid Student ID.");
            return false;
        }

        if(attendance.getAttendanceDate() == null)
        {
            System.out.println("Attendance Date cannot be null.");
            return false;
        }

        String status = attendance.getStatus();

        if(status == null)
        {
            System.out.println("Status cannot be null.");
            return false;
        }

        if(!status.equalsIgnoreCase("Present") &&
           !status.equalsIgnoreCase("Absent"))
        {
            System.out.println(
                    "Status must be Present or Absent.");
            return false;
        }

        return attendanceDAO.addAttendance(attendance);
    }

    // Get Attendance By ID
    public Attendance getAttendanceById(int attendanceId)
    {
        if(attendanceId <= 0)
        {
            System.out.println("Invalid Attendance ID.");
            return null;
        }

        return attendanceDAO.getAttendanceById(attendanceId);
    }

    // Get All Attendance
    public ArrayList<Attendance> getAllAttendance()
    {
        return attendanceDAO.getAllAttendance();
    }

    // Delete Attendance
    public boolean deleteAttendance(int attendanceId)
    {
        if(attendanceId <= 0)
        {
            System.out.println("Invalid Attendance ID.");
            return false;
        }

        return attendanceDAO.deleteAttendance(
                attendanceId);
    }

    // Get Attendance By Student
    public ArrayList<Attendance> getAttendanceByStudent(
            int studentId)
    {
        if(studentId <= 0)
        {
            System.out.println("Invalid Student ID.");
            return new ArrayList<>();
        }

        return attendanceDAO.getAttendanceByStudent(
                studentId);
    }

    // Display Attendance Report
    public void displayAttendanceReport()
    {
        attendanceDAO.displayAttendanceReport();
    }
}
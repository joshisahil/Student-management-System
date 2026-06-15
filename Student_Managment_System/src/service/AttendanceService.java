package service;

import java.util.ArrayList;

import dao.AttendanceDAO;
import dao.StudentDAO;
import model.Attendance;

public class AttendanceService
{
    private AttendanceDAO attendanceDAO;
    private StudentDAO studentDAO;

    public AttendanceService()
    {
        attendanceDAO = new AttendanceDAO();
        studentDAO = new StudentDAO();
    }

    public boolean addAttendance(
            Attendance attendance)
    {
        if(studentDAO.getStudentById(
                attendance.getStudentId()) == null)
        {
            System.out.println(
                    "Student does not exist.");
            return false;
        }

        return attendanceDAO
                .addAttendance(attendance);
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
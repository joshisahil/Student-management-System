package model;

import java.sql.Date;

public class Attendance
{
    private int attendanceId;
    private int studentId;
    private Date attendanceDate;
    private String status;

    // Default Constructor
    public Attendance()
    {
    }

    // Constructor without attendanceId
    public Attendance(int studentId,
                      Date attendanceDate,
                      String status)
    {
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    // Constructor with attendanceId
    public Attendance(int attendanceId,
                      int studentId,
                      Date attendanceDate,
                      String status)
    {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    // Getters and Setters

    public int getAttendanceId()
    {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId)
    {
        this.attendanceId = attendanceId;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public Date getAttendanceDate()
    {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate)
    {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", studentId=" + studentId +
                ", attendanceDate=" + attendanceDate +
                ", status='" + status + '\'' +
                '}';
    }
}
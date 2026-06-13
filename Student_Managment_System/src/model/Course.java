package model;

public class Course
{
    private int courseId;
    private String courseName;
    private String duration;
    private double fees;

    // Default Constructor
    public Course()
    {
    }

    // Constructor without ID
    public Course(String courseName,
                  String duration,
                  double fees)
    {
        this.courseName = courseName;
        this.duration = duration;
        this.fees = fees;
    }

    // Constructor with ID
    public Course(int courseId,
                  String courseName,
                  String duration,
                  double fees)
    {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.fees = fees;
    }

    // Getters and Setters

    public int getCourseId()
    {
        return courseId;
    }

    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public double getFees()
    {
        return fees;
    }

    public void setFees(double fees)
    {
        this.fees = fees;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                ", fees=" + fees +
                '}';
    }
}

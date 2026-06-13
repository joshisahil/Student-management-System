package service;

import java.util.ArrayList;

import dao.CourseDAO;
import model.Course;

public class CourseService
{
    private CourseDAO courseDAO;

    public CourseService()
    {
        courseDAO = new CourseDAO();
    }

    // Add Course
    public boolean addCourse(Course course)
    {
        if(course.getCourseName() == null ||
           course.getCourseName().trim().isEmpty())
        {
            System.out.println("Course name cannot be empty.");
            return false;
        }

        if(course.getFees() <= 0)
        {
            System.out.println("Course fees must be greater than 0.");
            return false;
        }

        return courseDAO.addCourse(course);
    }

    // Get Course By ID
    public Course getCourseById(int courseId)
    {
        if(courseId <= 0)
        {
            System.out.println("Invalid Course ID.");
            return null;
        }

        return courseDAO.getCourseById(courseId);
    }

    // Get All Courses
    public ArrayList<Course> getAllCourses()
    {
        return courseDAO.getAllCourses();
    }

    // Update Course
    public boolean updateCourse(Course course)
    {
        if(course.getCourseId() <= 0)
        {
            System.out.println("Invalid Course ID.");
            return false;
        }

        if(course.getCourseName() == null ||
           course.getCourseName().trim().isEmpty())
        {
            System.out.println("Course name cannot be empty.");
            return false;
        }

        return courseDAO.updateCourse(course);
    }

    // Delete Course
    public boolean deleteCourse(int courseId)
    {
        if(courseId <= 0)
        {
            System.out.println("Invalid Course ID.");
            return false;
        }

        return courseDAO.deleteCourse(courseId);
    }
}

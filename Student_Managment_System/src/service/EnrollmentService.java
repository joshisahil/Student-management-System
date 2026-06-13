package service;

import java.util.ArrayList;

import dao.EnrollmentDAO;
import model.Enrollment;

public class EnrollmentService
{
    private EnrollmentDAO enrollmentDAO;

    public EnrollmentService()
    {
        enrollmentDAO = new EnrollmentDAO();
    }

    // Add Enrollment
    public boolean addEnrollment(Enrollment enrollment)
    {
        if(enrollment.getStudentId() <= 0)
        {
            System.out.println("Invalid Student ID.");
            return false;
        }

        if(enrollment.getCourseId() <= 0)
        {
            System.out.println("Invalid Course ID.");
            return false;
        }

        return enrollmentDAO.addEnrollment(enrollment);
    }

    // Get Enrollment By ID
    public Enrollment getEnrollmentById(int enrollmentId)
    {
        if(enrollmentId <= 0)
        {
            System.out.println("Invalid Enrollment ID.");
            return null;
        }

        return enrollmentDAO.getEnrollmentById(enrollmentId);
    }

    // Get All Enrollments
    public ArrayList<Enrollment> getAllEnrollments()
    {
        return enrollmentDAO.getAllEnrollments();
    }

    // Delete Enrollment
    public boolean deleteEnrollment(int enrollmentId)
    {
        if(enrollmentId <= 0)
        {
            System.out.println("Invalid Enrollment ID.");
            return false;
        }

        return enrollmentDAO.deleteEnrollment(enrollmentId);
    }

    // Get Courses By Student
    public ArrayList<Integer> getCoursesByStudent(
            int studentId)
    {
        if(studentId <= 0)
        {
            System.out.println("Invalid Student ID.");
            return new ArrayList<>();
        }

        return enrollmentDAO.getCoursesByStudent(studentId);
    }

    // Get Students By Course
    public ArrayList<Integer> getStudentsByCourse(
            int courseId)
    {
        if(courseId <= 0)
        {
            System.out.println("Invalid Course ID.");
            return new ArrayList<>();
        }

        return enrollmentDAO.getStudentsByCourse(courseId);
    }
}

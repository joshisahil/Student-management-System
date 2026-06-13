package service;

import java.util.ArrayList;

import dao.StudentDAO;
import model.Student;

public class StudentService
{
    private StudentDAO studentDAO;

    public StudentService()
    {
        studentDAO = new StudentDAO();
    }

    // Add Student
    public boolean addStudent(Student student)
    {
        if(student.getStudentName() == null ||
           student.getStudentName().trim().isEmpty())
        {
            System.out.println("Student name cannot be empty.");
            return false;
        }

        if(student.getAge() <= 0)
        {
            System.out.println("Invalid age.");
            return false;
        }
        
        if(!student.getEmail().contains("@"))
        {
            System.out.println("Invalid Email.");
            return false;
        }
        
        if(student.getMobile().length() != 10)
        {
            System.out.println("Mobile number must be 10 digits.");
            return false;
        }

        return studentDAO.addStudent(student);
    }

    // Search Student by ID
    public Student getStudentById(int studentId)
    {
        if(studentId <= 0)
        {
            System.out.println("Invalid Student ID.");
            return null;
        }

        return studentDAO.getStudentById(studentId);
    }

    // Display All Students
    public ArrayList<Student> getAllStudents()
    {
        return studentDAO.getAllStudents();
    }

    // Update Student
    public boolean updateStudent(Student student)
    {
        if(student.getStudentId() <= 0)
        {
            System.out.println("Invalid Student ID.");
            return false;
        }

        return studentDAO.updateStudent(student);
    }

    // Delete Student
    public boolean deleteStudent(int studentId)
    {
        if(studentId <= 0)
        {
            System.out.println("Invalid Student ID.");
            return false;
        }

        return studentDAO.deleteStudent(studentId);
    }
}
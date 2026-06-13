package Main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Student;
import service.StudentService;

public class main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();

        int choice;

        do
        {
            System.out.println("\n=================================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    addStudent(sc, studentService);
                    break;

                case 2:
                    viewStudent(sc, studentService);
                    break;

                case 3:
                    viewAllStudents(studentService);
                    break;

                case 4:
                    updateStudent(sc, studentService);
                    break;

                case 5:
                    deleteStudent(sc, studentService);
                    break;

                case 6:
                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 6);

        sc.close();
    }

    // Add Student
    private static void addStudent(
            Scanner sc,
            StudentService studentService)
    {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        Student student = new Student(
                name,
                age,
                gender,
                email,
                mobile,
                address);

        boolean result =
                studentService.addStudent(student);

        if(result)
        {
            System.out.println(
                    "Student Added Successfully!");
        }
        else
        {
            System.out.println(
                    "Failed To Add Student!");
        }
    }

    // View Student By ID
    private static void viewStudent(
            Scanner sc,
            StudentService studentService)
    {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student student =
                studentService.getStudentById(id);

        if(student != null)
        {
            System.out.println(student);
        }
        else
        {
            System.out.println(
                    "Student Not Found!");
        }
    }

    // View All Students
    private static void viewAllStudents(
            StudentService studentService)
    {
        ArrayList<Student> students =
                studentService.getAllStudents();

        if(students.isEmpty())
        {
            System.out.println(
                    "No Students Found.");
            return;
        }

        for(Student student : students)
        {
            System.out.println(student);
        }
    }

    // Update Student
    private static void updateStudent(
            Scanner sc,
            StudentService studentService)
    {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter New Email: ");
        String email = sc.nextLine();

        System.out.print("Enter New Mobile: ");
        String mobile = sc.nextLine();

        System.out.print("Enter New Address: ");
        String address = sc.nextLine();

        Student student = new Student(
                id,
                name,
                age,
                gender,
                email,
                mobile,
                address);

        boolean result =
                studentService.updateStudent(student);

        if(result)
        {
            System.out.println(
                    "Student Updated Successfully!");
        }
        else
        {
            System.out.println(
                    "Update Failed!");
        }
    }

    // Delete Student
    private static void deleteStudent(
            Scanner sc,
            StudentService studentService)
    {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        boolean result =
                studentService.deleteStudent(id);

        if(result)
        {
            System.out.println(
                    "Student Deleted Successfully!");
        }
        else
        {
            System.out.println(
                    "Delete Failed!");
        }
    }
}
package Main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Course;
import model.Student;
import model.Enrollment;
import service.EnrollmentService;
import service.CourseService;
import service.StudentService;

public class main
{
    private static Scanner sc = new Scanner(System.in);

    private static StudentService studentService =
            new StudentService();

    private static CourseService courseService =
            new CourseService();
    
    private static EnrollmentService enrollmentService =
            new EnrollmentService();

    public static void main(String[] args)
    {
        int choice;

        do
        {
            System.out.println("\n================================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM ");
            System.out.println("================================");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    studentMenu();
                    break;

                case 2:
                    courseMenu();
                    break;

                case 3:
                    enrollmentMenu();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 4);

        sc.close();
    }

    // ==========================
    // STUDENT MENU
    // ==========================

    private static void studentMenu()
    {
        int choice;

        do
        {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Back");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudent();
                    break;

                case 3:
                    viewAllStudents();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;
            }

        } while(choice != 6);
    }

    // ==========================
    // COURSE MENU
    // ==========================

    private static void courseMenu()
    {
        int choice;

        do
        {
            System.out.println("\n===== COURSE MANAGEMENT =====");
            System.out.println("1. Add Course");
            System.out.println("2. View Course");
            System.out.println("3. View All Courses");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Back");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    addCourse();
                    break;

                case 2:
                    viewCourse();
                    break;

                case 3:
                    viewAllCourses();
                    break;

                case 4:
                    updateCourse();
                    break;

                case 5:
                    deleteCourse();
                    break;
            }

        } while(choice != 6);
    }
    
    // ==========================
    // ENROLLMENT MENU
    // ==========================

    private static void enrollmentMenu()
    {
        int choice;

        do
        {
            System.out.println("\n===== ENROLLMENT MANAGEMENT =====");

            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollment");
            System.out.println("3. View All Enrollments");
            System.out.println("4. Delete Enrollment");
            System.out.println("5. Back");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    addEnrollment();
                    break;

                case 2:
                    viewEnrollment();
                    break;

                case 3:
                    viewAllEnrollments();
                    break;

                case 4:
                    deleteEnrollment();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 5);
    }

    // ==========================
    // STUDENT METHODS
    // ==========================

    private static void addStudent()
    {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Mobile: ");
        String mobile = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        Student student = new Student(
                name, age, gender,
                email, mobile, address);

        if(studentService.addStudent(student))
            System.out.println("Student Added Successfully");
        else
            System.out.println("Failed");
    }

    private static void viewStudent()
    {
        System.out.print("Student ID: ");
        int id = sc.nextInt();

        Student student =
                studentService.getStudentById(id);

        if(student != null)
            System.out.println(student);
        else
            System.out.println("Student Not Found");
    }

    private static void viewAllStudents()
    {
        ArrayList<Student> students =
                studentService.getAllStudents();

        for(Student student : students)
        {
            System.out.println(student);
        }
    }

    private static void updateStudent()
    {
        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Mobile: ");
        String mobile = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        Student student = new Student(
                id,
                name,
                age,
                gender,
                email,
                mobile,
                address);

        if(studentService.updateStudent(student))
            System.out.println("Student Updated");
        else
            System.out.println("Update Failed");
    }

    private static void deleteStudent()
    {
        System.out.print("Student ID: ");
        int id = sc.nextInt();

        if(studentService.deleteStudent(id))
            System.out.println("Student Deleted");
        else
            System.out.println("Delete Failed");
    }

    // ==========================
    // COURSE METHODS
    // ==========================

    private static void addCourse()
    {
        System.out.print("Course Name: ");
        String name = sc.nextLine();

        System.out.print("Duration: ");
        String duration = sc.nextLine();

        System.out.print("Fees: ");
        double fees = sc.nextDouble();

        Course course =
                new Course(name,
                        duration,
                        fees);

        if(courseService.addCourse(course))
            System.out.println("Course Added");
        else
            System.out.println("Failed");
    }

    private static void viewCourse()
    {
        System.out.print("Course ID: ");
        int id = sc.nextInt();

        Course course =
                courseService.getCourseById(id);

        if(course != null)
            System.out.println(course);
        else
            System.out.println("Course Not Found");
    }

    private static void viewAllCourses()
    {
        ArrayList<Course> courses =
                courseService.getAllCourses();

        for(Course course : courses)
        {
            System.out.println(course);
        }
    }

    private static void updateCourse()
    {
        System.out.print("Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Course Name: ");
        String name = sc.nextLine();

        System.out.print("Duration: ");
        String duration = sc.nextLine();

        System.out.print("Fees: ");
        double fees = sc.nextDouble();

        Course course =
                new Course(id,
                        name,
                        duration,
                        fees);

        if(courseService.updateCourse(course))
            System.out.println("Course Updated");
        else
            System.out.println("Update Failed");
    }

    private static void deleteCourse()
    {
        System.out.print("Course ID: ");
        int id = sc.nextInt();

        if(courseService.deleteCourse(id))
            System.out.println("Course Deleted");
        else
            System.out.println("Delete Failed");
    }


  //==========================
  // ENROLLMENT METHODS
  // ==========================

private static void addEnrollment()
{
    System.out.print("Enter Student ID: ");
    int studentId = sc.nextInt();

    System.out.print("Enter Course ID: ");
    int courseId = sc.nextInt();

    Enrollment enrollment =
            new Enrollment(studentId, courseId);

    if(enrollmentService.addEnrollment(enrollment))
    {
        System.out.println(
                "Enrollment Added Successfully!");
    }
    else
    {
        System.out.println(
                "Enrollment Failed!");
    }
}
    private static void viewEnrollment()
    {
        System.out.print("Enter Enrollment ID: ");

        int id = sc.nextInt();

        Enrollment enrollment =
                enrollmentService.getEnrollmentById(id);

        if(enrollment != null)
        {
            System.out.println(enrollment);
        }
        else
        {
            System.out.println("Enrollment Not Found!");
        }
    }
    
        private static void viewAllEnrollments()
        {
            ArrayList<Enrollment> enrollments =
                    enrollmentService.getAllEnrollments();

            if(enrollments.isEmpty())
            {
                System.out.println(
                        "No Enrollments Found!");
                return;
            }

            for(Enrollment enrollment : enrollments)
            {
                System.out.println(enrollment);
            }
        }
        private static void deleteEnrollment()
        {
            System.out.print("Enter Enrollment ID: ");

            int id = sc.nextInt();

            if(enrollmentService.deleteEnrollment(id))
            {
                System.out.println(
                        "Enrollment Deleted Successfully!");
            }
            else
            {
                System.out.println(
                        "Delete Failed!");
            }
        }
    }




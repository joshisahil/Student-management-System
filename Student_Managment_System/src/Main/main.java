package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;

import model.Attendance;
import model.Fee;
import model.Course;
import model.Student;
import model.Enrollment;
import service.EnrollmentService;
import service.CourseService;
import service.StudentService;
import service.AttendanceService;
import service.FeeService;
import service.ReportService;

public class main
{
    private static Scanner sc = new Scanner(System.in);

    private static StudentService studentService =
            new StudentService();

    private static CourseService courseService =
            new CourseService();
    
    private static EnrollmentService enrollmentService =
            new EnrollmentService();
    
    private static AttendanceService attendanceService =
            new AttendanceService();

    private static FeeService feeService =
            new FeeService();
    
    private static ReportService reportService =
            new ReportService();

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
            System.out.println("4. Attendance Management");
            System.out.println("5. Fee Management");
            System.out.println("6. Reports");
            System.out.println("7. Exit");

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
                    attendanceMenu();
                    break;

                case 5:
                    feeMenu();
                    break;
                    
                case 6:
                	reportsMenu();
                	break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 7);

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
    // ATTENDANCE MENU
    // ==========================
    
    private static void attendanceMenu()
    {
        int choice;

        do
        {
            System.out.println("\n===== ATTENDANCE MANAGEMENT =====");

            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. View All Attendance");
            System.out.println("4. Delete Attendance");
            System.out.println("5. Attendance Report");
            System.out.println("6. Back");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    addAttendance();
                    break;

                case 2:
                    viewAttendance();
                    break;

                case 3:
                    viewAllAttendance();
                    break;

                case 4:
                    deleteAttendance();
                    break;

                case 5:
                    attendanceService
                            .displayAttendanceReport();
                    break;
            }

        } while(choice != 6);
    }
    
    // ==========================
    // FEE MENU
    // ==========================
    
    private static void feeMenu()
    {
        int choice;

        do
        {
            System.out.println("\n===== FEE MANAGEMENT =====");

            System.out.println("1. Add Fee");
            System.out.println("2. View Fee");
            System.out.println("3. View All Fees");
            System.out.println("4. Update Fee");
            System.out.println("5. Delete Fee");
            System.out.println("6. Make Payment");
            System.out.println("7. Fee Report");
            System.out.println("8. Back");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    addFee();
                    break;

                case 2:
                    viewFee();
                    break;

                case 3:
                    viewAllFees();
                    break;

                case 4:
                    updateFee();
                    break;

                case 5:
                    deleteFee();
                    break;

                case 6:
                    makePayment();
                    break;

                case 7:
                    feeService.displayFeeReport();
                    break;
            }

        } while(choice != 8);
    }
    
    // ==========================
    // REPORT MENU
    // ==========================
    
    private static void reportsMenu()
    {
        int choice;

        do
        {
            System.out.println(
                    "\n===== REPORTS =====");
            
            System.out.println(
                    "1. Dashboard");

            System.out.println(
                    "2. Total Students");

            System.out.println(
                    "3. Total Courses");

            System.out.println(
                    "4. Students Per Course");

            System.out.println(
                    "5. Fee Defaulters");

            System.out.println(
                    "6. Attendance Percentage");

            System.out.println(
                    "7. Enrollment Report");
            
            System.out.println(
                    "8. Attendance Report");
            
            System.out.println(
                    "9. Fee Report");
            
            System.out.println(
                    "10. Back");

            choice = sc.nextInt();

            switch(choice)
            {
            case 1:
                reportService.dashboardReport();
                break;

            case 2:
                reportService.totalStudents();
                break;

            case 3:
                reportService.totalCourses();
                break;

            case 4:
                reportService.studentsPerCourse();
                break;

            case 5:
                reportService.feeDefaulters();
                break;

            case 6:
                reportService.attendancePercentage();
                break;

            case 7:
                reportService.enrollmentReport();
                break;

            case 8:
                reportService.attendanceReport();
                break;

            case 9:
                reportService.feeReport();
                break;
            }

        } while(choice != 10);
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
        
     //==========================
     // ATTENDANCE METHODS
     // ==========================
        
        private static void addAttendance()
        {
            System.out.print("Student ID: ");
            int studentId = sc.nextInt();
            sc.nextLine();

            System.out.print("Date (yyyy-mm-dd): ");
            String dateInput = sc.nextLine();

            System.out.print("Status (Present/Absent): ");
            String status = sc.nextLine();

            Attendance attendance =
                    new Attendance(
                            studentId,
                            Date.valueOf(dateInput),
                            status);

            if(attendanceService
                    .addAttendance(attendance))
            {
                System.out.println(
                        "Attendance Added Successfully");
            }
            else
            {
                System.out.println(
                        "Failed");
            }
        }
        
        private static void viewAttendance()
        {
            System.out.print(
                    "Attendance ID: ");

            int id = sc.nextInt();

            Attendance attendance =
                    attendanceService
                            .getAttendanceById(id);

            System.out.println(attendance);
        }
        
        private static void viewAllAttendance()
        {
            ArrayList<Attendance> list =
                    attendanceService
                            .getAllAttendance();

            for(Attendance attendance : list)
            {
                System.out.println(attendance);
            }
        }
        
        private static void deleteAttendance()
        {
            System.out.print(
                    "Attendance ID: ");

            int id = sc.nextInt();

            if(attendanceService
                    .deleteAttendance(id))
            {
                System.out.println(
                        "Deleted Successfully");
            }
            else
            {
                System.out.println(
                        "Delete Failed");
            }
        }
        
        //==========================
        // FEE METHODS
        // ==========================
        
        private static void addFee()
        {
            System.out.print("Student ID: ");
            int studentId = sc.nextInt();

            System.out.print("Total Fee: ");
            double totalFee = sc.nextDouble();

            System.out.print("Paid Fee: ");
            double paidFee = sc.nextDouble();

            double remainingFee =
                    totalFee - paidFee;

            Fee fee =
                    new Fee(
                            studentId,
                            totalFee,
                            paidFee,
                            remainingFee);

            if(feeService.addFee(fee))
            {
                System.out.println(
                        "Fee Added Successfully");
            }
            else
            {
                System.out.println(
                        "Failed");
            }
        }
        
        private static void viewFee()
        {
            System.out.print("Fee ID: ");

            int id = sc.nextInt();

            Fee fee =
                    feeService.getFeeById(id);

            System.out.println(fee);
        }
        
        private static void viewAllFees()
        {
            ArrayList<Fee> fees =
                    feeService.getAllFees();

            for(Fee fee : fees)
            {
                System.out.println(fee);
            }
        }
        
        private static void updateFee()
        {
            System.out.print("Fee ID: ");
            int feeId = sc.nextInt();

            System.out.print("Student ID: ");
            int studentId = sc.nextInt();

            System.out.print("Total Fee: ");
            double totalFee = sc.nextDouble();

            System.out.print("Paid Fee: ");
            double paidFee = sc.nextDouble();

            double remainingFee =
                    totalFee - paidFee;

            Fee fee =
                    new Fee(
                            feeId,
                            studentId,
                            totalFee,
                            paidFee,
                            remainingFee);

            if(feeService.updateFee(fee))
            {
                System.out.println(
                        "Updated Successfully");
            }
            else
            {
                System.out.println(
                        "Update Failed");
            }
        }
        
        private static void deleteFee()
        {
            System.out.print("Fee ID: ");

            int id = sc.nextInt();

            if(feeService.deleteFee(id))
            {
                System.out.println(
                        "Deleted Successfully");
            }
        }
        
        private static void makePayment()
        {
            System.out.print("Fee ID: ");
            int feeId = sc.nextInt();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();

            if(feeService.makePayment(
                    feeId,
                    amount))
            {
                System.out.println(
                        "Payment Successful");
            }
            else
            {
                System.out.println(
                        "Payment Failed");
            }
        }       
    }




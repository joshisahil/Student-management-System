package model;

public class Student
{
    private int studentId;
    private String studentName;
    private int age;
    private String gender;
    private String email;
    private String mobile;
    private String address;

    // Default Constructor
    public Student()
    {
    }

    // Constructor without studentId
    public Student(String studentName, int age, String gender,
                   String email, String mobile, String address)
    {
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    // Constructor with studentId
    public Student(int studentId, String studentName, int age,
                   String gender, String email,
                   String mobile, String address)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    // Getters and Setters

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

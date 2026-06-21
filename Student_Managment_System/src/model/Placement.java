package model;

import java.sql.Date;

public class Placement
{
    private int placementId;
    private int studentId;
    private String studentName;
    private int age;
    private String gender;
    private String email;
    private String mobile;
    private String address;
    private String companyName;
    private String jobRole;
    private double packageAmount;
    private Date placementDate;

    public Placement()
    {
    }

    public Placement(
            int studentId,
            String companyName,
            String jobRole,
            double packageAmount)
    {
        this.studentId = studentId;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.packageAmount = packageAmount;
    }

    public Placement(
            int placementId,
            int studentId,
            String studentName,
            int age,
            String gender,
            String email,
            String mobile,
            String address,
            String companyName,
            String jobRole,
            double packageAmount,
            Date placementDate)
    {
        this.placementId = placementId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.packageAmount = packageAmount;
        this.placementDate = placementDate;
    }

    public int getPlacementId()
    {
        return placementId;
    }

    public void setPlacementId(int placementId)
    {
        this.placementId = placementId;
    }

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

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getJobRole()
    {
        return jobRole;
    }

    public void setJobRole(String jobRole)
    {
        this.jobRole = jobRole;
    }

    public double getPackageAmount()
    {
        return packageAmount;
    }

    public void setPackageAmount(double packageAmount)
    {
        this.packageAmount = packageAmount;
    }

    public Date getPlacementDate()
    {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate)
    {
        this.placementDate = placementDate;
    }

    @Override
    public String toString()
    {
        return "Placement [placementId=" + placementId
                + ", studentId=" + studentId
                + ", studentName=" + studentName
                + ", companyName=" + companyName
                + ", jobRole=" + jobRole
                + ", packageAmount=" + packageAmount
                + ", placementDate=" + placementDate
                + "]";
    }
}
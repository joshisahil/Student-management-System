package model;

import java.sql.Date;

public class CompletionCertificate
{
    private int certificateId;
    private int studentId;
    private int courseId;
    private Date issueDate;

    public CompletionCertificate() {}

    public CompletionCertificate(int studentId, int courseId, Date issueDate)
    {
        this.studentId = studentId;
        this.courseId = courseId;
        this.issueDate = issueDate;
    }

    public int getCertificateId() { return certificateId; }
    public void setCertificateId(int certificateId) { this.certificateId = certificateId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }
}
package dao;

import utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompletionCertificateDAOImpl
        implements CompletionCertificateDAO
{

    @Override
    public boolean generateCertificate(int studentId, int courseId)
    {
        try(Connection con = DBConnection.getConnection())
        {
            // 1. Check enrollment
            String enrollQuery =
            "SELECT * FROM enrollments WHERE student_id=? AND course_id=?";

            PreparedStatement ep = con.prepareStatement(enrollQuery);
            ep.setInt(1, studentId);
            ep.setInt(2, courseId);

            ResultSet er = ep.executeQuery();

            if(!er.next())
            {
                System.out.println("Student not enrolled in course.");
                return false;
            }

            // 2. Check fees
            String feeQuery =
            "SELECT remaining_fee FROM fees WHERE student_id=?";

            PreparedStatement fp = con.prepareStatement(feeQuery);
            fp.setInt(1, studentId);

            ResultSet fr = fp.executeQuery();

            if(fr.next())
            {
                if(fr.getDouble("remaining_fee") > 0)
                {
                    System.out.println("Fees not fully paid.");
                    return false;
                }
            }

            // 4. Insert certificate
            String insert =
            "INSERT INTO completion_certificate(student_id, course_id, issue_date) VALUES(?,?,CURDATE())";

            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();

            System.out.println("Certificate Generated Successfully!");
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void viewCertificate(int studentId)
    {
        try(Connection con = DBConnection.getConnection())
        {
            String query =
            "SELECT cc.certificate_id, s.student_name, c.course_name, cc.issue_date " +
            "FROM completion_certificate cc " +
            "JOIN students s ON cc.student_id=s.student_id " +
            "JOIN courses c ON cc.course_id=c.course_id " +
            "WHERE cc.student_id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                System.out.println("\n===== COURSE COMPLETION CERTIFICATE =====");
                System.out.println("Certificate ID : " + rs.getInt("certificate_id"));
                System.out.println("Student Name   : " + rs.getString("student_name"));
                System.out.println("Course Name    : " + rs.getString("course_name"));
                System.out.println("Issue Date     : " + rs.getDate("issue_date"));
                System.out.println("Status         : COMPLETED");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
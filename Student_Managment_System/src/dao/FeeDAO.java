package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Fee;
import utility.DBConnection;

public class FeeDAO
{
    // Add Fee Record
    public boolean addFee(Fee fee)
    {
        String query =
                "INSERT INTO fees " +
                "(student_id, total_fee, paid_fee, remaining_fee) " +
                "VALUES (?, ?, ?, ?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, fee.getStudentId());
            ps.setDouble(2, fee.getTotalFee());
            ps.setDouble(3, fee.getPaidFee());
            ps.setDouble(4, fee.getRemainingFee());

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Adding Fee: "
                    + e.getMessage());
        }

        return false;
    }

    // Get Fee By ID
    public Fee getFeeById(int feeId)
    {
        String query =
                "SELECT * FROM fees WHERE fee_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, feeId);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                return new Fee(
                        rs.getInt("fee_id"),
                        rs.getInt("student_id"),
                        rs.getDouble("total_fee"),
                        rs.getDouble("paid_fee"),
                        rs.getDouble("remaining_fee"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Fee: "
                    + e.getMessage());
        }

        return null;
    }

    // Get All Fees
    public ArrayList<Fee> getAllFees()
    {
        ArrayList<Fee> fees = new ArrayList<>();

        String query = "SELECT * FROM fees";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                Fee fee = new Fee(
                        rs.getInt("fee_id"),
                        rs.getInt("student_id"),
                        rs.getDouble("total_fee"),
                        rs.getDouble("paid_fee"),
                        rs.getDouble("remaining_fee"));

                fees.add(fee);
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Fetching Fees: "
                    + e.getMessage());
        }

        return fees;
    }

    // Update Fee Record
    public boolean updateFee(Fee fee)
    {
        String query =
                "UPDATE fees " +
                "SET total_fee=?, paid_fee=?, remaining_fee=? " +
                "WHERE fee_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setDouble(1, fee.getTotalFee());
            ps.setDouble(2, fee.getPaidFee());
            ps.setDouble(3, fee.getRemainingFee());
            ps.setInt(4, fee.getFeeId());

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Updating Fee: "
                    + e.getMessage());
        }

        return false;
    }

    // Delete Fee Record
    public boolean deleteFee(int feeId)
    {
        String query =
                "DELETE FROM fees WHERE fee_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setInt(1, feeId);

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Deleting Fee: "
                    + e.getMessage());
        }

        return false;
    }

    // Make Payment
    public boolean makePayment(int feeId,
                               double amount)
    {
        Fee fee = getFeeById(feeId);

        if(fee == null)
        {
            return false;
        }
        
        if(amount > fee.getRemainingFee())
        {
            System.out.println("Payment exceeds remaining fee.");
            return false;
        }

        double newPaidFee =
                fee.getPaidFee() + amount;

        double newRemainingFee =
                fee.getRemainingFee() - amount;

        String query =
                "UPDATE fees " +
                "SET paid_fee=?, remaining_fee=? " +
                "WHERE fee_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query))
        {
            ps.setDouble(1, newPaidFee);
            ps.setDouble(2, newRemainingFee);
            ps.setInt(3, feeId);

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Processing Payment: "
                    + e.getMessage());
        }

        return false;
    }

    // Fee Report
    public void displayFeeReport()
    {
        String query =
                "SELECT f.fee_id, " +
                "s.student_name, " +
                "f.total_fee, " +
                "f.paid_fee, " +
                "f.remaining_fee " +
                "FROM fees f " +
                "JOIN students s " +
                "ON f.student_id = s.student_id";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(query);
            ResultSet rs = ps.executeQuery())
        {
            System.out.println(
                    "\n===== FEE REPORT =====");

            while(rs.next())
            {
                System.out.println(
                        "Fee ID         : "
                        + rs.getInt("fee_id"));

                System.out.println(
                        "Student Name   : "
                        + rs.getString("student_name"));

                System.out.println(
                        "Total Fee      : "
                        + rs.getDouble("total_fee"));

                System.out.println(
                        "Paid Fee       : "
                        + rs.getDouble("paid_fee"));

                System.out.println(
                        "Remaining Fee  : "
                        + rs.getDouble("remaining_fee"));

                System.out.println(
                        "-----------------------------");
            }
        }
        catch(SQLException e)
        {
            System.out.println(
                    "Error Generating Fee Report: "
                    + e.getMessage());
        }
    }
}
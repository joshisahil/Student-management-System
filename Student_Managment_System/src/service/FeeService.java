package service;

import java.util.ArrayList;

import dao.FeeDAO;
import dao.StudentDAO;
import model.Fee;

public class FeeService
{
    private FeeDAO feeDAO;
    private StudentDAO studentDAO;

    public FeeService()
    {
        feeDAO = new FeeDAO();
        studentDAO = new StudentDAO();
    }

    // Add Fee
    public boolean addFee(Fee fee)
    {
        if(fee.getStudentId() <= 0)
        {
            System.out.println("Invalid Student ID.");
            return false;
        }

        if(studentDAO.getStudentById(
                fee.getStudentId()) == null)
        {
            System.out.println(
                    "Student does not exist.");
            return false;
        }

        if(fee.getTotalFee() <= 0)
        {
            System.out.println(
                    "Total fee must be greater than 0.");
            return false;
        }

        if(fee.getPaidFee() < 0)
        {
            System.out.println(
                    "Paid fee cannot be negative.");
            return false;
        }

        if(fee.getPaidFee() >
                fee.getTotalFee())
        {
            System.out.println(
                    "Paid fee cannot exceed total fee.");
            return false;
        }
        
        double remainingFee =
                fee.getTotalFee() -
                fee.getPaidFee();

        fee.setRemainingFee(
                remainingFee);

        return feeDAO.addFee(fee);
    }

    // Get Fee By ID
    public Fee getFeeById(int feeId)
    {
        if(feeId <= 0)
        {
            System.out.println("Invalid Fee ID.");
            return null;
        }

        return feeDAO.getFeeById(feeId);
    }

    // Get All Fees
    public ArrayList<Fee> getAllFees()
    {
        return feeDAO.getAllFees();
    }

    // Update Fee
    public boolean updateFee(Fee fee)
    {
        if(fee.getFeeId() <= 0)
        {
            System.out.println("Invalid Fee ID.");
            return false;
        }

        return feeDAO.updateFee(fee);
    }

    // Delete Fee
    public boolean deleteFee(int feeId)
    {
        if(feeId <= 0)
        {
            System.out.println("Invalid Fee ID.");
            return false;
        }

        return feeDAO.deleteFee(feeId);
    }

    // Make Payment
    public boolean makePayment(int feeId,
                               double amount)
    {
        if(amount <= 0)
        {
            System.out.println(
                    "Payment amount must be positive.");
            return false;
        }

        Fee fee = feeDAO.getFeeById(feeId);

        if(fee == null)
        {
            System.out.println(
                    "Fee record not found.");
            return false;
        }

        if(amount > fee.getRemainingFee())
        {
            System.out.println(
                    "Payment exceeds remaining fee.");
            return false;
        }

        return feeDAO.makePayment(
                feeId,
                amount);
    }

    // Display Fee Report
    public void displayFeeReport()
    {
        feeDAO.displayFeeReport();
    }
}

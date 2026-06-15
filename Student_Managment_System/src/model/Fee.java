package model;

public class Fee
{
    private int feeId;
    private int studentId;
    private double totalFee;
    private double paidFee;
    private double remainingFee;

    // Default Constructor
    public Fee()
    {
    }

    // Constructor without feeId
    public Fee(int studentId,
               double totalFee,
               double paidFee,
               double remainingFee)
    {
        this.studentId = studentId;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
        this.remainingFee = remainingFee;
    }

    // Constructor with feeId
    public Fee(int feeId,
               int studentId,
               double totalFee,
               double paidFee,
               double remainingFee)
    {
        this.feeId = feeId;
        this.studentId = studentId;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
        this.remainingFee = remainingFee;
    }

    // Getters and Setters

    public int getFeeId()
    {
        return feeId;
    }

    public void setFeeId(int feeId)
    {
        this.feeId = feeId;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public double getTotalFee()
    {
        return totalFee;
    }

    public void setTotalFee(double totalFee)
    {
        this.totalFee = totalFee;
    }

    public double getPaidFee()
    {
        return paidFee;
    }

    public void setPaidFee(double paidFee)
    {
        this.paidFee = paidFee;
    }

    public double getRemainingFee()
    {
        return totalFee - paidFee;
    }

    public void setRemainingFee(double remainingFee)
    {
        this.remainingFee = remainingFee;
    }

    @Override
    public String toString()
    {
        return "Fee{" +
                "feeId=" + feeId +
                ", studentId=" + studentId +
                ", totalFee=" + totalFee +
                ", paidFee=" + paidFee +
                ", remainingFee=" + remainingFee +
                '}';
    }
}
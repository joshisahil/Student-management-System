package service;

import dao.ReportDAO;

public class ReportService
{
    private ReportDAO reportDAO;

    public ReportService()
    {
        reportDAO = new ReportDAO();
    }

    public void totalStudents()
    {
        reportDAO.totalStudents();
    }

    public void totalCourses()
    {
        reportDAO.totalCourses();
    }

    public void studentsPerCourse()
    {
        reportDAO.studentsPerCourse();
    }

    public void feeDefaulters()
    {
        reportDAO.feeDefaulters();
    }

    public void attendancePercentage()
    {
        reportDAO.attendancePercentage();
    }
    public void dashboardReport()
    {
        reportDAO.dashboardReport();
    }

	public void enrollmentReport() {
		reportDAO.enrollmentReport();
		
	}

	public void attendanceReport() {
		reportDAO.attendanceReport();
		
	}

	public void feeReport() {
		reportDAO.feeReport();
		
	}
}

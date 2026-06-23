package service;

import dao.CompletionCertificateDAO;
import dao.CompletionCertificateDAOImpl;

public class CompletionCertificateService
{
    private CompletionCertificateDAO dao =
            new CompletionCertificateDAOImpl();

    public boolean generateCertificate(int studentId, int courseId)
    {
        return dao.generateCertificate(studentId, courseId);
    }

    public void viewCertificate(int studentId)
    {
        dao.viewCertificate(studentId);
    }
}
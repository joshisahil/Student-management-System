package dao;

public interface CompletionCertificateDAO
{
    boolean generateCertificate(int studentId, int courseId);

    void viewCertificate(int studentId);
}
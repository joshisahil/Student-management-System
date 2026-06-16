package service;

import dao.AdminDAO;

public class AdminService
{
    private AdminDAO adminDAO;

    public AdminService()
    {
        adminDAO = new AdminDAO();
    }

    public boolean login(String username,
                         String password)
    {
        return adminDAO.login(
                username,
                password);
    }
}

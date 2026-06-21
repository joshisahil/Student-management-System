package service;

import dao.PlacementDAO;

public class PlacementService
{
    private PlacementDAO dao =
            new PlacementDAO();

    public boolean addStudentToPlacement(
            int studentId,
            String companyName,
            String jobRole,
            double packageAmount)
    {
        return dao.addStudentToPlacement(
                studentId,
                companyName,
                jobRole,
                packageAmount);
    }
}
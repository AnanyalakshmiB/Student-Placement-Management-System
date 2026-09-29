package com.placement;

import java.util.Scanner;

import com.placement.dao.ApplicationDAO;
import com.placement.dao.CompanyDAO;
import com.placement.dao.JobDAO;
import com.placement.dao.ReportDAO;
import com.placement.dao.StudentDAO;

import com.placement.service.ApplicationService;
import com.placement.service.CompanyService;
import com.placement.service.JobService;
import com.placement.service.StudentService;

import com.placement.util.ValidationUtil;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ==============================
        // DAO OBJECTS
        // ==============================

        StudentDAO studentDAO = new StudentDAO();
        CompanyDAO companyDAO = new CompanyDAO();
        JobDAO jobDAO = new JobDAO();
        ApplicationDAO applicationDAO = new ApplicationDAO();
        ReportDAO reportDAO = new ReportDAO();

        // ==============================
        // SERVICE OBJECTS
        // ==============================

        StudentService studentService = new StudentService();
        CompanyService companyService = new CompanyService();
        JobService jobService = new JobService();
        ApplicationService applicationService =
                new ApplicationService();

        // ==============================
        // MAIN MENU LOOP
        // ==============================

        while (true) {

            System.out.println("\n========================================");
            System.out.println("   STUDENT PLACEMENT MANAGEMENT SYSTEM");
            System.out.println("========================================");

            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Company");
            System.out.println("7. View All Companies");
            System.out.println("8. Add Job");
            System.out.println("9. View All Jobs");
            System.out.println("10. Apply for Job");
            System.out.println("11. View All Applications");
            System.out.println("12. Update Application Status");
            System.out.println("13. View Placement Dashboard");
            System.out.println("14. View Student Applications");
            System.out.println("15. View Eligible Jobs");
            System.out.println("16. Search Jobs");
            System.out.println("17. Search Jobs by Location");
            System.out.println("18. Exit");
            System.out.println("19. Application Status Report");
            
            
            int choice = ValidationUtil.getValidChoice(sc);

            // ========================================
            // OPTION 1: REGISTER STUDENT
            // ========================================

            if (choice == 1) {

                studentService.registerStudent(
                        sc,
                        studentDAO
                );
            }

            // ========================================
            // OPTION 2: VIEW ALL STUDENTS
            // ========================================

            else if (choice == 2) {

                studentDAO.getAllStudents();
            }

            // ========================================
            // OPTION 3: SEARCH STUDENT
            // ========================================

            else if (choice == 3) {

                studentService.searchStudent(
                        sc,
                        studentDAO
                );
            }

            // ========================================
            // OPTION 4: UPDATE STUDENT
            // ========================================

            else if (choice == 4) {

                studentService.updateStudent(
                        sc,
                        studentDAO
                );
            }

            // ========================================
            // OPTION 5: DELETE STUDENT
            // ========================================

            else if (choice == 5) {

                studentService.deleteStudent(
                        sc,
                        studentDAO
                );
            }

            // ========================================
            // OPTION 6: ADD COMPANY
            // ========================================

            else if (choice == 6) {

                companyService.addCompany(
                        sc,
                        companyDAO
                );
            }

            // ========================================
            // OPTION 7: VIEW ALL COMPANIES
            // ========================================

            else if (choice == 7) {

                companyDAO.getAllCompanies();
            }

            // ========================================
            // OPTION 8: ADD JOB
            // ========================================

            else if (choice == 8) {

                jobService.addJob(
                        sc,
                        companyDAO,
                        jobDAO
                );
            }

            // ========================================
            // OPTION 9: VIEW ALL JOBS
            // ========================================

            else if (choice == 9) {

                jobDAO.getAllJobs();
            }

            // ========================================
            // OPTION 10: APPLY FOR JOB
            // ========================================

            else if (choice == 10) {

                applicationService.applyForJob(
                        sc,
                        studentDAO,
                        jobDAO,
                        applicationDAO
                );
            }

            // ========================================
            // OPTION 11: VIEW ALL APPLICATIONS
            // ========================================

            else if (choice == 11) {

                applicationDAO.getAllApplications();
            }

            // ========================================
            // OPTION 12: UPDATE APPLICATION STATUS
            // ========================================

            else if (choice == 12) {

                applicationService.updateApplicationStatus(
                        sc,
                        applicationDAO
                );
            }

            // ========================================
            // OPTION 13: PLACEMENT DASHBOARD
            // ========================================

            else if (choice == 13) {

                reportDAO.showDashboard();
            }

            // ========================================
            // OPTION 14: VIEW STUDENT APPLICATIONS
            // ========================================

            else if (choice == 14) {

                applicationService.viewStudentApplications(
                        sc,
                        studentDAO,
                        applicationDAO
                );
            }

            // ========================================
            // OPTION 15: VIEW ELIGIBLE JOBS
            // ========================================

            else if (choice == 15) {

                jobService.viewEligibleJobs(
                        sc,
                        studentDAO,
                        jobDAO
                );
            }

            // ========================================
            // OPTION 16: SEARCH JOBS BY TITLE
            // ========================================

            else if (choice == 16) {

                jobService.searchJobsByTitle(
                        sc,
                        jobDAO
                );
            }

            // ========================================
            // OPTION 17: SEARCH JOBS BY LOCATION
            // ========================================

            else if (choice == 17) {

                jobService.searchJobsByLocation(
                        sc,
                        jobDAO
                );
            }
            
            else if (choice == 19) {

                reportDAO.showApplicationStatusReport();
            }

            // ========================================
            // OPTION 18: EXIT
            // ========================================

            else if (choice == 18) {

                System.out.println(
                        "Thank you for using the system!"
                );

                break;
            }

            // ========================================
            // INVALID CHOICE
            // ========================================

            else {

                System.out.println(
                        "Invalid choice. Please try again."
                );
            }
        }

        sc.close();
    }
}
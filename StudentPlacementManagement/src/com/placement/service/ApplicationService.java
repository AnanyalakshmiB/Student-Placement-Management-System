package com.placement.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.placement.dao.ApplicationDAO;
import com.placement.dao.JobDAO;
import com.placement.dao.StudentDAO;
import com.placement.model.Application;
import com.placement.util.ValidationUtil;

public class ApplicationService {

    // =====================================================
    // 1. APPLY FOR JOB
    // =====================================================

    public void applyForJob(
            Scanner sc,
            StudentDAO studentDAO,
            JobDAO jobDAO,
            ApplicationDAO applicationDAO) {

        int studentId =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter student ID: "
                );

        // Check student exists
        if (!studentDAO.studentExistsById(studentId)) {

            System.out.println(
                    "Student ID " + studentId + " does not exist."
            );

            return;
        }

        int jobId =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter job ID: "
                );

        // Check job exists
        if (!jobDAO.jobExistsById(jobId)) {

            System.out.println(
                    "Job ID " + jobId + " does not exist."
            );

            return;
        }

        // Check duplicate application
        if (applicationDAO.applicationExists(
                studentId,
                jobId)) {

            System.out.println(
                    "Student has already applied for this job."
            );

            System.out.println(
                    "Duplicate application is not allowed."
            );

            return;
        }

        // Check eligibility
        boolean eligible =
                jobDAO.isStudentEligible(
                        studentId,
                        jobId
                );

        if (!eligible) {

            System.out.println(
                    "Student is NOT eligible for this job."
            );

            System.out.println(
                    "Application cannot be submitted."
            );

            return;
        }

        System.out.println(
                "Student is eligible!"
        );

        // Create Application object
        Application application =
                new Application(
                        studentId,
                        jobId,
                        LocalDate.now(),
                        "Applied"
                );

        // Save application
        applicationDAO.saveApplication(
                application
        );
    }


    // =====================================================
    // 2. UPDATE APPLICATION STATUS
    // =====================================================

    public void updateApplicationStatus(
            Scanner sc,
            ApplicationDAO applicationDAO) {

        int applicationId =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter application ID: "
                );

        // Check application exists
        if (!applicationDAO.applicationExistsById(
                applicationId)) {

            System.out.println(
                    "Application ID "
                    + applicationId
                    + " does not exist."
            );

            return;
        }

        System.out.println(
                "\nChoose Application Status:"
        );

        System.out.println("1. Applied");
        System.out.println("2. Shortlisted");
        System.out.println("3. Selected");
        System.out.println("4. Rejected");

        int statusChoice =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Choose status: "
                );

        String status;

        if (statusChoice == 1) {

            status = "Applied";

        } else if (statusChoice == 2) {

            status = "Shortlisted";

        } else if (statusChoice == 3) {

            status = "Selected";

        } else if (statusChoice == 4) {

            status = "Rejected";

        } else {

            System.out.println(
                    "Invalid status! Please choose 1 to 4."
            );

            return;
        }

        applicationDAO.updateApplicationStatus(
                applicationId,
                status
        );
    }


    // =====================================================
    // 3. VIEW STUDENT APPLICATIONS
    // =====================================================

    public void viewStudentApplications(
            Scanner sc,
            StudentDAO studentDAO,
            ApplicationDAO applicationDAO) {

        int studentId =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter student ID: "
                );

        // Check student exists
        if (!studentDAO.studentExistsById(studentId)) {

            System.out.println(
                    "Student ID "
                    + studentId
                    + " does not exist."
            );

            return;
        }

        applicationDAO.getApplicationsByStudent(
                studentId
        );
    }
}
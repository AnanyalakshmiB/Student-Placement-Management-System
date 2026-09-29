package com.placement.service;

import java.util.Scanner;

import com.placement.dao.CompanyDAO;
import com.placement.dao.JobDAO;
import com.placement.model.Job;
import com.placement.util.ValidationUtil;
import com.placement.dao.StudentDAO;

public class JobService {

    public void addJob(
            Scanner sc,
            CompanyDAO companyDAO,
            JobDAO jobDAO) {

        int companyId =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter company ID: "
                );

        // Check company exists
        if (!companyDAO.companyExistsById(companyId)) {

            System.out.println(
                    "Company ID " + companyId + " does not exist."
            );

            return;
        }

        String jobTitle =
                ValidationUtil.getValidJobTitle(sc);

        double salary =
                ValidationUtil.getValidSalary(sc);

        double minimumCgpa =
                ValidationUtil.getValidMinimumCgpa(sc);

        String location =
                ValidationUtil.getValidLocation(sc);

        // Check duplicate job
        if (jobDAO.jobExists(companyId, jobTitle)) {

            System.out.println(
                    "This job already exists for this company."
            );

            return;
        }

        Job job =
                new Job(
                        companyId,
                        jobTitle,
                        salary,
                        minimumCgpa,
                        location
                );

        jobDAO.saveJob(job);
    }
    
    public void viewEligibleJobs(
            Scanner sc,
            StudentDAO studentDAO,
            JobDAO jobDAO) {

        int studentId =
                ValidationUtil.getValidPositiveInteger(
                        sc,
                        "Enter student ID: "
                );

        if (!studentDAO.studentExistsById(studentId)) {

            System.out.println(
                    "Student ID " + studentId + " does not exist."
            );

            return;
        }

        jobDAO.getEligibleJobs(studentId);
    }
    
    public void searchJobsByTitle(
            Scanner sc,
            JobDAO jobDAO) {

        System.out.print("Enter job title to search: ");

        String keyword = sc.nextLine().trim();

        if (keyword.isEmpty()) {

            System.out.println(
                    "Job title cannot be empty."
            );

            return;
        }

        jobDAO.searchJobsByTitle(keyword);
    }
    
    public void searchJobsByLocation(
            Scanner sc,
            JobDAO jobDAO) {

        System.out.print("Enter location to search: ");

        String location = sc.nextLine().trim();

        if (location.isEmpty()) {

            System.out.println(
                    "Location cannot be empty."
            );

            return;
        }

        jobDAO.searchJobsByLocation(location);
    }
}
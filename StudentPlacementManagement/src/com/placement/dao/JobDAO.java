package com.placement.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import com.placement.model.Job;
import com.placement.util.DBConnection;

public class JobDAO {

    public void saveJob(Job job) {

        String sql = "INSERT INTO jobs "
                + "(company_id, job_title, salary, minimum_cgpa, location) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, job.getCompanyId());
            ps.setString(2, job.getJobTitle());
            ps.setDouble(3, job.getSalary());
            ps.setDouble(4, job.getMinimumCgpa());
            ps.setString(5, job.getLocation());

            ps.executeUpdate();

            System.out.println("Job saved successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
    public void getAllJobs() {

        String sql = "SELECT j.id, c.name AS company_name, "
                + "j.job_title, j.salary, j.minimum_cgpa, j.location "
                + "FROM jobs j "
                + "JOIN companies c ON j.company_id = c.id";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            java.sql.ResultSet rs = ps.executeQuery();

            System.out.println("\n----- ALL JOBS -----");

            while (rs.next()) {

                System.out.println("Job ID       : " + rs.getInt("id"));
                System.out.println("Company      : " + rs.getString("company_name"));
                System.out.println("Job Title    : " + rs.getString("job_title"));
                System.out.println("Salary       : " + rs.getDouble("salary") + " LPA");
                System.out.println("Minimum CGPA : " + rs.getDouble("minimum_cgpa"));
                System.out.println("Location     : " + rs.getString("location"));

                System.out.println("--------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
    public boolean isStudentEligible(int studentId, int jobId) {

        String sql = "SELECT s.cgpa, j.minimum_cgpa "
                + "FROM students s "
                + "JOIN jobs j "
                + "WHERE s.id = ? AND j.id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, jobId);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double studentCgpa = rs.getDouble("cgpa");
                double minimumCgpa = rs.getDouble("minimum_cgpa");

                System.out.println("Student CGPA : " + studentCgpa);
                System.out.println("Required CGPA: " + minimumCgpa);

                rs.close();
                ps.close();
                con.close();

                return studentCgpa >= minimumCgpa;
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
    
    public boolean jobExists(int companyId, String jobTitle) {

        String sql =
                "SELECT id FROM jobs WHERE company_id = ? AND job_title = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, companyId);
            ps.setString(2, jobTitle);

            java.sql.ResultSet rs =
                    ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            con.close();

            return exists;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    
    public boolean jobExistsById(int jobId) {

        String sql = "SELECT id FROM jobs WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, jobId);

            java.sql.ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            con.close();

            return exists;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    
    public void getEligibleJobs(int studentId) {

        String sql =
                "SELECT j.id, j.job_title, c.name AS company_name, "
                + "j.salary, j.minimum_cgpa, j.location "
                + "FROM students s "
                + "JOIN jobs j ON s.cgpa >= j.minimum_cgpa "
                + "JOIN companies c ON j.company_id = c.id "
                + "WHERE s.id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n----- ELIGIBLE JOBS -----");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "Job ID       : " + rs.getInt("id")
                );

                System.out.println(
                        "Job Title    : " + rs.getString("job_title")
                );

                System.out.println(
                        "Company      : " + rs.getString("company_name")
                );

                System.out.println(
                        "Salary       : " + rs.getDouble("salary")
                );

                System.out.println(
                        "Minimum CGPA : " + rs.getDouble("minimum_cgpa")
                );

                System.out.println(
                        "Location     : " + rs.getString("location")
                );

                System.out.println("-------------------------");
            }

            if (!found) {

                System.out.println(
                        "No eligible jobs found for this student."
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
   
    
    public void searchJobsByTitle(String keyword) {

        String sql =
                "SELECT j.id, j.job_title, c.name AS company_name, "
                + "j.salary, j.minimum_cgpa, j.location "
                + "FROM jobs j "
                + "JOIN companies c ON j.company_id = c.id "
                + "WHERE LOWER(j.job_title) LIKE LOWER(?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n----- JOB SEARCH RESULTS -----");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "Job ID       : " + rs.getInt("id")
                );

                System.out.println(
                        "Job Title    : " + rs.getString("job_title")
                );

                System.out.println(
                        "Company      : " + rs.getString("company_name")
                );

                System.out.println(
                        "Salary       : " + rs.getDouble("salary")
                );

                System.out.println(
                        "Minimum CGPA : " + rs.getDouble("minimum_cgpa")
                );

                System.out.println(
                        "Location     : " + rs.getString("location")
                );

                System.out.println("-----------------------------");
            }

            if (!found) {

                System.out.println(
                        "No jobs found for: " + keyword
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    public void searchJobsByLocation(String location) {

        String sql =
                "SELECT j.id, j.job_title, c.name AS company_name, "
                + "j.salary, j.minimum_cgpa, j.location "
                + "FROM jobs j "
                + "JOIN companies c ON j.company_id = c.id "
                + "WHERE LOWER(j.location) LIKE LOWER(?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, "%" + location + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n----- JOBS BY LOCATION -----");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "Job ID       : " + rs.getInt("id")
                );

                System.out.println(
                        "Job Title    : " + rs.getString("job_title")
                );

                System.out.println(
                        "Company      : " + rs.getString("company_name")
                );

                System.out.println(
                        "Salary       : " + rs.getDouble("salary")
                );

                System.out.println(
                        "Minimum CGPA : " + rs.getDouble("minimum_cgpa")
                );

                System.out.println(
                        "Location     : " + rs.getString("location")
                );

                System.out.println("-----------------------------");
            }

            if (!found) {

                System.out.println(
                        "No jobs found in: " + location
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    
}
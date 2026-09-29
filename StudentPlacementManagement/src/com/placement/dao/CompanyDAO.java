package com.placement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.placement.model.Company;
import com.placement.util.DBConnection;


public class CompanyDAO {

    public void saveCompany(Company company) {

        String sql = "INSERT INTO companies (name, location, website) VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, company.getName());
            ps.setString(2, company.getLocation());
            ps.setString(3, company.getWebsite());

            ps.executeUpdate();

            System.out.println("Company saved successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void getAllCompanies() {

        String sql = "SELECT * FROM companies";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            java.sql.ResultSet rs = ps.executeQuery();

            System.out.println("\n----- ALL COMPANIES -----");

            while (rs.next()) {

                System.out.println("ID       : " + rs.getInt("id"));
                System.out.println("Name     : " + rs.getString("name"));
                System.out.println("Location : " + rs.getString("location"));
                System.out.println("Website  : " + rs.getString("website"));

                System.out.println("-------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
           
    }
    
    public boolean companyExists(String name) {

        String sql =
                "SELECT id FROM companies WHERE LOWER(name) = LOWER(?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

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
    
    public boolean companyExistsById(int companyId) {

        String sql = "SELECT id FROM companies WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, companyId);

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
   
}
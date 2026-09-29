package com.placement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.placement.util.DBConnection;

public class ReportDAO {

	public void showDashboard() {

	    String studentSql =
	            "SELECT COUNT(*) AS total FROM students";

	    String companySql =
	            "SELECT COUNT(*) AS total FROM companies";

	    String jobSql =
	            "SELECT COUNT(*) AS total FROM jobs";

	    String applicationSql =
	            "SELECT COUNT(*) AS total FROM applications";

	    String selectedSql =
	            "SELECT COUNT(*) AS total FROM applications " +
	            "WHERE status = 'Selected'";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps1 =
	                con.prepareStatement(studentSql);

	        ResultSet rs1 = ps1.executeQuery();
	        rs1.next();
	        int students = rs1.getInt("total");

	        PreparedStatement ps2 =
	                con.prepareStatement(companySql);

	        ResultSet rs2 = ps2.executeQuery();
	        rs2.next();
	        int companies = rs2.getInt("total");

	        PreparedStatement ps3 =
	                con.prepareStatement(jobSql);

	        ResultSet rs3 = ps3.executeQuery();
	        rs3.next();
	        int jobs = rs3.getInt("total");

	        PreparedStatement ps4 =
	                con.prepareStatement(applicationSql);

	        ResultSet rs4 = ps4.executeQuery();
	        rs4.next();
	        int applications = rs4.getInt("total");

	        PreparedStatement ps5 =
	                con.prepareStatement(selectedSql);

	        ResultSet rs5 = ps5.executeQuery();
	        rs5.next();
	        int selected = rs5.getInt("total");

	        System.out.println("\n================================");
	        System.out.println("       PLACEMENT DASHBOARD");
	        System.out.println("================================");

	        System.out.println("Total Students     : " + students);
	        System.out.println("Total Companies    : " + companies);
	        System.out.println("Total Jobs         : " + jobs);
	        System.out.println("Total Applications : " + applications);
	        System.out.println("Students Selected  : " + selected);

	        System.out.println("================================");

	        rs1.close();
	        rs2.close();
	        rs3.close();
	        rs4.close();
	        rs5.close();

	        ps1.close();
	        ps2.close();
	        ps3.close();
	        ps4.close();
	        ps5.close();

	        con.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	
    }
	
	public void showApplicationStatusReport() {

	    String sql =
	            "SELECT status, COUNT(*) AS total " +
	            "FROM applications " +
	            "GROUP BY status";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        System.out.println("\n----- APPLICATION STATUS REPORT -----");

	        while (rs.next()) {

	            System.out.println(
	                    rs.getString("status")
	                    + " : "
	                    + rs.getInt("total")
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
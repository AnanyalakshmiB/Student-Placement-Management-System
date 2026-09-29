package com.placement.service;

import java.util.Scanner;

import com.placement.dao.CompanyDAO;
import com.placement.model.Company;
import com.placement.util.ValidationUtil;

public class CompanyService {

	public void addCompany(
	        Scanner sc,
	        CompanyDAO companyDAO) {

	    String name =
	            ValidationUtil.getValidCompanyName(sc);

	    // Check duplicate company
	    if (companyDAO.companyExists(name)) {

	        System.out.println(
	                "Company already exists!"
	        );

	        return;
	    }

	    String location =
	            ValidationUtil.getValidLocation(sc);

	    String website =
	            ValidationUtil.getValidWebsite(sc);

	    Company company =
	            new Company(
	                    name,
	                    location,
	                    website
	            );

	    companyDAO.saveCompany(company);
	}
    
}
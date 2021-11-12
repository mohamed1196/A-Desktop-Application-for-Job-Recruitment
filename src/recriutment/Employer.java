/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recriutment;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mazen174825
 */
public class Employer extends User {
    private String jobRole;
    private String CompanyName;
    private String CompanyPhone;
    private String ComapnyIndustry;
    private String BussinessMail;
    private String CompanyWebsite;
    private String CompanyAddress;


    public Employer( String name, int age, String phone, String address,
                     String gender, String email, String password, String type,
                     String jobRole, String companyName, String companyPhone, String comapnyIndustry,
                     String bussinessMail, String companyWebsite, String companyAddress) {

        super( name, age, phone, address, gender, email, password, type);
        this.jobRole = jobRole;
        this.CompanyName = companyName;
        this.CompanyPhone = companyPhone;
        this.ComapnyIndustry = comapnyIndustry;
        this.BussinessMail = bussinessMail;
        this.CompanyWebsite = companyWebsite;
        this.CompanyAddress = companyAddress;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getCompanyPhone() {
        return CompanyPhone;
    }

    public void setCompanyPhone(String CompanyPhone) {
        this.CompanyPhone = CompanyPhone;
    }

    public String getComapnyIndustry() {
        return ComapnyIndustry;
    }

    public void setComapnyIndustry(String ComapnyIndustry) {
        this.ComapnyIndustry = ComapnyIndustry;
    }

    public String getBussinessMail() {
        return BussinessMail;
    }

    public void setBussinessMail(String BussinessMail) {
        this.BussinessMail = BussinessMail;
    }

    public String getCompanyWebsite() {
        return CompanyWebsite;
    }

    public void setCompanyWebsite(String CompanyWebsite) {
        this.CompanyWebsite = CompanyWebsite;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String CompanyAddress) {
        this.CompanyAddress = CompanyAddress;
    }



}

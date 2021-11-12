/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recriutment;


import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author mazen174825
 */
public class  Application {
    private String applicantName;
    private String applicantEmail;
    private String qualifications;
    private String applicantbrief;
    private boolean Appstatus;
    private DBConnection D ;
    private int vacancy_id;
 


    public Application(String applicantName, String applicantEmail, String qualifications, String applicantbrief) {
        this.applicantName = applicantName;
        this.applicantEmail = applicantEmail;
        this.qualifications = qualifications;
        this.applicantbrief = applicantbrief;
        this.D = new DBConnection();


    }

    public int getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getApplicantbrief() {
        return applicantbrief;
    }

    public void setApplicantbrief(String applicantbrief) {
        this.applicantbrief = applicantbrief;
    }


    public void fillApplication(String applicantName, String applicantEmail, String qualifications, String applicantbrief, int userid, int vacancy_id ) {
        D.InsertApplication(applicantName, applicantEmail, qualifications, applicantbrief, userid, vacancy_id);
    }

    public void searchApplicants() {
        ArrayList<Application> applist= new ArrayList<>();
        applist= (ArrayList<Application>) D.getApplications(this.vacancy_id);
    }

    

    

    
}




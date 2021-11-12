/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recriutment;


import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author mazen174825
 */




public class Vacancy {
    private String title;
    private String type;
    private String about;
    private String requirements;
    private String educationLevel;
    private String languages;
    private float salary;
    private int openPositions;
    private int emp_id;
    private DBConnection D;

    public Vacancy(String title,String type,String about, String requirements, String educationLevel,String languages, float salary, int openPositions , int emp_id){
        this.title = title;
        this.type = type;
        this.about = about;
        this.requirements = requirements;
        this.educationLevel = educationLevel;
        this.languages = languages;
        this.salary = salary;
        this.openPositions = openPositions;
        this.emp_id = emp_id;
        this.D = new DBConnection();

    }

    //start-----------of---------setters----and-------------getters---------------------------------------------

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getLanguages() {
        return languages;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setOpenPositions(int openPositions) {
        this.openPositions = openPositions;
    }

    public int getOpenPositions() {
        return openPositions;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    //end-----------of---------setters----and-------------getters---------------------------------------------

    public void addVacancy(){
        D.InsertVacancy( this.title, this.type, this.about, this.requirements, this.educationLevel, this.languages, this.salary, this.openPositions , this.emp_id);

    }

    public void searchEmployerVacancy(){
        D.RetrieveEmployerVacancy(this.emp_id);
    }

    public void getVacancyID(){
        D.RetrieveVacancyID(this.title);
    }




}


package recriutment;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs=null;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/recruit_me", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println("error: " + ex);
        }
    }

    public void InsertApplication(String applicantName, String applicantEmail, String qualifications, String applicantbrief, int UserId, int vacancy_id) {
        try {
            String sql = ("INSERT INTO application (app_id, app_name, app_email, app_qualification, app_brief, app_js_id) " +
                    "VALUES (NULL, '" + applicantName + "', '" + applicantEmail + "', '" + qualifications + "', '" + applicantbrief + "', '" + UserId + "' )");

            st.executeUpdate(sql);
            String sql2 = ("SELECT app_id FROM application WHERE app_name = '"+ applicantName +"' " );
            rs = st.executeQuery(sql2);
            int curr_id = 0;
            if(rs.first()){
                 curr_id = rs.getInt("app_id");
            }
            String sql3 = ("INSERT INTO  vacancyapp (appID, vacancyID) " + " VALUES('"+curr_id+"', '"+vacancy_id+"' )" );
            st.executeUpdate(sql3);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet getApplications(int vacancy_ID) {
        try {
            rs = st.executeQuery("select * from application WHERE app_id IN(select appID from vacancyapp where vacancyID = '"+ vacancy_ID + "' )  "  );

        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return rs;
    }
     public ArrayList<Application> getallApplications() {
         ArrayList<Application> result = new ArrayList();
        try {
            rs = st.executeQuery("select * from application");
            while (rs.next()) {
                result.add(new Application(rs.getString("app_name"),rs.getString("app_email"),rs.getString("app_qualification"),rs.getString("app_brief")));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return result;
    }
     
     public boolean RetrieveApplicationStatus(int app_id) {
        boolean app_status = false;
        try {
            String sql = ("SELECT app_status FROM `application` WHERE app_id = '" + app_id +"' ");
            rs = st.executeQuery(sql);
            if(rs.first()){
                app_status = rs.getBoolean("app_status");
            }

        } catch (Exception e) {
            System.out.println(e);


        }
        return app_status;

    }
     
     
      public void updateAppStatus(int app_id, boolean app_status ) {
        try {
            if(app_status == true){
                String sql = ("INSERT INTO application (app_status) WHERE app_id = '"+ app_id +"' "  +
                    "VALUES ('" + app_status + "' )");
                st.executeUpdate(sql);
            }
            else if(app_status == false){
                String sq2 = ("DELETE * FROM application WHERE app_id = '"+ app_id +"' ");
                st.executeLargeUpdate(sq2);
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void InsertVacancy(String title, String type, String about, String requirements, String educationLevel, String languages, float salary, int openPositions, int emp_id) {
        try {
            String sql = ("INSERT INTO vacancy (v_id, v_title, v_type, v_about, v_requirements, v_edu_lvl, v_lang, v_salary, v_open_position, employer_id ) " +
                    "VALUES (NULL, '" + title + "', '" + type + "', '" + about + "', '" + requirements + "', '" + educationLevel + "', '" + languages + "', '" + salary + "', '" + openPositions + "', '" + emp_id + "')");
            st.executeUpdate(sql);
            WatchVacancies w = new WatchVacancies();
            w.setNS(title);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet RetrieveAllVacancies() {
        try {
            String sql = ("SELECT * FROM `vacancy` ");
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public int RetrieveVacancyID(String title) {
        int id = 0;
        try {
            String sql = ("SELECT v_id FROM `vacancy` WHERE v_title = '" + title +"' ");
            rs = st.executeQuery(sql);
            if(rs.first()){
                id = rs.getInt("v_id");
            }

        } catch (Exception e) {
            System.out.println(e);


        }
        return id;

    }


    public ResultSet RetrieveEmployerVacancy(int Employer_ID) {
        try {
            String sql = ("SELECT * FROM `vacancy` WHERE employer_id = '" + Employer_ID +"' ");
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e);


        }
        return rs;
    }

    public ResultSet getAllUsers() {
        try {
            rs = st.executeQuery("select * from user");
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return rs;
    }

    public ArrayList<User> checkUsers(){
        ArrayList<User> result = new ArrayList();
        try {
            rs = st.executeQuery("select * from user");
            while (rs.next()) {
                result.add(new User( rs.getString("u_name"), rs.getInt("u_age"), rs.getString("u_phone"), rs.getString("u_address"), rs.getString("u_gender"), rs.getString("u_email"), rs.getString("u_password"), rs.getString("u_type")));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return result;
    }

    public void insertJobseeker(Jobseeker js){
        try {
            String sql = "INSERT INTO `user` (`u_id`, `u_name`, `u_age`, `u_phone`, `u_address`, `u_gender`, `u_email`, `u_password`, `u_type`) " + "VALUES (NULL, '"+js.getName()+"', '"+js.getAge()+"', '"+js.getPhone()+"', '"+js.getAddress()+"', '"+js.getGender()+"', '"+js.getEmail()+"', '"+js.getPassword()+"', '"+js.getType()+"')";

            st.executeUpdate(sql);
            int id = 0;
            String sql2 = "SELECT u_id FROM `user` WHERE u_email = '" + js.getEmail() + "' ";
            rs = st.executeQuery(sql2);
            if (rs.first()) {
                id = rs.getInt("u_id");
            }

            String sql3 = "INSERT INTO `jobseeker` (`js_id`, `js_degree`, `js_careerLvl`) " + "VALUES ('"+id+"', '"+js.getDegree()+"', '"+js.getCareerlvl()+"')";
            st.executeUpdate(sql3);

        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
    }

    public void insertEmployer(Employer emp){
        try {
            String sql = "INSERT INTO `user` (`u_id`, `u_name`, `u_age`, `u_phone`, `u_address`, `u_gender`, `u_email`, `u_password`, `u_type`) " +
                    "VALUES (NULL, '"+emp.getName()+"', '"+emp.getAge()+"', '"+emp.getPhone()+"', '"+emp.getAddress()+"', '"+emp.getGender()+"', '"+emp.getEmail()+"', '"+emp.getPassword()+"', '"+emp.getType()+"')";

            st.executeUpdate(sql);
            int id = 0;
            String sql2 = "SELECT u_id FROM `user` WHERE u_email = '" + emp.getEmail() + "' ";
            rs = st.executeQuery(sql2);
            if (rs.first()) {
                id = rs.getInt("u_id");
            }

            String sql3 = "INSERT INTO `employer` (`emp_id`, `emp_jobRole`, `emp_company_name`, `emp_company_phone`, `emp_company_industry`, `emp_bussiness_mail`, `emp_company_website`, `emp_company_address`) " +
                    "VALUES ('"+id+"', '"+emp.getJobRole()+"', '"+emp.getCompanyName()+"', '"+emp.getPhone()+"', '"+emp.getComapnyIndustry()+"', '"+emp.getBussinessMail()+"', '"+emp.getCompanyWebsite()+"', '"+emp.getCompanyAddress()+"')";
            st.executeUpdate(sql3);

        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
    }

    public int currentUserID(String email) {
        int id = 0;
        try {
            String sql = ("SELECT u_id FROM `user` WHERE u_email = '" + email +"' ");
            rs = st.executeQuery(sql);
            if(rs.first()){
                id = rs.getInt("u_id");
            }

        } catch (Exception e) {
            System.out.println(e);


        }
        return id;

    }

    public String RetrieveCurrentUserName(int currID) {
        String currName = "";
        try {
            String sql = ("SELECT u_name FROM `user` WHERE u_id = '" + currID +"' ");
            rs = st.executeQuery(sql);
            if(rs.first()){
                currName = rs.getString("u_name");
            }

        } catch (Exception e) {
            System.out.println(e);


        }
        return currName;

    }
public void updateJobseeker(String Email, String password, String degree,String careerlvl , int id){
    try{
        String sql = "update user set u_email = '" + Email + "'"+"set u_password = '" + password + "'"+"where U_id = '"+ id ;
        st.executeUpdate(sql);
        String sql1 = "update jobseeker set js_degree = '" + degree + "'"+"set js_careerlvl = '" + careerlvl + "'"+"where js_id = '"+ id ;
        st.executeUpdate(sql1);
    }catch(Exception e){
        
    }
}
public void updateEmployer(String Email, String password, String companyWbsite,String companyAddress , int id){
    try{
        String sql = "update user set u_email = '" + Email + "'"+"set u_password = '" + password + "'"+"where U_id = '"+ id ;
        st.executeUpdate(sql);
        String sql1 = "update employer set emp_company_website = '" + companyWbsite +"'"+ "set emp_company_address = '" + companyAddress + "'"+"where js_id = '"+ id ;
        st.executeUpdate(sql1);
    }catch(Exception e){
        
    }
}


}
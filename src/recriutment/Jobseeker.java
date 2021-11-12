/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recriutment;

import java.util.ArrayList;


/**
 *
 * @author mazen174825
 */
public class Jobseeker extends User  implements Observer {

    private String degree;
    private String careerlvl;
    private static int OIDT=0;
    private int OID;
    private Subject WV;
    public  ArrayList<String> notification = new ArrayList<>(); 

    public Jobseeker( String name, int age, String phone, String address, String gender, String email, String password, String type, String degree, String careerlvl,Subject SWV) {
        super( name, age, phone, address, gender, email, password, type);
        this.degree = degree;
        this.careerlvl = careerlvl;
        this.WV=SWV;
        this.OID=++OIDT;
        WV.register(this);
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCareerlvl() {
        return careerlvl;
    }

    public void setCareerlvl(String careerlvl) {
        this.careerlvl = careerlvl;
    }

    @Override
    public void update(String N) {
        //String n=
        this.notification.add(N);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recriutment;

import java.sql.ResultSet;

/**
 *
 * @author mazen174825
 */
public interface vacancyReadOnly {
      DBConnection DB=new DBConnection();
     ResultSet result = DB.RetrieveAllVacancies();
    
}

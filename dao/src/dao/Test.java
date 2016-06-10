/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
public class Test {
    
    public static void main(String[] args){
     Empleat empleat = new EmpleatBean(1,"sergi", new Date());
     Empleat empleat2 = new EmpleatBean(2,"joan", new Date());
     
    EmpleatDAO dao = DAOFactory.crearEmpleatDAOJDBC();
        try {
            
            dao.crearEmpleat(empleat);
            dao.crearEmpleat(empleat2);
            System.out.println(dao.llistarEmpleats());
            System.out.println(dao.llegirEmpleat(1));
            //dao.actualitzarEmpleat(empleat);
            System.out.println(dao.getTotalEmpleats());
            dao.esborrarEmpleat(2);
            System.out.println(dao.llistarEmpleats());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
}
   
    
                        
                        
}

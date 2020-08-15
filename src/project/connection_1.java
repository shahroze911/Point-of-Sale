/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ashir Ali
 */

// implemention of singlton pattern here 
// conneciton object will be returned and used in the code 
public class connection {
    static Connection conn=null;
    public static Connection getconnect(){
        try{
            
            if(conn==null){
            String url="jdbc:mysql://localhost/project";
            String user="root";
            String pass="";
            conn=(Connection) DriverManager.getConnection(url, user, pass);
            }
        }
        catch(Exception e){
        e.printStackTrace();
        }
        return conn;
    
    }
    

}

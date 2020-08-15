/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_model;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.connection;

/**
 *
 * @author Ashir Ali
 */
public class sales {
    
    public sales(){}
    public void add(String date,int quantity,int amount){
          try {
              Connection connect=connection.getconnect();
              Statement st=(Statement) connect.createStatement();           
              String sql="insert into sales(date,quantity,amount) VALUES('"+date+"','"+quantity+"','"+amount+"')";
              st.execute(sql);
            } catch (SQLException ex) {
              Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
}

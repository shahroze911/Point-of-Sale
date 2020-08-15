/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_model;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.connection;

/**
 *
 * @author Ashir Ali
 */
public class receipt {
    public int count=0;
    public int quantity=0;
    public int amount=0;
    public receipt(){}
  public void addd(String date,int quantity,int amount){
          try {
              Connection connect=connection.getconnect();
              Statement st=(Statement) connect.createStatement();           
              String sql="insert into receipt(date,quantity,price) VALUES('"+date+"','"+quantity+"','"+amount+"')";
              st.execute(sql);
            } catch (SQLException ex) {
              Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

}

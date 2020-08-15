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
public class admin {
    ResultSet empty=null;
   String username;
   String name;
   String phone;
   String password;
   String address;
 
   public admin(){}
   
    public void addcashier(String username,String password,String name,String phone,String address){
          try {
              Connection connect=connection.getconnect();
              Statement st=(Statement) connect.createStatement();
              String sql="Insert into user(username,password,name,phone,address) VALUES('"+username+"','"+password+"','"+name+"','"+phone+"','"+address+"')";
              st.execute(sql);
          } catch (SQLException ex) {
              Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      public void add_item(String name,int price,int stock){
          try {
              Connection connect=connection.getconnect();
              Statement st=(Statement) connect.createStatement();
              
              String sql="insert into items(name,price,stock) VALUES('"+name+"','"+price+"','"+stock+"')";
              st.execute(sql);
            } catch (SQLException ex) {
              Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      public void remove_cashier(String username){
          try {
              Connection connect=connection.getconnect();
              Statement st=(Statement) connect.createStatement();
              String sql="DELETE from user where username='"+username+"'";
              st.execute(sql);
          } catch (SQLException ex) {
              Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
        public void remove_item(String name){
          try {
              Connection connect=connection.getconnect();
              Statement st=(Statement) connect.createStatement();
              String sql="DELETE from items where name='"+name+"'";
              st.execute(sql);
          } catch (SQLException ex) {
              Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
       public void update(String oldname,String name,int price,int stock){
          try {
              Connection connect=connection.getconnect();
              Statement st=(Statement) connect.createStatement();
              String sql="Update items Set name='"+name+"',price='"+price+"',stock='"+stock+"' where name='"+oldname+"'";
              st.execute(sql);
          } catch (SQLException ex) {
              Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
       public ResultSet view(){
           
          try {
              
              Connection connect=connection.getconnect();
              Statement st=(Statement) connect.createStatement();
              String sql="SELECT * FROM SALES";
              empty=st.executeQuery(sql);
              return empty;
          } catch (SQLException ex) {
              Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
              return empty;
          }
          
      } 
}

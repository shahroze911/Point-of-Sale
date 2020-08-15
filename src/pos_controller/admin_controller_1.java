/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_controller;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pos_model.admin;
import pos_model.cashier;
import project.connection;

/**
 *
 * @author Ashir Ali
 */
public class admin_controller {
    
      admin ad=new admin();
      cashier cash=new cashier();
      public admin_controller(){
      
      }
      public void addcashier(String username,String password,String name,String phone,String address){
      ad.addcashier(username, password, name, phone, address);
      }
      public void add_item(String name,int price,int stock){
       ad.add_item(name, price, stock);
       }
      public void remove_cashier(String username){
        ad.remove_cashier(username);
        }
      public void remove_item(String name){
      ad.remove_item(name);
      }  
      public void update(String oldname,String name,int price,int stock){
      ad.update(oldname, name, price, stock);
      }
      public ResultSet getset(){
          return ad.view();
      }
}

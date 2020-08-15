/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_model;

import com.mysql.jdbc.Connection;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pos_view.admin_dashboard;
import pos_view.cashier_dashboard;
import pos_view.main_dashboard;
import project.connection;

/**
 *
 * @author Ashir Ali
 */
public class user {
    admin_dashboard admind=new admin_dashboard();
    cashier_dashboard cashierd=new cashier_dashboard();
    main_dashboard maind=new main_dashboard();
    public user(){}
    public void dologin(String username,String password){
     try {
            
            String sql="Select username,password,rank,name from user where username='"+username+"' and password='"+password+"'";
            int count=0;
            Connection connect=connection.getconnect();
            Statement st=(Statement) connect.createStatement();
            ResultSet rs=(ResultSet) st.executeQuery(sql);
            String un=null;
            int rank=0;
            int s=0;
            while(rs.next()){
                ++count;
             un=rs.getString("name"); 
             rank=rs.getInt("rank");
             
            }
              
               
            if(count>0){
               System.out.print(rank);
               if(rank==1){
               admin_dashboard ad=new admin_dashboard(un);   
               maind.setVisible(false);
               ad.setVisible(true);
               }
               else if(rank==0){
               
               cashier_dashboard db=new cashier_dashboard(un);
               maind.setVisible(false);
               db.setVisible(true);
               }
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect Username or Password","Falied", WIDTH, null);
            }
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(main_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_view;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import pos_controller.admin_controller;
import project.connection;

/**
 *
 * @author Ashir Ali
 */
public class update_items extends javax.swing.JFrame {
 DefaultListModel modell;
      Connection connect=(Connection) connection.getconnect();
      int enter=0;
      int v=0;
      String pp;
         String ss;
    /**
     * Creates new form update_items
     */
    public update_items() {
        initComponents();
     jList2.setVisible(false);
        modell =new DefaultListModel();
        jList2.setModel(modell);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        sname = new javax.swing.JTextField();
        sprice = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        sstock = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jList2 = new javax.swing.JList<>();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Update an Item:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 180, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 640, 30));

        jLabel6.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Webp.net-resizeimage (4).png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 70, -1));

        jSeparator3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 160, 10));

        jLabel11.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Edit Details Here:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        jSeparator7.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator7.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, 10));

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update Items");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 150, 40));

        jTextField3.setBackground(new java.awt.Color(36, 47, 65));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setToolTipText("");
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 230, 30));

        jLabel12.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Selected Item Name:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jSeparator8.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator8.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 240, 10));

        sname.setBackground(new java.awt.Color(36, 47, 65));
        sname.setForeground(new java.awt.Color(255, 255, 255));
        sname.setToolTipText("");
        sname.setBorder(null);
        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });
        jPanel1.add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 230, 30));

        sprice.setBackground(new java.awt.Color(36, 47, 65));
        sprice.setForeground(new java.awt.Color(255, 255, 255));
        sprice.setToolTipText("");
        sprice.setBorder(null);
        sprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spriceActionPerformed(evt);
            }
        });
        jPanel1.add(sprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 230, 30));

        jLabel13.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Select Item Price:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        jSeparator9.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator9.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 240, 10));

        jSeparator10.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator10.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 240, 10));

        sstock.setBackground(new java.awt.Color(36, 47, 65));
        sstock.setForeground(new java.awt.Color(255, 255, 255));
        sstock.setToolTipText("");
        sstock.setBorder(null);
        sstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sstockActionPerformed(evt);
            }
        });
        jPanel1.add(sstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 230, 30));

        jLabel14.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Selected Item Stock:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));

        jList2.setBackground(new java.awt.Color(36, 47, 65));
        jList2.setForeground(new java.awt.Color(255, 255, 255));
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList2MousePressed(evt);
            }
        });
        jPanel1.add(jList2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 240, 140));

        jLabel15.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Enter Item Name:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void addlist(){
         try {
            
             Statement st=(Statement) connect.createStatement();
             String sql="select * from items where name LIKE '"+jTextField3.getText()+"%'";
             ResultSet rs=(ResultSet) st.executeQuery(sql);
             modell.removeAllElements();
             
            
             while(rs.next()){
             
             modell.addElement(rs.getString("name"));
             v++;
             }
             
             if(v>=1){
             
             jList2.setVisible(true);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(delete_cashier.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    }
    public void lists(){
       int ii=jList2.getSelectedIndex();
       if(ii>=0){
           try {
               Statement st=(Statement) connect.createStatement();
               String sql="select * from items where name LIKE '"+" "+jTextField3.getText()+"'";
               ResultSet rs=(ResultSet) st.executeQuery(sql);
               
               below();
               
           } catch (SQLException ex) {
               Logger.getLogger(delete_cashier.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    public void below(){
     try {
         sname.setText(jList2.getSelectedValue());
         String sql="SELECT price,stock from items where name='"+sname.getText()+"'";
         int count=0;
         Statement st=(Statement) connect.createStatement();
         ResultSet rs=(ResultSet) st.executeQuery(sql);
         String un=null;
         
         while(rs.next()){
             ++count;
             pp=rs.getString("price"); 
             ss=rs.getString("stock");
             }
         sprice.setText(pp);
         sstock.setText(ss);
         
     } catch (SQLException ex) {
         Logger.getLogger(delete_item.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String update_name=sname.getText();
        String old_name=jList2.getSelectedValue();
        int price=Integer.parseInt(sprice.getText());
        int stock=Integer.parseInt(sstock.getText());
        admin_controller control=new admin_controller();
        control.update(old_name,update_name,price,stock);
        sname.setText(null);
        sprice.setText(null);
        sstock.setText(null);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        jList2.setVisible(true);
        enter=1;
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        if(enter==0){
            addlist();
        }
        else{
            enter=0;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyReleased

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void spriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spriceActionPerformed

    private void sstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sstockActionPerformed

    private void jList2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MousePressed
        lists();
        jList2.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jList2MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(update_items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update_items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update_items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update_items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new update_items().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField sprice;
    private javax.swing.JTextField sstock;
    // End of variables declaration//GEN-END:variables
}

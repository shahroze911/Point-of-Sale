/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_view;

import com.mysql.jdbc.Connection;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pos_controller.receipt_controller;
import pos_controller.sales_controller;
import pos_model.receipt;
import pos_model.sales;
import project.connection;

/**
 *
 * @author Ashir Ali
 */
public class cashier_dashboard extends javax.swing.JFrame {

    /**
     * Creates new form cashier_dashboard
     */
   DefaultListModel modell;
      Connection connect=(Connection) connection.getconnect();
     sales_controller wt=new sales_controller(); 
      int enter=0;
      int v=0;
      String pp;
         String ss;
         int total=0;
         int tt=0;
         int row=3;
         int col=0;
         int taxs=0;
         int discount=0;
         String usn;
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime now = LocalDateTime.now();
        
         DateTimeFormatter justdate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDateTime nowdate = LocalDateTime.now();
         
       
    /**
     * Creates new form delete_item
     */
    public cashier_dashboard() {
        initComponents();
        jList2.setVisible(false);
        modell =new DefaultListModel();
        jList2.setModel(modell);
      
	date.setText(dtf.format(now));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
    }
  public cashier_dashboard(String s) {
        initComponents();
        jList2.setVisible(false);
        modell =new DefaultListModel();
        jList2.setModel(modell);
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime now = LocalDateTime.now();
	date.setText(dtf.format(now));
        username.setText(s);
        usn=s;
        main_dashboard maind=new main_dashboard();
        maind.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
    }
  
  
  
  public PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double middleHeight =8.0;  
    double headerHeight = 2.0;                  
    double footerHeight = 2.0;                  
    double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
    double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        10,
        width,            
        height - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points
            
    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}
    
    protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;            
}
 public static String fixedLengthString(String string, int length) {
    return String.format("%1$"+length+ "s", string);
}





public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
                
        
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            ////////// code by alqama//////////////

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

        //    int idPosition=0;
        //    int productPosition=idPosition + idLength + 2;
        //    int pricePosition=productPosition + prodLength +10;
        //    int qtyPosition=pricePosition + priceLength + 2;
        //    int amtPosition=qtyPosition + qtyLength + 2;
            
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
            
              
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
            int headerRectHeighta=40;
            
            ///////////////// Product names Get ///////////
             //   String  pn1a=pn1.getText();
               // String pn2a=pn2.getText();
               // String pn3a=pn3.getText();
                //String pn4a=pn4.getText();
            ///////////////// Product names Get ///////////
                
            
            ///////////////// Product price Get ///////////
             //   int pp1a=Integer.valueOf(pp1.getText());
               // int pp2a=Integer.valueOf(pp2.getText());
               // int pp3a=Integer.valueOf(pp3.getText());
               // int pp4a=Integer.valueOf(pp4.getText());
               // int sum=pp1a+pp2a+pp3a+pp4a;
            ///////////////// Product price Get ///////////
                
             g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("-------------------------------------",12,y);y+=yShift;
            g2d.drawString("          POS Bill Receipt           ",12,y);y+=yShift;
            g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;
      
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Item Name    Qnuatity     T.Price   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
           
            for(int i=0;i<row;i++){
            String name=fixedLengthString(jTable1.getValueAt(i,0).toString(),10);
                g2d.drawString(""+name+"       "+jTable1.getValueAt(i,2).toString()+"         "+jTable1.getValueAt(i,1).toString()+"  ",10,y);y+=yShift;
            
            }//g2d.drawString(" "+pn2a+"                  "+pp2a+"  ",10,y);y+=yShift;
           // g2d.drawString(" "+pn3a+"                  "+pp3a+"  ",10,y);y+=yShift;
            //g2d.drawString(" "+pn4a+"                  "+pp4a+"  ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total Tax:      "+taxs+"               ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total Discount: "+discount+"               ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total amount:   "+total+"               ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("          Free Home Delivery         ",10,y);y+=yShift;
            g2d.drawString("             03111111111             ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("Generated On:     "+dtf.format(now)+"",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("Generated By:     "+usn+"  ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("    THANKS TO VISIT OUR STORE        ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
                   
           
             
           
            
//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
          

    }
    catch(Exception r){
    r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
  
  
  
  
  
  
  
  
  
  
  
  
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        date = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        username = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jList2 = new javax.swing.JList<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        sname = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        sprice = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        sstock = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sstock1 = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        bill = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tax = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        date2 = new javax.swing.JLabel();
        bill2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        payed = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setLayout(new org.eclipse.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(36, 47, 65));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Price", "Quantity"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.eclipse.lib.awtextra.AbsoluteConstraints(30, 250, 1080, 220));

        date.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(date, new org.eclipse.lib.awtextra.AbsoluteConstraints(880, 30, 260, 30));
        jPanel1.add(jSeparator1, new org.eclipse.lib.awtextra.AbsoluteConstraints(280, 140, 230, 30));

        username.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(username, new org.eclipse.lib.awtextra.AbsoluteConstraints(120, 30, 180, 30));

        jLabel11.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Scan BarCode:");
        jPanel1.add(jLabel11, new org.eclipse.lib.awtextra.AbsoluteConstraints(320, 90, 180, 30));

        jLabel12.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Welcome:");
        jPanel1.add(jLabel12, new org.eclipse.lib.awtextra.AbsoluteConstraints(10, 30, 180, 30));

        jLabel13.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images/Webp.net-resizeimage (11).png"))); // NOI18N
        jPanel1.add(jLabel13, new org.eclipse.lib.awtextra.AbsoluteConstraints(280, 100, 180, 30));
        jPanel1.add(jSeparator2, new org.eclipse.lib.awtextra.AbsoluteConstraints(10, 70, 1130, 30));
        jPanel1.add(jSeparator3, new org.eclipse.lib.awtextra.AbsoluteConstraints(10, 140, 230, 30));

        jList2.setBackground(new java.awt.Color(36, 47, 65));
        jList2.setForeground(new java.awt.Color(255, 255, 255));
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList2MousePressed(evt);
            }
        });
        jPanel1.add(jList2, new org.eclipse.lib.awtextra.AbsoluteConstraints(10, 140, 240, 140));

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
        jPanel1.add(jTextField3, new org.eclipse.lib.awtextra.AbsoluteConstraints(50, 110, 230, 30));

        jTextField4.setBackground(new java.awt.Color(36, 47, 65));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setToolTipText("");
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField4, new org.eclipse.lib.awtextra.AbsoluteConstraints(160, 140, 230, 30));

        sname.setEditable(false);
        sname.setBackground(new java.awt.Color(36, 47, 65));
        sname.setForeground(new java.awt.Color(255, 255, 255));
        sname.setToolTipText("");
        sname.setBorder(null);
        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });
        jPanel1.add(sname, new org.eclipse.lib.awtextra.AbsoluteConstraints(610, 110, 230, 30));

        jSeparator8.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator8.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator8, new org.eclipse.lib.awtextra.AbsoluteConstraints(610, 140, 240, 10));

        sprice.setEditable(false);
        sprice.setBackground(new java.awt.Color(36, 47, 65));
        sprice.setForeground(new java.awt.Color(255, 255, 255));
        sprice.setToolTipText("");
        sprice.setBorder(null);
        sprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spriceActionPerformed(evt);
            }
        });
        jPanel1.add(sprice, new org.eclipse.lib.awtextra.AbsoluteConstraints(900, 110, 230, 30));

        jLabel14.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Select Item Price:");
        jPanel1.add(jLabel14, new org.eclipse.lib.awtextra.AbsoluteConstraints(900, 90, -1, -1));

        jSeparator9.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator9.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator9, new org.eclipse.lib.awtextra.AbsoluteConstraints(900, 140, 240, 10));

        jSeparator10.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator10.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator10, new org.eclipse.lib.awtextra.AbsoluteConstraints(900, 210, 240, -1));

        sstock.setEditable(false);
        sstock.setBackground(new java.awt.Color(36, 47, 65));
        sstock.setForeground(new java.awt.Color(255, 255, 255));
        sstock.setToolTipText("");
        sstock.setBorder(null);
        sstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sstockActionPerformed(evt);
            }
        });
        jPanel1.add(sstock, new org.eclipse.lib.awtextra.AbsoluteConstraints(900, 180, 230, 30));

        jLabel15.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Selected Item Stock:");
        jPanel1.add(jLabel15, new org.eclipse.lib.awtextra.AbsoluteConstraints(900, 160, -1, -1));

        jLabel16.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Selected Item Name:");
        jPanel1.add(jLabel16, new org.eclipse.lib.awtextra.AbsoluteConstraints(610, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Select Quantity:");
        jPanel1.add(jLabel17, new org.eclipse.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        sstock1.setBackground(new java.awt.Color(36, 47, 65));
        sstock1.setForeground(new java.awt.Color(255, 255, 255));
        sstock1.setToolTipText("");
        sstock1.setBorder(null);
        sstock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sstock1ActionPerformed(evt);
            }
        });
        jPanel1.add(sstock1, new org.eclipse.lib.awtextra.AbsoluteConstraints(610, 180, 230, 30));

        jSeparator11.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jSeparator11.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel1.add(jSeparator11, new org.eclipse.lib.awtextra.AbsoluteConstraints(610, 210, 240, -1));

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.eclipse.lib.awtextra.AbsoluteConstraints(280, 180, 150, 40));

        bill.setEditable(false);
        bill.setBackground(new java.awt.Color(36, 47, 65));
        bill.setForeground(new java.awt.Color(255, 255, 255));
        bill.setToolTipText("");
        bill.setBorder(null);
        bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billActionPerformed(evt);
            }
        });
        bill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billKeyReleased(evt);
            }
        });
        jPanel1.add(bill, new org.eclipse.lib.awtextra.AbsoluteConstraints(740, 560, 210, 30));

        jLabel18.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Total Bill");
        jPanel1.add(jLabel18, new org.eclipse.lib.awtextra.AbsoluteConstraints(740, 540, 180, 30));
        jPanel1.add(jSeparator4, new org.eclipse.lib.awtextra.AbsoluteConstraints(700, 590, 230, 30));

        jLabel19.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Choose an Item:");
        jPanel1.add(jLabel19, new org.eclipse.lib.awtextra.AbsoluteConstraints(50, 90, 180, 30));

        jLabel20.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images/Webp.net-resizeimage (12).png"))); // NOI18N
        jPanel1.add(jLabel20, new org.eclipse.lib.awtextra.AbsoluteConstraints(700, 550, 180, 30));

        jLabel21.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images\\Webp.net-resizeimage (11).png")); // NOI18N
        jPanel1.add(jLabel21, new org.eclipse.lib.awtextra.AbsoluteConstraints(280, 100, 180, 30));

        jLabel22.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images\\Webp.net-resizeimage (11).png")); // NOI18N
        jPanel1.add(jLabel22, new org.eclipse.lib.awtextra.AbsoluteConstraints(280, 100, 180, 30));

        jLabel23.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images\\Webp.net-resizeimage (11).png")); // NOI18N
        jPanel1.add(jLabel23, new org.eclipse.lib.awtextra.AbsoluteConstraints(280, 100, 180, 30));

        jLabel24.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images\\Webp.net-resizeimage (11).png")); // NOI18N
        jPanel1.add(jLabel24, new org.eclipse.lib.awtextra.AbsoluteConstraints(280, 100, 180, 30));

        jLabel25.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images/Webp.net-resizeimage (10).png"))); // NOI18N
        jPanel1.add(jLabel25, new org.eclipse.lib.awtextra.AbsoluteConstraints(10, 100, 180, 30));

        jLabel26.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Date:");
        jPanel1.add(jLabel26, new org.eclipse.lib.awtextra.AbsoluteConstraints(800, 30, 180, 30));

        date1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        date1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(date1, new org.eclipse.lib.awtextra.AbsoluteConstraints(550, 30, 260, 30));

        jLabel27.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Add Tax Amount(%)");
        jPanel1.add(jLabel27, new org.eclipse.lib.awtextra.AbsoluteConstraints(410, 540, 180, 30));

        jLabel28.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images/Webp.net-resizeimage (13).png"))); // NOI18N
        jPanel1.add(jLabel28, new org.eclipse.lib.awtextra.AbsoluteConstraints(370, 550, 180, 30));

        tax.setBackground(new java.awt.Color(36, 47, 65));
        tax.setForeground(new java.awt.Color(255, 255, 255));
        tax.setToolTipText("");
        tax.setBorder(null);
        tax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                taxMouseExited(evt);
            }
        });
        tax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxActionPerformed(evt);
            }
        });
        tax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                taxKeyReleased(evt);
            }
        });
        jPanel1.add(tax, new org.eclipse.lib.awtextra.AbsoluteConstraints(410, 560, 230, 30));
        jPanel1.add(jSeparator5, new org.eclipse.lib.awtextra.AbsoluteConstraints(370, 590, 230, 30));

        jLabel29.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Discount (%)");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });
        jPanel1.add(jLabel29, new org.eclipse.lib.awtextra.AbsoluteConstraints(80, 540, 180, 30));

        jLabel30.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images/Webp.net-resizeimage (14).png"))); // NOI18N
        jPanel1.add(jLabel30, new org.eclipse.lib.awtextra.AbsoluteConstraints(40, 550, 180, 30));
        jPanel1.add(jSeparator6, new org.eclipse.lib.awtextra.AbsoluteConstraints(40, 590, 230, 30));

        date2.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        date2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(date2, new org.eclipse.lib.awtextra.AbsoluteConstraints(220, 30, 260, 30));

        bill2.setBackground(new java.awt.Color(36, 47, 65));
        bill2.setForeground(new java.awt.Color(255, 255, 255));
        bill2.setToolTipText("");
        bill2.setBorder(null);
        bill2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bill2MouseExited(evt);
            }
        });
        bill2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill2ActionPerformed(evt);
            }
        });
        bill2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bill2KeyReleased(evt);
            }
        });
        jPanel1.add(bill2, new org.eclipse.lib.awtextra.AbsoluteConstraints(80, 560, 230, 30));

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("End Sale");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.eclipse.lib.awtextra.AbsoluteConstraints(980, 640, 150, 40));

        jLabel31.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("U:\\.UNIVERSITY\\Semester 5\\OOAD Lab\\Final\\Updated\\project\\src\\Images/Webp.net-resizeimage (12).png"))); // NOI18N
        jPanel1.add(jLabel31, new org.eclipse.lib.awtextra.AbsoluteConstraints(700, 640, 180, 30));

        jLabel32.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Payment Amount");
        jPanel1.add(jLabel32, new org.eclipse.lib.awtextra.AbsoluteConstraints(740, 630, 180, 30));

        payed.setBackground(new java.awt.Color(36, 47, 65));
        payed.setForeground(new java.awt.Color(255, 255, 255));
        payed.setToolTipText("");
        payed.setBorder(null);
        payed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payedActionPerformed(evt);
            }
        });
        payed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                payedKeyReleased(evt);
            }
        });
        jPanel1.add(payed, new org.eclipse.lib.awtextra.AbsoluteConstraints(740, 650, 210, 30));
        jPanel1.add(jSeparator7, new org.eclipse.lib.awtextra.AbsoluteConstraints(700, 680, 230, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MousePressed
        lists();
        jList2.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jList2MousePressed

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

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        jList2.setVisible(true);
        enter=1;
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        if(enter==0){
            addlist();
        }
        else{
            enter=0;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void spriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spriceActionPerformed

    private void sstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sstockActionPerformed

    private void sstock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sstock1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sstock1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
      
         // insert row to the model from jtextfields using addRow method
        if(sname.getText().equals("") || sprice.getText().equals("")){
       JOptionPane.showMessageDialog(null,"Choose an Item First" );
       }
       else if(sstock1.getText().equals("")){
       JOptionPane.showMessageDialog(null,"You have To Enter Quantity" );
       } 
       else{
       model.addRow(new Object[]{sname.getText(), sprice.getText(),
                                  sstock1.getText()});
        int price = Integer.parseInt(sprice.getText());
        int quantity = Integer.parseInt(sstock1.getText());
        int totals=(total+(price*quantity));
        total=totals;
        tt=total;
        String bt=Integer.toString(totals);
        sstock1.setText(null);
        sname.setText(null);
        sprice.setText(null);
        sstock.setText(null);
        bill.setText(bt);
        row=jTable1.getRowCount();
        
        
       }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billActionPerformed

    private void billKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_billKeyReleased

    private void taxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxActionPerformed
       int taxvalue = Integer.parseInt(tax.getText());
        int add = (tt*taxvalue)/100;
        taxs=add;
        System.out.print(add);
        int totals=tt+add;
        tt=totals;
        String bt=Integer.toString(totals);
        System.out.print(totals);
        bill.setText(bt);
        total=totals;// TODO add your handling code here:
    }//GEN-LAST:event_taxActionPerformed

    private void taxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxKeyReleased
       
    }//GEN-LAST:event_taxKeyReleased

    private void bill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill2ActionPerformed
int taxvalue = Integer.parseInt(bill2.getText());
        int add = (tt*taxvalue)/100;
        System.out.print(add);
        int totals=tt-add;
        discount=add;
        tt=totals;
        String bt=Integer.toString(totals);
        System.out.print(totals);
        bill.setText(bt); 
        total=totals;// TODO add your handling code here:
    }//GEN-LAST:event_bill2ActionPerformed

    private void bill2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bill2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_bill2KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         if(payed.getText().equals("")){
       JOptionPane.showMessageDialog(null,"Please Enter The Amount Payed First" );
       }else{
        sales_controller s=new sales_controller();
        String dd= justdate.format(nowdate).toString();
        System.out.print(dd);
        int ro=jTable1.getRowCount();
        s.add_sale(dd,ro,total);
        receipt_controller r=new receipt_controller();
        r.add_rece(dd,ro,total);
        PrinterJob pj = PrinterJob.getPrinterJob();        
        pj.setPrintable(new cashier_dashboard.BillPrintable(),getPageFormat(pj));
        
        try {
             
       
       pj.print();
       int pp=Integer.parseInt(payed.getText());;
       pay_amount p=new pay_amount(total,pp);
       p.setVisible(true);
       this.setVisible(false);
        }
         catch (PrinterException ex) {
                 ex.printStackTrace();
        }       
         }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void taxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_taxMouseExited

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseExited

    private void bill2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill2MouseExited
         // TODO add your handling code here:
    }//GEN-LAST:event_bill2MouseExited

    private void payedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payedActionPerformed

    private void payedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payedKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_payedKeyReleased
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
            java.util.logging.Logger.getLogger(cashier_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashier_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashier_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashier_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashier_dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bill;
    private javax.swing.JTextField bill2;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField payed;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField sprice;
    private javax.swing.JTextField sstock;
    private javax.swing.JTextField sstock1;
    private javax.swing.JTextField tax;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}

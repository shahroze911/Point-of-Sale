package pos_controller;

import pos_model.sales;

/**
 *
 * @author Ashir Ali
 */
public class sales_controller {
public sales sal=new sales();
public sales_controller(){
}
public void add_sale(String date,int quantity,int price){
  sal.add(date, quantity, price);
}


    
}

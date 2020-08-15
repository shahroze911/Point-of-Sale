/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_controller;

import pos_model.receipt;

/**
 *
 * @author Ashir Ali
 */
public class receipt_controller {
    public receipt ob=new receipt();
    public receipt_controller(){}
    public void add_rece(String date,int quantity,int price){
    ob.addd(date,price,quantity);
    }
    
    
}

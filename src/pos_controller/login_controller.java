/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_controller;

import pos_model.user;

/**
 *
 * @author Ashir Ali
 */
public class login_controller {
    user u=new user();
    public login_controller (){}
    public void user_login(String username,String password){
    u.dologin(username, password);
    }
}

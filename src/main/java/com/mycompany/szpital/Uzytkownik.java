/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

/**
 *
 * @author Bartek
 */
abstract class Uzytkownik {
    
    String fullName, password, login;
    int phoneNumber;
    
    public void setFullName(String fullName){
        
        this.fullName = fullName;
        
    }
    
    public void setPassword(String password){
    
        this.password = password;
        
    }
    
    public void setLogin(String login){
    
        this.login = login;
        
    }
    
    public void setPhoneNumber(int phoneNumber){
    
        this.phoneNumber = phoneNumber;
        
    }
    
    public String getFullName()
   {
    
        return fullName;
        
    }
    
    public String getPassword(){
    
        return password;
        
    }
    
    public String getLogin(){
 
        return login;
        
    }
    
    public int getPhoneNumber(){
        
        return phoneNumber;
        
    }
    
    public boolean validateUser(String login, String password){
    
        if(this.login.equals(login) && this.password.equals(password))
        {
            return true;
        }
        
        return false;
    }
}

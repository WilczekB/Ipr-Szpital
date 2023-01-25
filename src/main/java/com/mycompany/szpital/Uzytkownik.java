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
    
    protected String name, surname, password, login, sort;
    protected int phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
    
    public void setSort(String sort){
        this.sort = sort;
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
    
    public String getSort(){
        return this.sort;
    }
    
    public boolean validateUser(String login, String password){
    
        if(this.login.equals(login) && this.password.equals(password))
        {
            return true;
        }
        
        return false;
    }
}

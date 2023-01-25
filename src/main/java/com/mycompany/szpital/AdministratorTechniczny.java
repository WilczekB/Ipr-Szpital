/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

/**
 *
 * @author Bartek
 */
public class AdministratorTechniczny extends Uzytkownik {

    public AdministratorTechniczny(String name, String surname, int phoneNumber, String login, String password, String sort) {
        
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sort = sort;
    }
    
    public void addEquipment(){
        
    }
    
    public void deleteEquipment(){
        
    }
    
    public void manageEquipment(){
    
    }
    
    public void manageRequest(){
    
    }
    
}

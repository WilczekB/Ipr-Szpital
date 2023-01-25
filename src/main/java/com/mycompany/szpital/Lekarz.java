/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

/**
 *
 * @author Bartek
 */
public class Lekarz extends ZarzadzajacySalami {

    public Lekarz(String name, String surname, int phoneNumber, String login, String password, String sort) {
        
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sort = sort;
    }
    
    public void sendRequestForReservation(){
    }
    
    public void sendRequestForDeletingReservation(){
    }
    
    public void sendRequestForEditingReservation(){
    }
    
}

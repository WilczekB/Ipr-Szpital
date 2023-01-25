/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

/**
 *
 * @author Bartek
 */
public class Powiadomienie {
    
    private int id;
    private String status;
    private Rezerwacja reservation;
    
    public Powiadomienie(int id, String status, Rezerwacja reservation){
    
        this.id = id;
        this.status = status;
        this.reservation = reservation;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Rezerwacja getReservation() {
        return reservation;
    }

    public void setReservation(Rezerwacja reservation) {
        this.reservation = reservation;
    }
    
    
}

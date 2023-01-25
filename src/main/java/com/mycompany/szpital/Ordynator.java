/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author Bartek
 */
public class Ordynator extends ZarzadzajacySalami {
    
    private LinkedHashMap<Integer, Rezerwacja> reservations;

    public Ordynator(String name, String surname, int phoneNumber, String login, String password) {
        
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        
    }
    
    public void addReservation(int id, Sala room, String name, String surname, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime){
        
        Rezerwacja reservation = new Rezerwacja(id, name, surname, startDate, endDate, startTime, endTime, room);
        Integer key = reservations.size();
        reservations.put(key, reservation);
    }
    
    public void editReservation(){
    }
    
    public void deleteReservation(){
    }
    
    public void changeRoomPurpose(){
    }
    
    public void acceptReservationRequest(){
    }
    
    public void rejectReservationRequest(){
    }
    
    public void acceptRoomEditionRequest(){
    }
    
    
}

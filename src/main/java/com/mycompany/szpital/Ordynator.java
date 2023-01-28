/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
/**
 *
 * @author Bartek
 */
public class Ordynator extends ZarzadzajacySalami {
    
    private LinkedHashMap<Integer, Rezerwacja> reservations;
    private LinkedHashMap<Integer, Powiadomienie> alerts;

    public Ordynator(String name, String surname, int phoneNumber, String login, String password, String sort) {
        
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sort = sort;
    }
    
    public void addReservation(int id, int number, String name, String surname, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime){
        
        Rezerwacja reservation = new Rezerwacja(id, name, surname, startDate, endDate, startTime, endTime, number);
        Integer key = reservations.size();
        reservations.put(key, reservation);
        
    }
    
    public void editReservation(){
    }
    
    public void deleteReservation(Rezerwacja reservation){
        
        for(Map.Entry<Integer, Rezerwacja> entry: reservations.entrySet()){
            
            if(reservation.getId() == entry.getValue().getId())
            {
                reservations.remove(entry);
            }
            
        }
        
    }
    
    public void changeRoomPurpose(String type, Sala room){
        
        room.setType(type);
        
    }
    
    public void acceptReservationRequest(Powiadomienie alert){
        
        for(Map.Entry<Integer, Powiadomienie> entry: alerts.entrySet()){
        
            if(alert.getId() == entry.getValue().getId())
            {
                entry.getValue().setStatus("Zaakceptowano");
            }
            
        }
        
    }
    
    public void rejectReservationRequest(){
    }
    
    public void acceptRoomEditionRequest(){
    }
    
    
}

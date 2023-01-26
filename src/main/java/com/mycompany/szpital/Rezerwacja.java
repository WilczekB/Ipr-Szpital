/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
/**
 *
 * @author Bartek
 */
public class Rezerwacja {
    
    private int id;
    private String name, surname;
    private LocalDate beginningDate, endingDate;
    private LocalTime beginningHour, endingHour;
    private Sala room;
    private LinkedHashMap<Integer, Sprzet> equipment;
    private Uzytkownik user;

    public Rezerwacja(int id,String name,String surname,LocalDate beginningDate, LocalDate endingDate, LocalTime beginningHour, LocalTime endingHour, Sala room) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.room = room;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public LocalTime getBeginningHour() {
        return beginningHour;
    }

    public void setBeginningHour(LocalTime beginningHour) {
        this.beginningHour = beginningHour;
    }

    public LocalTime getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(LocalTime endingHour) {
        this.endingHour = endingHour;
    }
    
    public Sala getRoom(){
    
        return room;
    
    }

    public Uzytkownik getUser() {
        return user;
    }

    public void setUser(Uzytkownik user) {
        this.user = user;
    }
    
    
    
    public void addDeviceToEquipment(Sprzet device){
    
        Integer key = equipment.size()+1;
        equipment.put(key, device);
        
    }
    
    
    
}

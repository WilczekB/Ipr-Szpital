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
    private LocalDate beginningDate, endingDate;
    private LocalTime beginningHour, endingHour;
    private LinkedHashMap<Integer, Sala> rooms;
    private LinkedHashMap<Integer, Sprzet> equipment;

    public Rezerwacja(int id, LocalDate beginningDate, LocalDate endingDate, LocalTime beginningHour, LocalTime endingHour, LinkedHashMap<Integer, Sala> rooms, LinkedHashMap<Integer, Sprzet> equipment) {
        this.id = id;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.rooms = rooms;
        this.equipment = equipment;
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
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import javax.swing.table.*;
import java.util.*;
/**
 *
 * @author Bartek
 */
public class RezerwacjaTableModel extends AbstractTableModel{
    
    private LinkedHashMap<Integer, Rezerwacja> reservations;
    private String[] columns;
    
    public RezerwacjaTableModel(LinkedHashMap<Integer, Rezerwacja> reservations){
        super();
        columns = new String[]{"ID rezerwacji", "Numer sali", "Typ sali", "Imię", "Nazwisko", "Data", "Godzina"};
        this.reservations = reservations;
    }
    
    @Override
    public int getRowCount(){
    
        return reservations.size();
        
    }
    
    @Override
    public int getColumnCount(){
    
        return columns.length;
        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
    
        Rezerwacja reservation = reservations.get(rowIndex);
        
        switch(columnIndex){
            case 0: return reservation.getId();
            case 1: return reservation.getRoom().getNumber();
            case 2: return reservation.getRoom().getType();
            case 3: return reservation.getName();
            case 4: return reservation.getSurname();
            case 5: return reservation.getEndingDate();
            case 6: return reservation.getEndingHour();
            default: return null;
        }
    
    }
    
    @Override
    public String getColumnName(int col){
    
        return columns[col];
    
    }
    
}

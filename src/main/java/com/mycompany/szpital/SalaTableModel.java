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
public class SalaTableModel extends AbstractTableModel{
    
    private LinkedHashMap<Integer, Sala> rooms;
    private String[] columns;
    
    public SalaTableModel(LinkedHashMap<Integer, Sala> r)
    {
        super();
        columns = new String[]{"Numer Sali", "Typ Sali"};
        this.rooms = r; 
    }
    
    @Override
    public int getRowCount(){
        return rooms.size();
    }
    
    @Override
    public int getColumnCount(){
        return columns.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){

        Integer key = rooms.keySet().toArray(new Integer[rooms.size()])[rowIndex];
        Sala room = rooms.get(key);

        try {
            if (room != null) {
                switch (columnIndex) {
                    case 0:
                        return room.getNumber();
                    case 1:
                        return room.getType();
                    default:
                        throw new IllegalArgumentException("Nieznana kolumna: " + columnIndex);
                }
            } else {
                throw new NullPointerException("Sprzęt jest nullem dla wiersza " + rowIndex + " i kolumny " + columnIndex);
            }
        } catch (Exception ex) {
            System.out.println("Wystąpił wyjątek:");
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String getColumnName(int col){
        return columns[col];
    }
    
    
    public void update(){
        
        fireTableDataChanged(); 
        
    }
}

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
public class SprzetTableModel extends AbstractTableModel{
    
    private LinkedHashMap<Integer, Sprzet> equipment;
    private String[] columns;
    
    public SprzetTableModel(LinkedHashMap<Integer, Sprzet> equipment)
    {
        super();
        columns = new String[]{"Numer ID", "Kategoria", "Nazwa", "Czy zdezynfekowano", "Przydział"};
        this.equipment = equipment; 
    }
    
    @Override
    public int getRowCount(){
        return equipment.size();
    }
    
    @Override
    public int getColumnCount(){
        return columns.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){

        Integer key = equipment.keySet().toArray(new Integer[equipment.size()])[rowIndex];
        Sprzet equip = equipment.get(key);

        try {
            if (equip != null) {
                switch (columnIndex) {
                    case 0:
                        return equip.getId();
                    case 1:
                        return equip.getCategory();
                    case 2:
                        return equip.getName();
                    case 3:
                        return equip.isItDisinfected();
                    case 4:
                        return equip.getAlocation();
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

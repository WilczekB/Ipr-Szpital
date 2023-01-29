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
        
        Sprzet equip = equipment.get(rowIndex);
        switch(columnIndex){
        
            case 0: return equip.getId();
            case 1: return equip.getCategory();
            case 2: return equip.getName();
            case 3: return equip.isItDisinfected();
            case 4: return equip.getAlocation();
            default: return null;
        
        }
    }
    
    @Override
    public String getColumnName(int col){
        return columns[col];
    }
    
    public void update(){
        
        this.equipment = equipment; 
        System.out.println(this.equipment.size());
    }
}

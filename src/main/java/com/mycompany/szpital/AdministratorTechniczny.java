/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import java.util.*;
/**
 *
 * @author Bartek
 */
public class AdministratorTechniczny extends Uzytkownik {

    private LinkedHashMap<Integer, Sprzet> equipment;
    
    public AdministratorTechniczny(String name, String surname, int phoneNumber, String login, String password, String sort) {
        
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sort = sort;
    }
    
    public void addEquipment(String name, int id, String category, String alocation, boolean isDisinfected){
        
        Sprzet equip = new Sprzet(name, category, alocation, id, isDisinfected);
        int key = equipment.size()+1;
        equipment.put(key,equip);
        
    }
    
    public void deleteEquipment(Sprzet equip){
        
        
        for(Map.Entry<Integer, Sprzet> entry: equipment.entrySet()){
            
            if(equip.getId() == entry.getValue().getId())
            {
                equipment.remove(entry);
            }
            
        }
        
        
    }
    
    public void manageEquipment(Sprzet equip, int id, String category, String name, boolean isDisinfected, String alocation){
    
        if(id!=equip.getId())
        {
            equip.setId(id);
        }
        
        if(category!=equip.getCategory())
        {
            equip.setCategory(category);
        }
        
        if(name!=equip.getName())
        {
            equip.setName(name);
        }
        
        if(isDisinfected!=equip.isItDisinfected())
        {
            equip.setIsDisinfected(isDisinfected);
        }
        
        if(alocation!=equip.getAlocation())
        {
            equip.setAlocation(alocation);
        }
        
    }
    
    public void manageRequest(){
    
    }
    
}

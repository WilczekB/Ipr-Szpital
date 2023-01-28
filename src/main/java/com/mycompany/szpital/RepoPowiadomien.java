/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Bartek
 */
public class RepoPowiadomien {
    
    private LinkedHashMap<Integer, Powiadomienie> alerts;
    
    public RepoPowiadomien(LinkedHashMap<Integer, Powiadomienie> alerts){
        
        this.alerts = alerts;
        
    }
    
    public void addAlert(Powiadomienie alert){
        
        Integer key = alerts.size() + 1;
        alerts.put(key, alert);
        
    }
    
    public void deleteAlert(Powiadomienie alert){
    
        for(Map.Entry<Integer, Powiadomienie> entry: alerts.entrySet()){
        
            if(entry.getValue().getId() == alert.getId())
            {
                alerts.remove(entry.getKey());
            }
        
        }
        
    }
    
}

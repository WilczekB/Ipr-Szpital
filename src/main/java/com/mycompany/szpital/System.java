/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import java.util.*;
import java.io.*;
/**
 *
 * @author Bartek
 */
public class System {
    
    private LinkedHashMap<Integer, Lekarz> doctors;
    private LinkedHashMap<Integer, Ordynator> headPhysicians;
    private LinkedHashMap<Integer, AdministratorTechniczny> admins;
    
    private static Lekarz createLekarz(String[] data){
        
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        
        return new Lekarz(name, surName, phoneNumber, login, password);
        
    }
    
    private static Ordynator createOrdynator(String[] data){
    
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        
        return new Ordynator(name, surName, phoneNumber, login, password);
    }
    
    private static AdministratorTechniczny createAdministrator(String[] data){
        
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        
        return new AdministratorTechniczny(name, surName, phoneNumber, login, password);
    }
    
    public void readUsersFromFile(String path){
        
        String[] values;
        String line="";
        int key=0;
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line = br.readLine()) != null){
                
                values = line.split("   ");
                
                switch(values[5]){
                    case "lekarz":
                        
                        Lekarz doctor = createLekarz(values);
                        doctors.put(key, doctor);
                        key++;
                        
                        break;
                    case "ordynator":
                        
                        Ordynator headPhysician = createOrdynator(values);
                        headPhysicians.put(key, headPhysician);
                        key++;
                        
                        break;
                    case "administrator":
                        
                        AdministratorTechniczny admin = createAdministrator(values);
                        admins.put(key, admin);
                        key++;
                        
                        break;
                }
                
                br.close();
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
    
}

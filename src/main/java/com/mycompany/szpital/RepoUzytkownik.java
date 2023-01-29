/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 *
 * @author Bartek
 */
public class RepoUzytkownik {
    
    private LinkedHashMap<Integer, Lekarz> doctors;
    private LinkedHashMap<Integer, AdministratorTechniczny> admins;
    private LinkedHashMap<Integer, Ordynator> headPhysicians;
    
    public RepoUzytkownik()
    {
       this.doctors = new LinkedHashMap<Integer, Lekarz>();
       this.admins = new LinkedHashMap<Integer, AdministratorTechniczny>();
       this.headPhysicians = new LinkedHashMap<Integer, Ordynator>();
       this.readFromDataBase("C:/Users/Lenovo/Documents/7sem/IPR/Ipr-Szpital/src/main/java/com/mycompany/szpital/Data/Uzytkownicy.txt");
    }
    
    private static Lekarz createDoctor(String[] data){
        
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        String sort = data[5];
        
        return new Lekarz(name, surName, phoneNumber, login, password, sort);
        
    }
    
    private static Ordynator createHeadphysician(String[] data){
        
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        String sort = data[5];
        
        return new Ordynator(name, surName, phoneNumber, login, password, sort);
        
    }
    
    private static AdministratorTechniczny createAdmin(String[] data){
    
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        String sort = data[5];
        
        return new AdministratorTechniczny(name, surName, phoneNumber, login, password, sort);
        
    }
    
    public void readFromDataBase(String path){
    
        String[] values;
        String line="";
        int key=0;
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line = br.readLine()) != null){
                
                values = line.split("    ");
                
                System.out.print(values[1] + " ");
                
                switch(values[5]){
                    case "lekarz":
                        
                        Lekarz doctor = createDoctor(values);
                        doctors.put(key, doctor);
                        key++;
                        
                        break;
                    case "ordynator":
                        
                        Ordynator headPhysician = createHeadphysician(values);
                        headPhysicians.put(key, headPhysician);
                        key++;
                        
                        break;
                    case "administrator":
                        
                        AdministratorTechniczny admin = createAdmin(values);
                        admins.put(key, admin);
                        key++;
                        
                        break;
                }
                
                
            }
            br.close(); 
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        
        
    }
    
    public void writeToDataBase(String path){
        
        BufferedWriter writer = null;
        
        try{
            
            FileWriter stream = new FileWriter(path);
            writer = new BufferedWriter(stream);
            
            for(Map.Entry<Integer, AdministratorTechniczny> entry: admins.entrySet()){
                
                writer.write(entry.getKey() + "    " + entry.getValue().getName() + "    " + 
                        entry.getValue().getPhoneNumber() + "    " + entry.getValue().getSurname() + "    " + entry.getValue().getLogin() + 
                        "    " + entry.getValue().getPassword() + "    " + entry.getValue().getSort());
                
                writer.newLine();
            }
            
            for(Map.Entry<Integer, Lekarz> entry: doctors.entrySet()){
                
                writer.write(entry.getKey() + "    " + entry.getValue().getName() + "    " + 
                        entry.getValue().getPhoneNumber() + "    " + entry.getValue().getSurname() + "    " + entry.getValue().getLogin() + 
                        "    " + entry.getValue().getPassword() + "    " + entry.getValue().getSort());
                
                writer.newLine();
                
            }
            
            for(Map.Entry<Integer, Ordynator> entry: headPhysicians.entrySet()){
                
                writer.write(entry.getKey() + "    " + entry.getValue().getName() + "    " + 
                        entry.getValue().getPhoneNumber() + "    " + entry.getValue().getSurname() + "    " + entry.getValue().getLogin() + 
                        "    " + entry.getValue().getPassword() + "    " + entry.getValue().getSort());
                
                writer.newLine();
                
            }
            
            writer.flush();
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        finally{
            try{
                writer.close();
            } catch (Exception e) {
                
            }
        }
        
    }
    
    public Uzytkownik getLogin(String login, String password){
        
        for(Map.Entry<Integer, Lekarz> entry: doctors.entrySet()){
            
            if((entry.getValue().getLogin().equals(login)) && (entry.getValue().getPassword().equals(password)))
            {
                return doctors.get(entry.getKey());
            }
            
        }
        
        for(Map.Entry<Integer, Ordynator> entry: headPhysicians.entrySet()){
            
            if((entry.getValue().getLogin().equals(login)) && (entry.getValue().getPassword().equals(password)))
            {
                return headPhysicians.get(entry.getKey());
            }
            
        }
        
        for(Map.Entry<Integer, AdministratorTechniczny> entry: admins.entrySet()){
            
            
            if((entry.getValue().getLogin().equals(login)) && (entry.getValue().getPassword().equals(password)))
            {
                return admins.get(entry.getKey());
            }
            
        }
        
        return null;
    }
}

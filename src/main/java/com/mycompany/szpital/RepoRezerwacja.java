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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Bartek
 */
public class RepoRezerwacja {
    
    private LinkedHashMap<Integer, Rezerwacja> reservations;
    
    public RepoRezerwacja(LinkedHashMap<Integer, Rezerwacja> reservations)
    {
        this.reservations = reservations;
    }
    
    private static Rezerwacja createReservation(String[] data){
    
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String surname = data[2];
        LocalDate startDate = LocalDate.parse(data[3]);
        LocalTime startTime = LocalTime.parse(data[4]);
        LocalDate endDate = LocalDate.parse(data[5]);
        LocalTime endTime = LocalTime.parse(data[6]);
        int number = Integer.parseInt(data[7]);
        String type = data[8];
        Sala room = new Sala(number, type);
        
        return new Rezerwacja(id, name, surname, startDate, endDate, startTime, endTime, room);
    
    }
    
    public Rezerwacja searchForReservation(String id){
    
        Rezerwacja reservation = null;
        for(Map.Entry<Integer, Rezerwacja> entry: reservations.entrySet())
        {
            if(id.equals(entry.getKey()))
            {
                reservation = entry.getValue();
            }
        }
        
        return reservation;
    
    }
    
    public void writeToDataBase(String path){
        
        BufferedWriter writer = null;
        
        try{
            FileWriter stream = new FileWriter(path);
            writer = new BufferedWriter(stream);
            
            for(Map.Entry<Integer, Rezerwacja> entry: reservations.entrySet())
            {
                writer.write(entry.getKey() + "    " + entry.getValue().getName() + "    " + 
                        entry.getValue().getSurname() + "    " + entry.getValue().getBeginningDate() + 
                        "    " + entry.getValue().getBeginningHour() + "    " + entry.getValue().getEndingDate() + 
                        "    " + entry.getValue().getEndingHour() + "    " + entry.getValue().getRoom().getNumber() + 
                        "    " + entry.getValue().getRoom().getType());
                
                writer.newLine();
            }
            
            writer.flush();
        } catch (IOException e){
         
            e.printStackTrace();
            
        }
        finally{
            try{
                writer.close();
            }catch (Exception e){
                
            }
        }
        
    }
    
    public void readFromDataBase(String path){
        
        String[] values;
        String line="";
        int key=0;
        
        try{
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line=br.readLine()) != null){
                
                values = line.split("    ");
                Rezerwacja reservation = createReservation(values);
                reservations.put(key, reservation);
                key++;
                
            }
            br.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public Uzytkownik searchForUser(String name, String surname){
    
        Uzytkownik user = null;
        for(Map.Entry<Integer, Rezerwacja> entry: reservations.entrySet())
        {
            if((name.equals(entry.getValue().getName()) && (surname.equals(entry.getValue().getSurname()))))
            {
                user = entry.getValue().getUser();
            }
                
        }
        
        return user;
    }
    
}

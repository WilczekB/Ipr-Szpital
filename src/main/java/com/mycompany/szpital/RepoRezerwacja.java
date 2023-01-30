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
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Bartek
 */
public class RepoRezerwacja {
    
    private LinkedHashMap<Integer, Rezerwacja> reservations;
    private RepoSal rooms; 
    
    public RepoRezerwacja(RepoSal r)
    {
        this.rooms = r;
        this.reservations = new LinkedHashMap<Integer, Rezerwacja>();
        this.readFromDataBase("./src/main/java/com/mycompany/szpital/Data/Rezerwacje.txt");
        this.rooms = r;
    }

    public LinkedHashMap<Integer, Rezerwacja> getReservations() {
        return reservations;
    }
    
    private Rezerwacja createReservation(String[] data){
    
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String surname = data[2];
        
        String dateString = "2022-04-05";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
        
        
        LocalDate startDate = LocalDate.parse(data[3], formatter);
        LocalTime startTime = LocalTime.parse(data[5], formatter1);
        LocalDate endDate = LocalDate.parse(data[4], formatter);
        LocalTime endTime = LocalTime.parse(data[6], formatter1);
        int number = Integer.parseInt(data[7]);
        
        Sala room = rooms.searchForRoom(number);
    
        return new Rezerwacja(id, name, surname, startDate, endDate, startTime, endTime, room);
    
    }
/*
    RepoRezerwacja(RepoSprzet equipments) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  */  
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
        
        try{
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line=br.readLine()) != null){
                
                values = line.split("    ");
                Rezerwacja reservation = createReservation(values);
                //Id rezerwacji jest jej kluczem w Mapie
                reservations.put(reservation.getId(), reservation);
                
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
    
    public void deleteReservation(){
        
    }
}

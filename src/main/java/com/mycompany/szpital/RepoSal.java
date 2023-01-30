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
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Bartek
 */
public class RepoSal {
    
    private LinkedHashMap<Integer, Sala> rooms;
    
    public RepoSal()
    {
        this.rooms = new LinkedHashMap<Integer, Sala>();
        this.readFromDataBase("./src/main/java/com/mycompany/szpital/Data/Sale.txt");
    }

    public LinkedHashMap<Integer, Sala> getRooms() {
        return rooms;
    }
    
    
    private static Sala createRoom(String[] data){
        
        int number = Integer.parseInt(data[0]);
        String type = data[1];
        
        return new Sala(number, type);
        
    }
   
    public void changeRoomType(String type, int key){
        this.rooms.get(key).setType(type);
    }
    
    
    
    public Sala searchForRoom(int number){
        
        for(Map.Entry<Integer, Sala> entry: rooms.entrySet())
        {
            if(number == entry.getValue().getNumber())
            {
                return rooms.get(entry.getKey());
            }
        }
        return null;
      
    }
    
    public void writeToDataBase(String path){
    
        BufferedWriter writer = null;
        
        try{
            
            FileWriter stream = new FileWriter(path);
            writer = new BufferedWriter(stream);
            
            for(Map.Entry<Integer, Sala> entry: rooms.entrySet())
            {
                writer.write(entry.getKey() + "    " + entry.getValue().getNumber() + "    " + entry.getValue().getType());
                writer.newLine();
            }
            
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                writer.close();
            } catch(Exception e) {
                
            }
        }
    
    }
    
    public void readFromDataBase(String path){
        
        String[] values;
        String line = "";
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line = br.readLine()) != null)
            {
                values = line.split("    ");
                Sala room = createRoom(values);
                rooms.put(room.getNumber(), room);
            }
            
            br.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}

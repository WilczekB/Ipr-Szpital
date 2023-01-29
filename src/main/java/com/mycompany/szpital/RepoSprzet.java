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
public class RepoSprzet {
    
    private LinkedHashMap<Integer, Sprzet> equipment = new LinkedHashMap<Integer, Sprzet>();
    
    public RepoSprzet(LinkedHashMap<Integer, Sprzet> equipment){
    
        this.equipment = equipment;
    
    }

    public LinkedHashMap<Integer, Sprzet> getEquipment() {
        return equipment;
    }
    
    
    
    public RepoSprzet(){
        this.readFromDataBase("./src/main/java/com/mycompany/szpital/Data/Sprzet.txt");
    }
    
    private static Sprzet createDevice(String[] data){
        
        String name = data[1];
        String category = data[2];
        int id = Integer.parseInt(data[0]);
        boolean isDisinfected = Boolean.parseBoolean(data[4]);
        String alocation = data[3];
        
        return new Sprzet(name, category, alocation, id, isDisinfected);
    }
    
    public Sprzet searchForDevice(String id){
    
        Sprzet device = null;
        for(Map.Entry<Integer, Sprzet> entry: equipment.entrySet())
        {
            if(id.equals(entry.getValue().getId()))
            {
                device = entry.getValue();
            }
        }
        return device;
    
    }
    
    public void writeToDataBase(String path){
    
        BufferedWriter writer = null;
        
        try{
            
            FileWriter stream = new FileWriter(path);
            writer = new BufferedWriter(stream);
            
            for(Map.Entry<Integer, Sprzet> entry: equipment.entrySet()){
                writer.write(entry.getKey() + "    " + entry.getValue().getName() + 
                        "    " + entry.getValue().getCategory() + "    " + entry.getValue().getAlocation() + 
                        "    " + entry.getValue().isItDisinfected());
                
                writer.newLine();
            }
            
            writer.flush();
        } catch (IOException e){
        
            e.printStackTrace();
        
        }
        finally{
            try{
                writer.close();
            } catch (Exception e){
                
            }
        }
    
    }
    
    public void readFromDataBase(String path){
    
        String[] values;
        String line="";
        int key=0;
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line = br.readLine()) != null){
                
                values = line.split("    ");
                System.out.println(values[1] + " ");
                Sprzet eq = createDevice(values);
                equipment.put(key,eq);
                key++;
                
            }
            
            br.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    
    }
    
    public void changeDeviceStatus(Integer id, String category, String name, boolean isDisinfected, String alocation){
    
        Integer key = null;
        for(Map.Entry<Integer, Sprzet> entry: equipment.entrySet()){
        
            if(id.equals(entry.getValue().getId()))
            {
                key = entry.getKey();
            }
        
        }
        
        if(category!=equipment.get(key).getCategory())
        {
            equipment.get(key).setCategory(category);
        }
        
        if(name!=equipment.get(key).getName())
        {
            equipment.get(key).setName(name);
        }
        
        if(isDisinfected!=equipment.get(key).isItDisinfected())
        {
            equipment.get(key).setIsDisinfected(isDisinfected);
        }
        
        if(alocation!=equipment.get(key).getAlocation())
        {
            equipment.get(key).setAlocation(alocation);
        }
    
    }
    
    public void addDevice(String name, String category, String alocation, boolean isDisinfected){
    
        Integer key = equipment.size()+1;
        Sprzet device = new Sprzet(name, category, alocation, key, isDisinfected);
        equipment.put(key, device);
    
    }
    
    public void deleteDevice(int id){
        
        for(Map.Entry<Integer, Sprzet> entry: equipment.entrySet())
        {
            if(entry.getValue().getId() == id)
            {
                equipment.remove(entry.getKey());
            }
        }
        
    }
}

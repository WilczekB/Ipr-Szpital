/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private LinkedHashMap<Integer, Rezerwacja> reservations;
    private LinkedHashMap<Integer, Sprzet> equipment;
    
    private static Lekarz createLekarz(String[] data){
        
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        String sort = data[5];
        
        return new Lekarz(name, surName, phoneNumber, login, password, sort);
        
    }
    
    private static Ordynator createOrdynator(String[] data){
    
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        String sort = data[5];
        
        return new Ordynator(name, surName, phoneNumber, login, password, sort);
    }
    
    private static AdministratorTechniczny createAdministrator(String[] data){
        
        String name = data[0];
        String surName = data[1];
        int phoneNumber = Integer.parseInt(data[2]);
        String login = data[3];
        String password = data[4];
        String sort = data[5];
        
        return new AdministratorTechniczny(name, surName, phoneNumber, login, password, sort);
    }
    
    private static Sprzet createEquipment(String[] data){
        
        String name = data[0];
        String category = data[1];
        int id = Integer.parseInt(data[2]);
        boolean isDisinfected = Boolean.parseBoolean(data[3]);
        String alocation = data[4];
        
        return new Sprzet(name, category, alocation, id, isDisinfected);
    }
    
    private static  void createReservation(String[] data){
        
        int id = Integer.parseInt(data[0]);
        int number = Integer.parseInt(data[1]);
        String type = data[2];
        String name = data[3];
        String surname = data[4];
        LocalDate startDate = LocalDate.parse(data[5]);
        LocalTime startTime = LocalTime.parse(data[6]);
        LocalDate endDate = LocalDate.parse(data[7]);
        LocalTime endTime = LocalTime.parse(data[8]);
        
        //return new Rezerwacja(id, startDate, endDate, startTime, endTime, number, type);
    }
    
    public void readUsersFromFile(String path){
        
        String[] values;
        String line="";
        int key=0;
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line = br.readLine()) != null){
                
                values = line.split("    ");
                
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
    
    public void readEquipmentFromFile(String path){
        
        String[] values;
        String line="";
        int key=0;
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line = br.readLine()) != null){
                
                values = line.split("    ");
                Sprzet eq = createEquipment(values);
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
    
    public void writeEquipmentToFile(String path){
    
        
        BufferedWriter writer = null;
        
        try{
            
            FileWriter stream = new FileWriter("Data//Rezerwacje.txt");
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
    
    public void writeReservationToFile(String path){
    
        String[] values;
        String line="";
        int key=0;
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader((path)));
            
            while((line = br.readLine()) != null){
            
                values = line.split("    ");
                Rezerwacja reservation = createReservation(values);
                reservations.put(key, reservation);
                key++;
                
            }
            br.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    
    }
    
    public Uzytkownik checkLogin(String log, String pass){
        
        for(Map.Entry<Integer, Lekarz> set : doctors.entrySet()){
            if(set.getValue().validateUser(log, pass)){
                return set.getValue();
            }
        }
        
        for(Map.Entry<Integer, Ordynator> set : headPhysicians.entrySet()){
            if(set.getValue().validateUser(log, pass)){
                return set.getValue();
            }
        }
        
        for(Map.Entry<Integer, AdministratorTechniczny> set : admins.entrySet()){
            if(set.getValue().validateUser(log, pass)){
                return set.getValue();
            }
        }
        return null;
}
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EkranStartowy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EkranStartowy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EkranStartowy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EkranStartowy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EkranStartowy().setVisible(true);
            }
        });
    }
}

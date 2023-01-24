/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.szpital;

/**
 *
 * @author Bartek
 */
public class Sprzet {
    
    private String name, category, alocation;
    private int id;
    private boolean isDisinfected;

    public Sprzet(String name, String category, String alocation, int id, boolean isDisinfected) {
        this.name = name;
        this.category = category;
        this.alocation = alocation;
        this.id = id;
        this.isDisinfected = isDisinfected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAlocation() {
        return alocation;
    }

    public void setAlocation(String alocation) {
        this.alocation = alocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsDisinfected() {
        return isDisinfected;
    }

    public void setIsDisinfected(boolean isDisinfected) {
        this.isDisinfected = isDisinfected;
    }
    
    
    
}

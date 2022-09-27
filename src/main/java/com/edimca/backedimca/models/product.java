package com.edimca.backedimca.models;

public class product {
    public int id; 
    public String name; 
    public void setId(int id) {
        this.id = id;
    }
    public product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public product() {
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public float price; 
    
    
}

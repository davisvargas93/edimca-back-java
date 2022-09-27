package com.edimca.backedimca.models;

public class purchaseHeader{
    public int id ;
    public String create_date;
    public int getId() {
        return id;
    }
    public String getCreate_date() {
        return create_date;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    public purchaseHeader(int id, String create_date) {
        this.id = id;
        this.create_date = create_date;
    }
    public purchaseHeader() {
    }

}

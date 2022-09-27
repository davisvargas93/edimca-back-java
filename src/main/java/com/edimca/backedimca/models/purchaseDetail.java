package com.edimca.backedimca.models;

public class purchaseDetail  {
    public int id ;
    public int id_header ;
    public String create_date;
    public int id_product ;
    public float amount ;
    public purchaseDetail(int id, int id_header, String create_date, int id_product,float amount ) {
        this.id = id;
        this.id_header = id_header;
        this.create_date = create_date;
        this.id_product = id_product;
        this.amount = amount;
    }
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

    public int getId_header() {
        return id_header;
    }
    public int getId_product() {
        return id_product;
    }
    public void setId_header(int id_header) {
        this.id_header = id_header;
    }
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
    public purchaseDetail() {
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
}

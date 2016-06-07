package com.awl.training.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    private static final long serialVersionUID = 6555760898203031749L;

    private long id;
    
    private String title;
    
    private String description;
    
    private BigDecimal price;

    private BigDecimal fee;
    
    private long stock;
    
    public Product(){
        
    }
    
    public Product(long id, String title, String description, BigDecimal price, BigDecimal fee, long stock) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.fee = fee;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
    
    public void addStock(long capacity){
        this.stock += capacity;
    }
    
    public boolean removeStock(long capacity){
        if(this.stock < capacity){
            return false;
        }
        
        this.stock -= capacity;
        return true;
    }
}

package com.awl.training.beans;

import java.io.Serializable;

public class OrderItem implements Serializable {

    private static final long serialVersionUID = 6185777434230849258L;

    private long quantity;
    private Product product;
    
    public OrderItem(){
        
    }
    
    public OrderItem(long quantity, Product product) {
        super();
        this.quantity = quantity;
        this.product = product;
    }
    
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}

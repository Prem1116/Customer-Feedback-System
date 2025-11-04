package com.feedbacksystem.model;

import java.sql.Timestamp;

public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private Timestamp createdAt;

    //Constructor
    public Product() {}

    public Product(int productId, String name, String description, double price, Timestamp createdAt) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    //Getter & Setter
    public int getProductId() {return productId;}
    public void setProductId(int productId) {this.productId = productId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public Timestamp getCreatedAt() {return createdAt;}
    public void setCreatedAt(Timestamp createdAt) {this.createdAt = createdAt;}

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + productId +
                ", Name='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", Price=" + price + '\'' +
                ", CreatedAt=" + createdAt +
                '}';
    }
}

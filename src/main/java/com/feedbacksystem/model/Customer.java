package com.feedbacksystem.model;

import java.sql.Timestamp;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private Timestamp createdAt;

    //Constructor
    public Customer(){}


    public Customer(int customerId,String name,String email,String phone,String gender,Timestamp createdAt) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.createdAt = createdAt;
    }

    //Getter & Setter
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int CustomerId) {this.customerId=CustomerId;}

    public String getName() {return name;}
    public void setName(String name) {this.name=name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email=email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone=phone;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender=gender;}

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Customer{"+
                "CustomerId=" + customerId +
                ", Name=" + name + '\'' +
                ", Email=" + email + '\'' +
                ", Phone_No='" + phone + '\'' +
                ", Gender='" + gender + '\'' +
                ", CreatedAt=" + createdAt +
                '}';
    }
}

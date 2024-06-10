package com.example.projet.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String customer_id;
    private String customer_name;

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCustomerId() { return customer_id; }
    public void setCustomerId(String customer_id) { this.customer_id = customer_id; }
    public String getCustomerName() { return customer_name; }
    public void setCustomerName(String customer_name) { this.customer_name = customer_name; }
}
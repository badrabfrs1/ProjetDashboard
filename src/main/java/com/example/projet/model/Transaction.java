package com.example.projet.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String transaction_id;
    private String timestamp;
    private String customer_id;
    private String customer_name;
    private String product_id;
    private String product_name;
    private String category;
    private int quantity;
    private double price_per_unit;
    private double total_price;
    private String payment_method;
    private String location;

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTransactionId() { return transaction_id; }
    public void setTransactionId(String transaction_id) { this.transaction_id = transaction_id; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public String getCustomerId() { return customer_id; }
    public void setCustomerId(String customer_id) { this.customer_id = customer_id; }
    public String getCustomerName() { return customer_name; }
    public void setCustomerName(String customer_name) { this.customer_name = customer_name; }
    public String getProductId() { return product_id; }
    public void setProductId(String product_id) { this.product_id = product_id; }
    public String getProductName() { return product_name; }
    public void setProductName(String product_name) { this.product_name = product_name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPricePerUnit() { return price_per_unit; }
    public void setPricePerUnit(double price_per_unit) { this.price_per_unit = price_per_unit; }
    public double getTotalPrice() { return total_price; }
    public void setTotalPrice(double total_price) { this.total_price = total_price; }
    public String getPaymentMethod() { return payment_method; }
    public void setPaymentMethod(String payment_method) { this.payment_method = payment_method; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
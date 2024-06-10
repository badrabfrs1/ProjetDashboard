package com.example.projet.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String product_id;
    private String product_name;
    private String category;
    private double price_per_unit;

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProductId() { return product_id; }
    public void setProductId(String product_id) { this.product_id = product_id; }
    public String getProductName() { return product_name; }
    public void setProductName(String product_name) { this.product_name = product_name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPricePerUnit() { return price_per_unit; }
    public void setPricePerUnit(double price_per_unit) { this.price_per_unit = price_per_unit; }
}
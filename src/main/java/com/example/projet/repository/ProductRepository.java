package com.example.projet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.projet.model.Product;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByProductName(String productName);
    List<Product> findByProductNameContaining(String keyword);
    List<Product> findByCategory(String category);
}
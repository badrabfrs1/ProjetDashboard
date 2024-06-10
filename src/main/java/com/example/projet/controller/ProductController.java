package com.example.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.projet.service.AggregationService;
import com.example.projet.model.Product;
import com.example.projet.model.Transaction;
import com.example.projet.repository.ProductRepository;

import java.util.List;
import java.util.Optional; // Add this line

@RestController
public class ProductController {

    @Autowired
    private AggregationService aggregationService;


    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    @GetMapping("/transactionsWithProductDetails")
    public List<Transaction> getTransactionsWithProductDetails() {
        return aggregationService.getTransactionsWithProductDetails();
    }


    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
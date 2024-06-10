package com.example.projet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.projet.model.Customer;
import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerNameContaining(String keyword);
}
package com.example.projet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.projet.model.Transaction;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByCustomerId(String customerId);
    List<Transaction> findByProductId(String productId);
    List<Transaction> findByPaymentMethod(String paymentMethod);
    List<Transaction> findByLocation(String location);
}
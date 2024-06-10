package com.example.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.projet.service.AggregationService;
import com.example.projet.model.Transaction;
import com.example.projet.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private AggregationService aggregationService;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/transactionsWithCustomerAndProductDetails")
    public List<Transaction> getTransactionsWithCustomerAndProductDetails() {
        return aggregationService.getTransactionsWithCustomerAndProductDetails();
    }

    @GetMapping("/api/transactions")
    public List<Transaction> getAllTransactions() {
        return aggregationService.getAllTransactions();
    }

    @GetMapping("/api/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
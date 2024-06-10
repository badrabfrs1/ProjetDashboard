package com.example.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.projet.service.AggregationService;
import com.example.projet.model.Customer;
import com.example.projet.model.Transaction;
import com.example.projet.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;



@RestController
public class CustomerController {

    @Autowired
    private AggregationService aggregationService;

    @GetMapping("/transactionsWithCustomerDetails")
    public List<Transaction> getTransactionsWithCustomerDetails() {
        return aggregationService.getTransactionsWithCustomerDetails();
    }
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/api/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("/api/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
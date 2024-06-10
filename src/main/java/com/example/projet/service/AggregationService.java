package com.example.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;


import com.example.projet.model.Transaction;

import java.util.List;

@Service
public class AggregationService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Transaction> getTransactionsWithCustomerDetails() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("customer")
                .localField("customer_id")
                .foreignField("customer_id")
                .as("customerDetails");
    
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
    
        AggregationResults<Transaction> results = mongoTemplate.aggregate(
                aggregation, "transaction", Transaction.class);
    
        return results.getMappedResults();
    }

    public List<Transaction> getTransactionsWithProductDetails() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("product")
                .localField("product_id")
                .foreignField("product_id")
                .as("productDetails");
    
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
    
        AggregationResults<Transaction> results = mongoTemplate.aggregate(
                aggregation, "transaction", Transaction.class);
    
        return results.getMappedResults();
    }

    public List<Transaction> getTransactionsWithCustomerAndProductDetails() {
        LookupOperation lookupCustomer = LookupOperation.newLookup()
                .from("customer")
                .localField("customer_id")
                .foreignField("customer_id")
                .as("customerDetails");
    
        LookupOperation lookupProduct = LookupOperation.newLookup()
                .from("product")
                .localField("product_id")
                .foreignField("product_id")
                .as("productDetails");
    
        Aggregation aggregation = Aggregation.newAggregation(lookupCustomer, lookupProduct);
    
        AggregationResults<Transaction> results = mongoTemplate.aggregate(
                aggregation, "transaction", Transaction.class);
    
        return results.getMappedResults();
    }

    public List<Transaction> getAllTransactions() {
        return mongoTemplate.find(new Query(), Transaction.class);
    }

}
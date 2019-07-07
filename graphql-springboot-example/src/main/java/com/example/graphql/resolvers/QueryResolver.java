package com.example.graphql.resolvers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.domain.Account;
import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Transaction;
import com.example.graphql.service.AccountService;
import com.example.graphql.service.CustomerService;
import com.example.graphql.service.TransactionService;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionService transactionService;

    
    public List<Account> getAccounts() {
        return accountService.getAccounts().stream()
                .collect(Collectors.toList());
    }
    
    public List<Customer> getCustomers() {
        return customerService
                .getCustomers()
                .stream()
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactions() {
        return transactionService
                .getTransactions()
                .stream()
                .collect(Collectors.toList());
    }
}
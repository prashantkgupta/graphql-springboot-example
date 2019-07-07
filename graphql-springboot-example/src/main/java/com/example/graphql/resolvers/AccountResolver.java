package com.example.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.domain.Account;
import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Transaction;
import com.example.graphql.service.CustomerService;
import com.example.graphql.service.TransactionService;

@Component
public class AccountResolver implements GraphQLResolver<Account> {


    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private TransactionService transactionService;

    public Transaction transaction(Account account) {
    	return transactionService.getTransactionByAcountNumber(account.getAccountNumber());
    }
    

    public Customer customer(Account account) {
        return customerService.getCustomerByAcountNumber(account.getAccountNumber());
    }

}

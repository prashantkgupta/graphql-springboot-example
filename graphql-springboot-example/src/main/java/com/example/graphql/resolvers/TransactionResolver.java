package com.example.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.domain.Account;
import com.example.graphql.domain.Transaction;
import com.example.graphql.service.TransactionService;

@Component
public class TransactionResolver implements GraphQLResolver<Transaction> {
    
/*    @Autowired
    private TransactionService transactionService;

    public Transaction transaction(Account account) {
    	return transactionService.getTransactionByAcountNumber(account.getAccountNumber());
    }*/

}

package com.example.graphql.resolvers;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.example.graphql.domain.Account;
import com.example.graphql.domain.Transaction;
import com.example.graphql.publisher.AccountPublisher;
import com.example.graphql.publisher.TransactionPublisher;

@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {

    @Autowired
    private TransactionPublisher transactionPublisher;
    
    @Autowired
    private AccountPublisher accountPublisher;

    public Publisher<Account> listenNewAccount() {
        return accountPublisher.getPublisher();
    }
    
    public Publisher<Transaction> listenNewTransaction() {
        return transactionPublisher.getPublisher();
    }

}

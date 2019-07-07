package com.example.graphql.service;

import java.util.List;

import com.example.graphql.domain.Transaction;


public interface TransactionService {

	public Transaction addTransaction(Transaction transaction);

    public void deleteTransaction(Integer transactionId);

    public List<Transaction> getTransactions();
    
    public Transaction getTransactionByAcountNumber(Integer accountNumber);
}

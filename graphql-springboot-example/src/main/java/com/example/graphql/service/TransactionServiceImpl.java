package com.example.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.domain.Transaction;
import com.example.graphql.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepo;

	@Override
	public Transaction addTransaction(Transaction transaction) {
		transactionRepo.addTransaction(transaction);
		return transaction;
	}

	@Override
	public void deleteTransaction(Integer transactionId) {
		Transaction tempTransaction = null;
		List<Transaction> transactionList = transactionRepo.getTransactionList();
		for (Transaction transaction : transactionList) {
			if (transaction != null && transaction.getTransactionId() == transactionId) {
				tempTransaction = transaction;
			}
		}

		if (tempTransaction != null) {
			transactionRepo.deleteTransaction(tempTransaction);
		}
	}

	@Override
	public List<Transaction> getTransactions() {
		return transactionRepo.getTransactionList();
	}
	
	@Override
	public Transaction getTransactionByAcountNumber(Integer accountNumber) {
		Transaction responseTransaction = null;
		List<Transaction> alTransaction = transactionRepo.getTransactionList();
		for (Transaction transaction : alTransaction) {
			if (transaction != null && transaction.getAccountNumber().intValue() == accountNumber.intValue() ) {
				responseTransaction = transaction;
			}
			
		}
		return responseTransaction;
	}
}

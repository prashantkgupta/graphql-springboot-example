package com.example.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.graphql.domain.Transaction;

/*
 *  repository class can be updated to other backend/database implementation for respective database operations.
 * 
 * */

@Repository
public class TransactionRepository {

	private static List<Transaction> transactionList = new ArrayList<>();
	static {
		Transaction tran = new Transaction(1, 1001, "12/12/2012", "Mobile Purchase", "Best Buy");
		transactionList.add(tran);
	}

	public List<Transaction> getTransactionList() {
		List<Transaction> alTransactionList = transactionList.stream().collect(Collectors.toList());
		return alTransactionList;
	}

	public void addTransaction(Transaction tran) {
		synchronized (TransactionRepository.class) {
			transactionList.add(tran);
		}
	}

	public void deleteTransaction(Transaction tran) {
		synchronized (TransactionRepository.class) {
			transactionList.remove(tran);
		}
	}

}

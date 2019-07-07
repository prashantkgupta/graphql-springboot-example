package com.example.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.graphql.domain.Account;

/*
 *  repository class can be updated to other backend/database implementation for respective database operations.
 * 
 * */

@Repository
public class AccountRepository {

	private static List<Account> accountList = new ArrayList<>();
	static {
		Account acct = new Account(1001, "Test Account", 200.20, "Saving");
		accountList.add(acct);
	}

	public List<Account> getAccountList() {
		List<Account> alAccountList = accountList.stream().collect(Collectors.toList());
		return alAccountList;
	}

	public void addAccount(Account cust) {
		synchronized (AccountRepository.class) {
			accountList.add(cust);
		}
	}

	public void deleteAccount(Account cust) {
		synchronized (AccountRepository.class) {
			accountList.remove(cust);
		}
	}

}

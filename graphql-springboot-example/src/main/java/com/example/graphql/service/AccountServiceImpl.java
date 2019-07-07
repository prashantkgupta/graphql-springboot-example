package com.example.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.domain.Account;
import com.example.graphql.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepo;

	@Override
	public Account addAccount(Account account) {
		accountRepo.addAccount(account);
		return account;
	}

	@Override
	public String deleteAccount(Integer accountNumber) {
		String status = "Account not found";
		Account tempAccount = null;
		List<Account> accountList = accountRepo.getAccountList();
		for (Account account : accountList) {
			if (account != null && account.getAccountNumber() == accountNumber) {
				tempAccount = account;
			}
		}

		if (tempAccount != null) {
			accountRepo.deleteAccount(tempAccount);
			status = "SUCCESS";
		}
		return status;
	}

	@Override
	public List<Account> getAccounts() {
		return accountRepo.getAccountList();
	}
}

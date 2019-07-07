package com.example.graphql.service;

import java.util.List;

import com.example.graphql.domain.Account;

public interface AccountService {

	public Account addAccount(Account account);

    public String deleteAccount(Integer accountId);

    public List<Account> getAccounts();
    
    
}

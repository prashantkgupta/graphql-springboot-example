package com.example.graphql.resolvers;

import static graphql.ErrorType.DataFetchingException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.domain.Account;
import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Transaction;
import com.example.graphql.publisher.AccountPublisher;
import com.example.graphql.publisher.TransactionPublisher;
import com.example.graphql.service.AccountService;
import com.example.graphql.service.CustomerService;
import com.example.graphql.service.TransactionService;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

@Component
public class MutationResolver implements GraphQLMutationResolver {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AccountPublisher accountPublisher;

	@Autowired
	private TransactionPublisher transactionPublisher;

	public Account addAccount(Account accountRequest) {
		try {
			Account account = accountService.addAccount(accountRequest);
			accountPublisher.publish(account);
			return account;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public Customer addCustomer(Customer customerRequest) {
		try {
			Customer customer = customerService.addCustomer(customerRequest);
			return customer;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public Transaction addTransaction(Transaction transactionRequest) {
		try {
			Transaction transaction = transactionService.addTransaction(transactionRequest);
			transactionPublisher.publish(transaction);
			return transaction;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public String deleteAccount(Integer accountNumber) {
		String status = accountService.deleteAccount(accountNumber);
		return status;
	}

	private GraphQLError customError(Exception ex) {
		return new GraphQLError() {
			@Override
			public String getMessage() {
				return ex.getMessage();
			}

			@Override
			public List<SourceLocation> getLocations() {
				return null;
			}

			@Override
			public ErrorType getErrorType() {
				return DataFetchingException;
			}
		};
	}
}

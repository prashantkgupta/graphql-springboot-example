package com.example.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.graphql.domain.Customer;

/*
 *  repository class can be updated to other backend/database implementation for respective database operations.
 * 
 * */

@Repository
public class CustomerRepository {

	private static List<Customer> customerList = new ArrayList<>();
	static {
		Customer cust = new Customer(1001, "Primary", "Test", "ABC");
		customerList.add(cust);
	}

	public List<Customer> getCustomerList() {
		List<Customer> alCustmoerList = customerList.stream().collect(Collectors.toList());
		return alCustmoerList;
	}

	public void addCustomer(Customer cust) {
		synchronized (CustomerRepository.class) {
			customerList.add(cust);
		}
	}

	public void deleteCustomer(Customer cust) {
		synchronized (CustomerRepository.class) {
			customerList.remove(cust);
		}
	}

}

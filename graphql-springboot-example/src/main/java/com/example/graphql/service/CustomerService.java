package com.example.graphql.service;

import java.util.List;

import com.example.graphql.domain.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer entity);

    public void deleteCustomer(Integer customerId);

    public List<Customer> getCustomers();
    
    public Customer getCustomerByAcountNumber(Integer accountNumber);
}

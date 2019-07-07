package com.example.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.domain.Customer;
import com.example.graphql.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository custRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		custRepo.addCustomer(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		Customer tempCustomer = null;
		List<Customer> customerList = custRepo.getCustomerList();
		for (Customer cust : customerList) {
			if (cust != null && cust.getCustomerId() == customerId) {
				tempCustomer = cust;
			}
		}

		if (tempCustomer != null) {
			custRepo.deleteCustomer(tempCustomer);
		}
	}

	@Override
	public List<Customer> getCustomers() {
		return custRepo.getCustomerList();
	}
	
	@Override
	public Customer getCustomerByAcountNumber(Integer accountNumber) {
		Customer responseCustomer = null;
		List<Customer> alCustomer = custRepo.getCustomerList();
		for (Customer customer : alCustomer) {
			if (customer != null && customer.getCustomerId().intValue() == accountNumber.intValue() ) {
				responseCustomer = customer;
			}
			
		}
		return responseCustomer;
	}
}

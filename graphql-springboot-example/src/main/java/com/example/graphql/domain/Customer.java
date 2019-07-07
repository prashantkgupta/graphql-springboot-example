package com.example.graphql.domain;

public class Customer {
	private Integer customerId;
	private String customerType;
	private String firstName;
	private String lastName;
	private Address address;
	
    public Customer(Integer customerId, String customerType, String firstName, String lastName) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}

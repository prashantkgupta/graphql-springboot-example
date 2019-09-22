# graphql-springboot-example

1- Build and Deploy application using maven commands.

2- Run the application and launch localhost as below:-

http://localhost:8080/graphiql

3- Add Account, Customer and Transaction with below mutation operations:-

mutation{
  addAccount(account:{
    accountNumber: 1005
    accountName: "Test Account5"
    accountType: "Credit"
    accountBalance: 5000
  }){
    accountNumber
    accountBalance
  }
}

mutation{
  addCustomer(
    customer:{
      customerId: 1002
      firstName: "TestFirst"
      lastName: "TestLast"
      customerType: "Primary"
      address:{
        addressLine1: "1800 E Spring"
        addressLine2: "Apt 327"
        city: "Plano"
        state: "TX"
        zipCode: 75074
        country: "US"
      }   
    }
  ){
    customerId
    firstName
  }
}


mutation{
  addTransaction(transaction:{
    transactionId: 102
    accountNumber: 1002
    transactionDate: "12/12/2019"
    transactionDescription: "Mobile"
    merchantName: "Best Buy"
  }){
    accountNumber
    transactionId
  }
}



4- Query the above added account, customer, transaction using one query as below :-

query{
  getAccounts{
    accountName
    accountNumber
    customer{
			firstName
      lastName
      customerType
      address{
        city
        state
        country
      }
    }
    transaction{
      transactionId
      transactionDate
      transactionDescription
      merchantName
    }
  }
}

5- Subscribe for new event such as new Account as below, which will be published once new event triggers:-

subscription{
listenNewAccount{
  accountNumber
  accountName
}
}



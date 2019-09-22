# graphql-springboot-example

Build and Deploy application using maven commands.

Add Account :-

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

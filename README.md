# BankApp
This code was a project for Object Oriented Programming (OOP) / Programming II course at ASPU, which is a simple banking applicaiton.

You can login to this application as a customer or as a manager.

  logging in as a customer has the following features: 
    1. Balance enquiry.
    2. Deposit cash.
    3. Withdraw cash.
    4. Print out information about all the accounts the customer has.
    
  logging in as a manager has the following features: 
    1. Add a new customer.
    2. Open an account to a selected customer.
    3. Deposit interest rates to a customers Savings account (if he created a Savings account)
    4. Print out details about a customer and all the accounts they have.
    
 
 
Things used in this code:
  Abstract class "Account" has String PIN, double Balance, and methods to deposit, withdraw, and print out details about the account.
  Class Saving account extends Account and implements Serializable (for the purpose of saving data of accounts into a text file), with methods to add interest rate and printing information out.
  Class Chekcing Account extends Account and implements Serializable (for the same purpose as before), overriding method to withdraw that allows the account owner to go negative until they reach their credit limit, and printing information out.
  
  Class Person implements Serializable, with basic method to print out information of said customer.
  Class Manager extends Person implements Serializable, with a method to add a new customer. A method to create a new account, with the ability to choose between a Savings or Checking account. A method to add interest rate to a customers savings account. A method to print out information about a customer and the accounts they own.
  Class Customer extends Person implements Serializable. Method to create new Checking Account. Methond to create new Savings Account. Method to print out information about an account. Method to print out information about all accounts the current customer has. Method to deposit and withdraw cash.
  
  Class MainMenu which is just a basic user interface that connects all the classes to eachother to makes the app operational.
  
THAT IS ALL. HAVE FUN!

package bankapp;

import java.io.Serializable;

public class CheckingAccount extends Account implements Serializable
{ 
    private double creditLimit;

    public CheckingAccount(double creditLimit, String PIN, double balance) 
    {
        super(PIN, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdrawBalance()
    {
          while(getBalance() > creditLimit*(-1) ) {
            try{
            System.out.println("Enter the amount you wish to withdraw, or enter '0' to exit");
            deposit = input.nextDouble();
            }
            catch(Exception e){
                System.out.println(e);
            }
            if (deposit> 0 && ( (creditLimit*-1) < (balance - deposit -10) ) ){
            balance-=( deposit + 10 ) ;
            System.out.println("Withdraw success! 10 s.p are deducted as transaction fee.\nYour balance now is : "+getBalance());
            break;
            }
            else if (deposit == 0)
                break;
            else 
            {
            System.out.println("ERROR - Insufficient balance! You can't go below your credit limit");
            }
        }
    }

    @Override
    public String toString() {
        return "Checking Account " + "has a Credit limit of : " + creditLimit + '.'+super.toString();
    }
}
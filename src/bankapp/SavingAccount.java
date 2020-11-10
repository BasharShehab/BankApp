package bankapp;

import java.io.Serializable;

public class SavingAccount extends Account implements Serializable
{
    private double InterestRate;
    public SavingAccount(double InterestRate, String PIN, double balance) 
    {
        super(PIN, balance);
        this.InterestRate = InterestRate;
    }
    
    public void addbenefit()
    {
        this.balance += ((this.balance* (InterestRate/100)) );
        System.out.println("Intrest rate added successfully!");
        
    }

    @Override
    public String toString() {
        return "Saving Account " + "has an interest rate of : " + InterestRate + '.'+super.toString();
    }
    
}
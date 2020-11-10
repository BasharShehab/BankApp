
package bankapp;
import static bankapp.BankApp.clearscreen;
import static bankapp.BankApp.isNumeric;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer extends Person implements Serializable
{
    public ArrayList<Account> arrAccounts;
    static Scanner input = new Scanner(System.in);
    public Customer(String numberID, String cName, String Type) 
    {
        super(numberID, cName, Type);
        arrAccounts = new ArrayList<Account>();
    }
    
    void NewCheckingAccount()
    {
        try
        {
            Scanner input = new Scanner(System.in);
        
            System.out.println("Enter the account's creditlimit");
            double creditLimit = input.nextDouble();
        
            System.out.println("Enter the account's PIN code");
            String PIN = input.next();
            
            while((!isNumeric(PIN)) || (PIN.length() > 4) || (PIN.length()<4))
            {
                clearscreen();
                System.out.println("!~~~Please Enter a Numeric value for PIN CODE~~~!");
                PIN = input.next();
            }
            
            System.out.println("Enter the account's current Balance");
            String balance = input.next();
            
            while((!isNumeric(balance)) || (balance.length() >8))
            {
                clearscreen();
                System.out.println("!~~~Please Enter a valid Balance value~~~!");
                PIN = input.next();
            }
            
            CheckingAccount ca = new CheckingAccount(creditLimit, PIN, Double.parseDouble(balance));
            arrAccounts.add(ca);
            System.out.println("Checking account with PIN("+PIN+") created successfully!");
        }
        catch(Exception e)
        { System.out.println(e.getMessage());}
    }
    
    void NewSavingaccount()
    {
        try 
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the account's Interest Rate");
            double InterestRate = input.nextDouble();
        
            System.out.println("Enter the account's PIN code");
            String PIN = input.next();
            
            while((!isNumeric(PIN)) || ((PIN.length() > 4 ) || (PIN.length())<4))
            {
                clearscreen();
                System.out.println("!~~~Please Enter a Numeric value for PIN CODE~~~!");
                PIN = input.next();
            }
        
            System.out.println("Enter the account's current Balance");
            String balance = input.next();
            
            while((!isNumeric(balance)) || (balance.length()>8))
            {
                clearscreen();
                System.out.println("!~~~Please Enter a valid Balance value~~~!");
                PIN = input.next();
            }

            SavingAccount sa = new SavingAccount(InterestRate, PIN, Double.parseDouble(balance));
            arrAccounts.add(sa);
            System.out.println("Saving account with PIN("+PIN+") created successfully!");
        }
        catch(Exception e)
        {System.out.println(e);}
    }
    
    void getInfo()
    {
        if (arrAccounts.size() == 0)
        {
            System.out.println("there is no active accounts");
            return;
        }
        
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < arrAccounts.size(); i++)
        {
                System.out.println((i+1)+". "+this.arrAccounts.get(i).getPIN());
        }
        System.out.println("please choose an account");
        int cnum = (in.nextInt() - 1);
        while(cnum+1 > this.arrAccounts.size()) {
            System.out.println("Error! - Enter a valid number: ");
            cnum = (in.nextInt() - 1);
        }
        System.out.println((cnum+1)+". "+this.arrAccounts.get(cnum).toString());
        
    }
    
    void addBalance()
    {
        if (arrAccounts.isEmpty())
        {
            System.out.println("there are no active accounts");
            return;
        }
        
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < arrAccounts.size(); i++)
        {
            System.out.println((i+1)+". "+this.arrAccounts.get(i).getPIN());
        }
        System.out.println("please choose an account");
        int cnum = (in.nextInt() - 1);
        this.arrAccounts.get(cnum).addBalance();
    }
    
    void withdrawBalance()
    {
        if (arrAccounts.isEmpty())
        {
            System.out.println("there are no active accounts");
            return;
        }
        
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < arrAccounts.size(); i++)
        {
            System.out.println((i+1)+". "+this.arrAccounts.get(i).getPIN());
        }
        System.out.println("please choose an account");
        int cnum = (in.nextInt() - 1);
        this.arrAccounts.get(cnum).withdrawBalance(); 
    } 
    
    void listallaccounts()
    {
        if (this.arrAccounts.isEmpty())
        {
            System.out.println("there are no active accounts");
            return;
        }
        
        for(int i = 0; i < arrAccounts.size(); i++)
        {
            System.out.println((i+1)+". "+this.arrAccounts.toString());
        }
    }
}
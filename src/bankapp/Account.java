
package bankapp;
import java.io.Serializable;
import java.util.Scanner;
public abstract class Account implements Serializable
{
    private String PIN;
    protected double balance;
    protected double deposit;
    static Scanner input = new Scanner(System.in);
     
    public double getBalance() 
    {return this.balance;}
    
    public String getPIN() 
    {return PIN;}

    public Account(String PIN, double balance) 
    {this.PIN = PIN; this.balance = balance;}

    public void addBalance()
    {
        System.out.println("Enter the amount you wish to deposit, or enter '0' to exit. ");
        try{
        deposit = input.nextDouble();
        }
        catch(Exception e){
            System.out.println(e);
        }
        while (deposit != 0)
        {
            if (deposit > 0) 
            {
                this.balance+=( deposit-10);
                System.out.println("Deposit successful! 10 s.p are deducted as transaction fee.\nYour balance now is : "+getBalance());
                break;
            }
            else  
            {
                System.out.println("ERROR! - Enter a positive amount!");
                try{
                deposit = input.nextDouble();
                }
                catch(Exception e){
                    System.out.println(e);
                }
                }
        } 
    }
    
    public void withdrawBalance()
    {
        while(balance != 0) 
        {
            System.out.println("Enter the amount you wish to withdraw, or enter '0' to exit");
            try{
            deposit = input.nextDouble();
            }
            catch(Exception e){
                System.out.println(e);
            }
            if (deposit> 0 && deposit+10 < this.getBalance())
            {
                balance-=( deposit + 10 ) ;
                System.out.println("Withdraw success! 10 s.p are deducted as transaction fee.\nYour balance now is : "+getBalance());
                break;
            }
            else if (deposit == 0)
            {
                break;
            }
            else 
            {
                System.out.println("ERROR - Insufficient balance!");
            }
        }
    }
        
    @Override public String toString()
    {
        return " PIN is : " + PIN + ", and balance is :" + balance + '.';
    }
}
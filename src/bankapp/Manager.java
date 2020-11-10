/**
 *
 * @author Mouaz
 */
package bankapp;

import static bankapp.BankApp.clearscreen;
import static bankapp.BankApp.isNumeric;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class Manager extends Person implements Serializable
{
    static Scanner in = new Scanner(System.in);
    public Manager(String numberID, String cName) 
    {
        super(numberID, cName, "Manager");
    }

    void NewIndividual()
    {
        String Type;
        
        System.out.println("Enter Individual's  Name");
        String cName = in.next();
        
        System.out.println("Enter the Individual's numberID");
        String numberID = in.next();
        
        //force 6 characters and check if numbers only
        while (((numberID.length() > 6) || (numberID.length() < 6)) || (!isNumeric(numberID)))
        {
           System.out.println("please Enter a valid number id (only 6 numbers)");
           numberID = in.next();
        }
        
        System.out.println("Please Choose Individual's Role");
        System.out.println("1. Customer");
        System.out.println("2. Manager");
        String TMPTypeid = in.next();
        
        //force numbered options
        while((!isNumeric(TMPTypeid)) || ((Integer.parseInt(TMPTypeid) > 2) || (Integer.parseInt(TMPTypeid) < 0)))
        {
            System.out.println("please Enter a valid option");
            System.out.println("Please Choose Individual's Role");
            System.out.println("1. Customer");
            System.out.println("2. Manager");
            TMPTypeid = in.next();
        }
        
        int Typeid = Integer.parseInt(TMPTypeid);
        if (Typeid == 2)
        {
            Manager nm = new Manager(numberID,cName);
            BankApp.AddManager(nm);
        }
        else if (Typeid == 1)
        {
            Customer nc = new Customer(numberID,cName, "customer");
            BankApp.AddCustomer(nc);
        }
        else
        {
            clearscreen();
            System.out.print("~~~please Choose a valid Role~~~");
            return;
        }
        clearscreen();
        System.out.println("~~~Customer ["+cName+"] Created Successfully~~~");
    }
    
    void NewAccount(ArrayList<Customer> arrCustomers, int arraylength)
    {
        if (arraylength == 0)
        {
            System.out.println("~~~there are no active accounts~~~");
            return;
        }
        System.out.println("Please Select one of the active customers:");
        for(int i = 0; i < arraylength; i++)
        {
            if ("customer".equals(arrCustomers.get(i).getType()))
                System.out.println((i+1)+". "+arrCustomers.get(i).getcName());
        }
        System.out.println("Choose a customer number");
        int cnum = (in.nextInt() - 1);
        
        System.out.println("Choose Account Type");
        System.out.println("1. Saving   Account");
        System.out.println("2. Checking Account");
        String tmpacType = in.next();
        //force numbered options
        while((!isNumeric(tmpacType)) || ((Integer.parseInt(tmpacType) > 2) || (Integer.parseInt(tmpacType) < 0)))
        {
            System.out.println("please Enter a valid option");
            System.out.println("Choose Account Type");
            System.out.println("1. Saving   Account");
            System.out.println("2. Checking Account");
            tmpacType = in.next();
        }
        
        int acType= Integer.parseInt(tmpacType);
        
        Customer customer = arrCustomers.get(cnum);
        if (acType == 1) //Saving Account
        {
            customer.NewSavingaccount();
        }
        else
        if (acType == 2) //Checking Account
        {
            customer.NewCheckingAccount(); 
        }
        else
        {
            clearscreen();
            System.out.print("~~~please Choose a valid Account type~~~");
            return;
        }
        clearscreen();
        System.out.println("~~~Account Created Successfully~~~");
    }
    
    public void addManBenefit(ArrayList<Customer> arrCustomers, int arraylength)
    {
        if (arraylength == 0)
        {
            System.out.println("~~~there are no active accounts~~~");
            return;
        }
        
        for(int i = 0; i < arraylength; i++)
        {
            if ("customer".equals(arrCustomers.get(i).getType()))
                System.out.println((i+1)+". "+arrCustomers.get(i).getcName());
        }
        
        System.out.println("Enter the customer number");
        int cnum = (in.nextInt() - 1);
        
        int arrlength = arrCustomers.get(cnum).arrAccounts.size();
        if (arrlength == 0)
        {
            System.out.println("there are no active accounts");
            return;
        }
        System.out.println("~~~Please choose customer's account~~~");
        int counter=0;
        for(int i = 0; i < arrlength; i++)
        {
            if (arrCustomers.get(cnum).arrAccounts.get(i) instanceof SavingAccount)
                counter++; 
        }
        if (counter ==0){
            System.out.println("there are no active saving accounts! returning . . .");
            return;
        }
        for (int i = 0; i<arrlength; i++){
            if (arrCustomers.get(cnum).arrAccounts.get(i) instanceof SavingAccount)
                System.out.println((i+1)+". "+arrCustomers.get(cnum).arrAccounts.get(i).getPIN());
        }
        int accOpt = in.nextInt()-1;
        SavingAccount s = (SavingAccount) arrCustomers.get(cnum).arrAccounts.get(accOpt);
        clearscreen();
        s.addbenefit();
    }
    
    public void getInfo(ArrayList<Customer> arrCustomers, int arraylength)
    {
        if (arraylength == 0)
        {
            System.out.println("there are no active accounts");
            return;
        }
        
        for(int i = 0; i < arraylength; i++)
        {
            if ("customer".equals(arrCustomers.get(i).getType()))
                System.out.println((i+1)+". "+arrCustomers.get(i).getcName());
        }
        
        System.out.println("Enter the customer number");
        int cnum = (in.nextInt() - 1);
        
        int arrlength = arrCustomers.get(cnum).arrAccounts.size();
        if (arrlength == 0)
        {
            System.out.println("there are no active accounts");
            return;
        }
        
        for(int i = 0; i < arrlength; i++)
        {
                System.out.println((i+1)+". "+arrCustomers.get(cnum).arrAccounts.get(i).toString());
        }
    }
}

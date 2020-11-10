package bankapp;
import static bankapp.BankApp.clearscreen;
import static bankapp.BankApp.isNumeric;
import java.util.Scanner;
import java.io.*;

public class MainMenu 
{
    private int opt_id = 99;
    private int list_id = 1;
    File file = new File("filename.txt");
    Scanner input = new Scanner (System.in);
    int loginmenu ()
    {
        System.out.println("Welcome to SY bank");
        System.out.println("1. To Login");
        System.out.println("0. To Exit");
        String key = input.next();
        if (!isNumeric(key))
        {
            clearscreen();
            System.out.println("!~~~Please Enter a Numeric value only~~~!");
            return 99;  
        }
        else if (Integer.parseInt(key)>1)
        {
            clearscreen();
            System.out.println("!~~~please choose a valid option~~~!");
            return 99;
        } 
        else
            return Integer.parseInt(key);
    }
    
    int managemenu()
    {
        //clearscreen();
        System.out.println("Welcome to SY bank");
        System.out.println("1. Create a new customer");
        System.out.println("2. Create a new account for a customer");
        System.out.println("3. Add interest rate to an account");
        System.out.println("4. Print customer and listed accounts details");
        System.out.println("5. Logout");
        System.out.println("0. Exit");
        String key = input.next();
        if (!isNumeric(key))
        {
            clearscreen();
            System.out.println("!~~~Please Enter a Numeric value only~~~!");
            return 99;  
        }
        else if (Integer.parseInt(key)>5)
        {
            clearscreen();
            System.out.println("!~~~please choose a valid option~~~!");
            return 99;
        }
        else
            return Integer.parseInt(key);
    }
    
    int customermenu()
    {
        //clearscreen();
        System.out.println("Welcome to SY bank");
        System.out.println("1. Balance info");
        System.out.println("2. Withdraw balance");
        System.out.println("3. Deposit balance");
        System.out.println("4. Print listed accounts details");
        System.out.println("5. Logout");
        System.out.println("0. Exit");
        String key = input.next();
        if (!isNumeric(key))
        {
            clearscreen();
            System.out.println("!~~~Please Enter a Numeric value only~~~!");
            return 99;  
        }
        else if (Integer.parseInt(key)>5)
        {
            clearscreen();
            System.out.println("!~~~please choose a valid option~~~!");
            return 99;
        } 
        else
            return Integer.parseInt(key);
    }
}

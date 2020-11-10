package bankapp;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class BankApp implements Serializable
{
    private static ArrayList<Customer> arrCustomer;
    private static ArrayList<Manager> arrManager;
    public static Person current_Person;
    
    
    public static void main(String[] args) throws IOException 
    {
        //list id and options id
        int list_id = 1;
        int opt_id = 1;
        
        //create array for all the individuals 
        arrCustomer = new ArrayList<Customer>();
        arrManager = new ArrayList<Manager>();
        Readfile();
        MainMenu menu = new MainMenu();
        //create the first bank manager
        Manager Main_Manager = new Manager("123123", "Admin");
        AddManager(Main_Manager);
        
        while(opt_id != 0)
        {
            writefile();
            
            switch (list_id) 
            {
                //login menu
                case 1:
                    opt_id = menu.loginmenu();
                    if (opt_id == 1)
                    {
                        //if user logged in successfully
                        if ((current_Person = userLogin()) != null)
                        {
                            if (current_Person.getType().equals("customer"))
                            {
                                list_id = 3;
                            }
                            else
                            {
                                list_id = 2;
                            }
                        }
                    }   break;
                //manager menu
                case 2:
                    opt_id = menu.managemenu();
                    
                    switch (opt_id) 
                    {
                        case 1:  //create new individual
                            clearscreen();
                            Main_Manager.NewIndividual();
                            break;
                        case 2: //create a new account for a customer
                            clearscreen();
                            Main_Manager.NewAccount(arrCustomer, arrCustomer.size());
                            break;
                        case 3: //Add Benefits
                            clearscreen();
                            Main_Manager.addManBenefit(arrCustomer, arrCustomer.size());  
                            break;
                        case 4: //Get customer informations
                            clearscreen();
                            Main_Manager.getInfo(arrCustomer, arrCustomer.size());
                            break;
                        case 5: //logout
                            clearscreen();
                            userLogout();
                            list_id = 1;
                            break;
                        default:
                            break;
                    }   break;
                //customer menu
                case 3:
                    opt_id = menu.customermenu();
                    switch (opt_id)
                    {
                        case 1: //Get Customer account information
                            ((Customer) current_Person).getInfo();
                            break;
                        case 2: //Withdraw from a account
                            ((Customer) current_Person).withdrawBalance();
                            break;
                        case 3: //add balance to an account
                            ((Customer) current_Person).addBalance();
                            break;
                        case 4: //list all accounts
                            ((Customer) current_Person).listallaccounts();
                            break;
                        case 5: //logout
                            clearscreen();
                            userLogout();
                            list_id = 1;
                            break;
                        default:
                            break;
                    }   break;
                default:
                    break;
            }
        }
        //if program exits by it self logout anyway
        userLogout();
        System.out.println("Thank you for using the SY banking app! Have a great day. ");
    } 

    public static void AddManager(Manager person) 
    { arrManager.add(person); }  
    
    public static void AddCustomer(Customer person) 
    { arrCustomer.add(person); }  
    
    public static Person userLogin()
    {
        //clear screen then ask for username and password
        clearscreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Please log in");
        System.out.println("Enter your name: ");
        String username = input.next().toLowerCase();
        
        System.out.println("Enter your number_id: ");
        String password = input.next().toLowerCase();
        if(!isNumeric(password))
        {
            clearscreen();
            System.out.println("!~~~Please Enter numeric value only for your numberid~~~!");
            return null;
        }
        //check the manager list for the user
        for(int i = 0; i <arrManager.size(); i++)
        {
            String Cname = arrManager.get(i).getcName().toLowerCase();
            String id    = arrManager.get(i).getNumberID().toLowerCase();
            if (username.equals(Cname) && password.equals(id))
            {
                clearscreen();
                System.out.println(Cname+" Has logged in successfully!");
                return arrManager.get(i); 
            }
        }
        
        //check the customer list for the user
        for(int i = 0; i <arrCustomer.size(); i++)
        {
            String Cname = arrCustomer.get(i).getcName().toLowerCase();
            String id    = arrCustomer.get(i).getNumberID().toLowerCase();
            if (username.equals(Cname) && password.equals(id))
            {
                clearscreen();
                System.out.println("~~~"+Cname+" Has logged in successfully~~~");
                return arrCustomer.get(i); 
            }
        }
        
        //if no user is found in manager list or customer list then something is wrong
        System.out.println("~~~Wrong name or number_id~~~");
        return null;
    }
    
    private static void userLogout()
    {
        //clear the current person and exit
        current_Person = null;
        System.out.println("logged out successfully!");
    }
    
    public static void clearscreen()
    {
        //this method spams \b to clear the screen
        for(int clear = 0; clear < 1000; clear++) 
        {System.out.println("\b") ;}
    }
    
    public static void writefile() throws IOException
    {
        try
        {
            File file = new File("Customerdata.ser");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrCustomer);
            oos.close();
            
            file = new File("Managerdata.ser");
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrManager);
            oos.close();
        }
        catch(IOException e)
        {
         System.out.println(e.getMessage());
        }
    }
    
    public static void Readfile() throws IOException
    {
        try
        {
            FileInputStream fis = new FileInputStream("Customerdata.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            arrCustomer = (ArrayList<Customer>) ois.readObject();
            ois.close();
            
            fis = new FileInputStream("Managerdata.ser");
            ois = new ObjectInputStream(fis);
            arrManager = (ArrayList<Manager>) ois.readObject();
            ois.close();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public static boolean isNumeric(String strNum) 
    {
        if (strNum == null) 
        { return false;}  
        try 
        {double d = Double.parseDouble(strNum);} 
        catch (NumberFormatException nfe) 
        {return false;}
        
        return true;
    }
}
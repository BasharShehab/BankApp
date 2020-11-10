package bankapp;
import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable
{
    private String numberID;
    private String cName;
    private String Type;
    private ArrayList<Account> arrAccounts;
    
    public Person(String numberID, String cName, String Type) 
    {
        this.numberID = numberID;
        this.cName = cName;
        this.Type = Type;
    }

    public String getType() 
    {
        return Type;
    }

    public String getcName() {return cName;}
    public String getNumberID() {return numberID;}
    
    public String toString() 
    {
        return "The customer with the Number ID of : "+ numberID + ". Name is : " + cName + " with an account type of :" + Type ;
    }
}
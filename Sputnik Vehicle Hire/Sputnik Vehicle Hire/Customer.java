import java.util.Scanner;
import java.io.PrintWriter;
public class Customer
{
    // instance variables
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
    //no parameter constructor 
    public Customer ()
    {  
        this.customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
    //get methods
     public String getCustomerID ()
    {
        return customerID;
    }
    
    public void setCustomerID (String customerID)
    {
        this.customerID = customerID;
    }
    
    public String getSurname ()
    {
        return surname;
    }
    
    public String getFirstName ()
    {
        return firstName;
    }
    
    public String getOtherInitials ()
    {
        return otherInitials;
    }
    
    public String getTitle ()
    {
        return title;
    }
    
     //print customer details
    public void printDetails() 
    {
        System.out.println("Customer ID: " + customerID + ", Surname: " + surname + ", First Name: " + firstName + ", Other Initials: " + otherInitials + ", Title: " + title);
    }
    
    //read data using Scanner object
     public void readDataCustomer(Scanner scanner) 
    {
        this.customerID = scanner.next();
        this.surname = scanner.next();
        this.firstName = scanner.next();
        this.otherInitials = scanner.next();
        this.title = scanner.next();
    }
    
    //write customer data to a file
    public void writeData(PrintWriter writer) 
    {
        writer.println(customerID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title);
    }
}

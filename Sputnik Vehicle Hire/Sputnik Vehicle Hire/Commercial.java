import java.util.Scanner;
public class Commercial extends Vehicle 
{
    // instance variables 
    private double payload;
    public Commercial (double payload)
    {
        this.payload = payload;
    }
    
    public Commercial ()
    {
         this.payload = payload;
    }
    
    //get method
    public double getPayload() 
    {
         return payload;
    }
    
    //override the read data calling the readData using keyword super
    public void readData(Scanner scanner) 
    {
        super.readData(scanner);
        this.payload = scanner.nextDouble();
    }
    
    public void printDetails() 
    {
        super.printDetails();
        System.out.println("Payload: " + payload + " kg");
    }
}

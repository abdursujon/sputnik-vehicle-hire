import java.util.Scanner;
public class Car extends Vehicle
{
    //instance variables
    private String bodyType;
    private int noOfDoors;
    private int noOfSeats;
    
    // constructor with parameters 
    public Car (String group, String bodyType, int noOfDoors, int noOfSeats)
    {
     this.bodyType = bodyType;
     this.noOfDoors = noOfDoors;
     this.noOfSeats = noOfSeats;
    }
    
    //no parameter constructor
    public Car ()
    {
     this.bodyType = bodyType;
     this.noOfDoors = noOfDoors;
     this.noOfSeats = noOfSeats;
    }
     
    public String getBodyType() 
     {
         return bodyType;
     }
     
    public int getNoOfDoors()
    {
        return noOfDoors; 
    }
    
    public int getNoOfSeats() 
    { 
        return noOfSeats; 
    }
    
    //read car additional data 
     public void readData(Scanner scanner) 
     {
        super.readData(scanner);
        this.bodyType = scanner.next();
        this.noOfDoors = scanner.nextInt();
        this.noOfSeats = scanner.nextInt();
    }
    
    //print car additional data 
    public void printDetails() 
    {
        super.printDetails(); 
        System.out.println("Body Type: " + bodyType);
        System.out.println("Number of Doors: " + noOfDoors);
        System.out.println("Number of Seats: " + noOfSeats);
    }
}

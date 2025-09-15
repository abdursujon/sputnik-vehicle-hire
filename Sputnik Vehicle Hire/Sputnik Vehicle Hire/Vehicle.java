import java.util.*;
public class Vehicle
{
    // instance variables
    private String group;
    private String vehID;
    private String regNo;
    private String make;
    private String model;
    private boolean airCon; 
    private double engineSize;
    private String fuelType; 
    private String gearbox;
    private String transmission;
    private int mileage;
    private String dateFirstRegistered;
    //parameter constructor, kept for using it on Test class
    public Vehicle(String group, String vehID, String regNo, String make, String model, boolean airCon, double engineSize,
                   String fuelType, String gearbox, String transmission, int mileage, String dateFirstRegistered) 
    {
        this.group = group;
        this.vehID = vehID;
        this.regNo = regNo;
        this.make = make;
        this.model = model;
        this.airCon = airCon;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.gearbox = gearbox;
        this.transmission = transmission;
        this.mileage = mileage;
        this.dateFirstRegistered = dateFirstRegistered;
    }
    
    //no parameter constructor 
    public Vehicle()
    {
        this.group = group;
        this.vehID = vehID;
        this.regNo = regNo;
        this.make = make;
        this.model = model;
        this.airCon = airCon;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.gearbox = gearbox;
        this.transmission = transmission;
        this.mileage = mileage;
        this.dateFirstRegistered = dateFirstRegistered;
    }
    
    //accessor methods
    public String getGroup()
    {
      return group;
    }
    
    public String getVehId()
    {
      return vehID;
    }
    
    public String getRegNo()
    {
      return regNo;
    }
    
    public String getMake()
    {
      return make;
    }
    
    public String getModel()
    { 
        return model; 
    }
    
    public boolean hasAirCon()
    {
        return airCon; 
    }
    
    public double getEngineSize() 
    { 
        return engineSize;
    }
    
    public String getFuelType()
    { 
        return fuelType;
    }
    
    public String getGearbox() 
    { 
        return gearbox; 
    }
    
    public String getTransmission() 
    { 
        return transmission; 
    }
    
    public int getMileage() 
    { 
        return mileage; 
    }
    
    public String getDateFirstRegistered() 
    { 
        return dateFirstRegistered;
    }
     
    //print vehicles data to terminal
    public void printDetails()
    {
        System.out.println(make + " " + model + " " + "Group: " + group + " Vehicle Id: " + vehID);
        System.out.println("Air conditioning/Climate Control: " + (airCon ? "Yes" : "No"));
        System.out.println("Engine Size: " + engineSize + " Fuel: " + fuelType);
        System.out.println("Gearbox: " + gearbox + " Transmission: " + transmission);
        System.out.println("Mileage: " + mileage + " Date first registered: " + dateFirstRegistered);
    }
    
    //read txt data using Scanner object
    public void readData(Scanner scanner) 
    {
        this.group = scanner.next();
        this.vehID = scanner.next();
        this.regNo = scanner.next();
        this.make = scanner.next();
        this.model = scanner.next();
        this.airCon = scanner.next().equalsIgnoreCase("Yes");
        this.engineSize = scanner.nextDouble();
        this.fuelType = scanner.next();
        this.gearbox = scanner.next();
        this.transmission = scanner.next();
        this.mileage = scanner.nextInt();
        this.dateFirstRegistered = scanner.next();
    }
}

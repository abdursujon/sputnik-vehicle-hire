import java.util.Scanner;

public class Van extends Commercial {
    //instance variables 
    private double loadVolume;
    private boolean slidingSideDoor;
    
    //constructor with parameters
    public Van(double loadVolume,boolean slidingSideDoor)
    {
        this.loadVolume = loadVolume;
        this.slidingSideDoor = slidingSideDoor;
    }
    
    public Van()
    {
        this.loadVolume = loadVolume;
        this.slidingSideDoor = slidingSideDoor;
    }
    
    //get methods 
    public double getLoadVolume()
    { 
        return loadVolume; 
    }
    
    public boolean hasSlidingSideDoor() 
    {
        return slidingSideDoor;
    }
    
    //override the read data of super class calling the readData using keyword super
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        this.loadVolume = scanner.nextDouble();
        this.slidingSideDoor = scanner.next().equalsIgnoreCase("Yes");
    }
    
    //over ride the print details of the vehicle with the additional details of van 
      public void printDetails() {
        super.printDetails();
        System.out.println("Load Volume: " + loadVolume);
        System.out.println("Sliding Side Door: " + (slidingSideDoor ? "Yes" : "No"));
    }
}

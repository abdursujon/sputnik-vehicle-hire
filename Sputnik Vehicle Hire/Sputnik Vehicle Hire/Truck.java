import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Truck extends Commercial {
    //instance variables
    private List<String> attributes;
    
    // constructor with parameters 
    public Truck(List<String> attributes) 
    {
        this.attributes = attributes;
    }
    
    //no parameters constructor
     public Truck() 
    {
        attributes = new ArrayList<>();
    }
    
    public List<String> getAttributes()
    { 
        return attributes;
    }
    
    //override the txt file with the additional attributes of truck details
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        while (scanner.hasNext())
        {
            attributes.add(scanner.next());
        }
    }
    
    //over ride the print details with the additional features details of the truck 
     public void printDetails() {
        super.printDetails();
        //as we expect sometimes to have more than one attributes(features) of car, string.join make sure to connect them together with comma seperated maner.
        System.out.println("Attributes: " + String.join(", ", attributes));
    }
}
import java.util.*;
import java.io.*;
import java.awt.*; 
import java.util.ArrayList;
import java.util.Random;
public class ReservationSystem
{
    /**
     *  Note: These are ArrayList which were used in an earlier stage in development to store vehicle and customer objects.
     *  private ArrayList<Vehicle>vehicleList;
        private ArrayList<Customer>customerList;
    */
    private Map<String, Vehicle> vehicleMap;
    private Map<String, Customer> customerMap;
    private Random randomNumberGenerator;
    private Frame myFrame;
    //hashMap to help create a unique id generator for customer 
    private HashMap<String, Customer> customerIDMap = new HashMap<>();
    private Map<String, VehicleReservation> vehicleReservationMap;
    private HashMap<String, VehicleReservation> reservationNoMap = new HashMap<>();
    private Diary diary;
    //constructor of the class ReservationSystem
    public ReservationSystem() 
     {
      /**
       * Earlier stage of development: ArrayList initialisation for vehicle and customer.
       * vehicleList = new ArrayList<Vehicle>();
         customerList = new ArrayList<Customer>();
      */
      vehicleMap = new HashMap<>();
      customerMap = new HashMap<>();
      myFrame = new Frame();
      randomNumberGenerator = new Random();
      vehicleReservationMap = new HashMap<>();
      diary = new Diary();
     }
     
    /**
     *  Earlier stage of development: The method to store vehicle 
     *  
     * public void storeVehicle(Vehicle vehicle) 
     * {
        vehicleList.add(vehicle);
       }
     */
    
    //Adds vehicle to the reservation system using map
    public void storeVehicle(Vehicle vehicle) 
    {
        vehicleMap.put(vehicle.getVehId(), vehicle);
    }
    
    /** Earlier stage of development: The method to print vehicle details
     * public void printAllVehicles() 
       {
           for (Vehicle vehicle : vehicleList) 
            {
                vehicle.printDetails();
            }
        }
     */ 
    
    //print all vehicles using map
    public void printAllVehicles() 
    {
        for  (Vehicle vehicle : vehicleMap.values()) 
        {
            vehicle.printDetails();
        }
    } 
    
    // read vehicle method to read data from a text file
    public void readVehicleData() {
        //Select a file using file dialog box 
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true); 
        String filename = fileBox.getFile();
        String directory = fileBox.getDirectory();
        //if file dialog get canceled, print no file selected 
        if (filename == null) 
        {
            System.out.println("No file selected, please try again.");
        }
        File file = new File(directory + filename);
        String typeOfData = "";
        try (Scanner scanner = new Scanner(file)) 
        {
            while (scanner.hasNextLine()) {
                //scan each line of the txt file and get rid of trailing and leading space using trim
                String lineOfText = scanner.nextLine().trim();
                //ignore empty lines
                if (lineOfText.isEmpty() )
                {
                    continue;
                }
                //ignore lines start with comment // 
                else if (lineOfText.startsWith("//"))
                {
                    continue;
                }
                //check if the line stats with [
                else if (lineOfText.startsWith("["))
                {
                    if (lineOfText.equalsIgnoreCase ("[Car Data]"))
                    {
                        typeOfData = "Car";
                    }
                    else if (lineOfText.equalsIgnoreCase ("[Van Data]"))
                    {
                        typeOfData = "Van";
                    }
                    else if (lineOfText.equalsIgnoreCase ("[Truck Data]"))
                    {
                        typeOfData = "Truck";
                    }
                    continue;
                }
                else 
                {
                //lineScanner 2 look for space and comma inside the line of the txt and use delimiter to ignore them
                Scanner lineScanner2 = new Scanner(lineOfText);
                lineScanner2.useDelimiter("\\s*,\\s*");
                Vehicle vehicle = (Vehicle) null;
                 if (typeOfData.equals ("Car"))
                  {
                  vehicle = new Car();
                  }
                 else if (typeOfData.equals ("Van"))
                  {
                  vehicle = new Van();
                  }
                 else if (typeOfData.equals ("Truck"))
                  {
                  vehicle = new Truck();
                  }
                //lineScanner2 using readData instead of having to redefine all 12 fields here
                vehicle.readData(lineScanner2);
                storeVehicle(vehicle);
                lineScanner2.close();
                }
            }
            //print all the vehicles data when readVehicleData is called
            printAllVehicles();
        } 
       //catching exceptions
       catch(FileNotFoundException ex)
        {
        System.err.println("\n\n*** FileNotFoundException ***");
        System.err.println("Data file <" + filename + "> does NOT exist");
        System.err.println("Please try again");
        }
       catch(IOException ex)
        {
          System.err.println("\n\n*** IOException ***");
          ex.printStackTrace();
          System.err.println("\n*** Unexpected error -- program aborted ***");
          System.exit(1);
        }
    }
    

    /** Earlier stage of development: Using ArrayList to store customer data 
     * public void storeCustomer(Customer customer) 
     * {
        if (customer.getCustomerID().equals("unknown"))
            {
            //here the random number length could be selected to any size
            customer.setCustomerID(generateCustomerID("AB-",6));
            }
          customerList.add(customer);
       }
     */
    //store customer using map
    
    public void storeCustomer(Customer customer) 
    {
        if (customer.getCustomerID().equals("unknown")) {
            //generate a random id for the customer starts with AB-
            customer.setCustomerID(generateCustomerID("AB-", 6));
        }
        customerMap.put(customer.getCustomerID(), customer);
    }
  
    /** Earlier stage of development: Use array list to print all customer data 
     * public void printAllCustomers()
        {
          for (Customer customer : customerList) 
          {
            customer.printDetails();
          }
        }
    */
    //print all customer using map
    public void printAllCustomers()
    {
        for (Customer customer : customerMap.values()) 
        {
            customer.printDetails();
        }
    }
    
    //read customer details from txt file
    public void readCustomerData() {
        //read a text file using fileDialog
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true); 
        String filename = fileBox.getFile();
        String directory = fileBox.getDirectory();
        //if nothing is selected show relevant error message 
        if (filename == null) {
            System.out.println("You did not select any file, please try again.");
        }
        File file = new File(directory , filename);
        try (Scanner scanner = new Scanner(file)) 
        {
            while (scanner.hasNextLine()) {
                //scan each line of the txt file and get rid of trailing and leading space using trim
                String lineOfText = scanner.nextLine().trim();
                //ignore empty lines 
                if (lineOfText.isEmpty() )
                {
                    continue;
                }
                else if (lineOfText.startsWith("//"))
                {
                    continue;
                }
               
                else 
                {
                Scanner lineScanner2 = new Scanner(lineOfText);
                
                lineScanner2.useDelimiter("\\s*,\\s*");
                Customer customer = new Customer();
                //lineScanner2 using readData instead of having to redefine all 12 fields here
                customer.readDataCustomer(lineScanner2);
                storeCustomer(customer);
                lineScanner2.close();
                }
            }
            //Print all the vehicles data when readVehicleData is called
            printAllCustomers();
        } 
       //catching exceptions
       catch(FileNotFoundException ex)
        {
        System.err.println("\n\n*** FileNotFoundException ***");
        System.err.println("Data file <" + filename + "> does NOT exist");
        System.err.println("Please try again");
        }
       catch(IOException ex)
        {
          System.err.println("\n\n*** IOException ***");
          ex.printStackTrace();
          System.err.println("\n*** Unexpected error -- program aborted ***");
          System.exit(1);
        } 
    }
    
    //writeCustomer data to a txt file
     public void writeCustomerData () 
     {
      FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.SAVE);
      fileBox.setVisible(true); 
      String filename = fileBox.getFile();
      String directory = fileBox.getDirectory();
      if (filename == null)
      {
            System.out.println("You did not select a file, please try again.");
      }
      File file = new File(directory, filename);  
      try (PrintWriter pWriter = new PrintWriter(file))
      {
       for(Customer customer: customerMap.values())
       {
         //Get all customer details from customer class
         String lineOfOutput = customer.getCustomerID() + ", " + customer.getSurname()+ ", " + customer.getFirstName() + ", " + customer.getOtherInitials()+ ", " + customer.getTitle();
         //write them to the file
         pWriter.println(lineOfOutput);
       }
       pWriter.close();
      } 
      //catching exceptions
       catch(FileNotFoundException ex)
        {
        System.err.println("\n\n*** FileNotFoundException ***");
        System.err.println("Data file <" + filename + "> does NOT exist");
        System.err.println("Please try again");
        }
       catch(IOException ex)
        {
          System.err.println("\n\n*** IOException ***");
          ex.printStackTrace();
          System.err.println("\n*** Unexpected error -- program aborted ***");
          System.exit(1);
        }
    }
    
    //generate unique random id for customer 
    public String generateCustomerID (String idPrefix, int digitLength)
    {
        //finds the smallest int number within the range 
        int min = (int) Math.pow(10, digitLength - 1); 
        //finds the highest int number withing the range 
        int max = (int) Math.pow(10, digitLength) - 1;
        String generatedID;
        //the do while loop is implemented to loop through from min to max and generate id within the desired range specified 
        do
        {
            int randomNumber = randomNumberGenerator.nextInt(max - min + 1) + min;
            generatedID = idPrefix + randomNumber;
        }
        // Check if the id already exist othwerwise keep trying until unique id is generated
        while (customerIDMap.containsKey(generatedID)); 
        return generatedID;
    }
    
    //store vehicle reservation to the system
    public void storeVehicleReservation(VehicleReservation vehicleReservation) 
    {
        //generate a reservation no for customer
        vehicleReservation.setReservationNo(generateRerservationNo(6));
        vehicleReservationMap.put(vehicleReservation.getReservationNo(), vehicleReservation);
        //add reservation to diary as well
        diary.addReservation(vehicleReservation);
    }
    
    //print all reservation 
    public void printAllVehicleReservations()
    {
        for (VehicleReservation vehicleReservation : vehicleReservationMap.values()) {
            vehicleReservation.printDetails();
        }
    } 
    
    // generate random reservation number with padding 0
    public String generateRerservationNo(int length) 
    {
        //generate reservation number with leading fize 0
        return String.format("%05d", vehicleReservationMap.size()+1);
    }
    
    //get vehicle reservation method 
    public void getVehicleReservation()
    {
        VehicleReservation vehicleReservation = new VehicleReservation();
        System.out.println("RersavtionNo: " + vehicleReservation.getReservationNo());
        System.out.println("Vehicle ID: "+ vehicleReservation.getVehID());
        System.out.println("Customer ID: " + vehicleReservation.getCustomerId());
        System.out.println("Start Date: " + vehicleReservation.getStartDate());
        System.out.println("No of Days:  " + vehicleReservation.getNoOfDays());
    }
    
    //method to reserve a vehicle 
    public boolean makeVehicleReservation(String customerId, String vehID, String startDate, int noOfDays)
    {
       if(customerId == null || customerId.isEmpty())
       {
           System.out.println("Invalid customer ID, please try again.");
           return false;
       }
       
       if(vehID == null || vehID.isEmpty())
       {
           System.out.println("Vehicle is not avaiable, please try again.");
           return false;
       }
       
       if(startDate == null || startDate.isEmpty())
       {
           System.out.println("Please choose a start date, and try again.");
           return false;
       }
       
       if(noOfDays <0)
       {
           System.out.println("Please specify how many days you want to hire the vehicle for, and try agan.");
           return false;
       }
       VehicleReservation vehicleReservation = new VehicleReservation();
       Date start = vehicleReservation.getStartDate();
       Date currentDate = start;
       // Loop to check if a specified vehicle is aleady reserved
       for (int i = 0; i < noOfDays; i++) {
        VehicleReservation[] checkReservations = diary.getReservations(currentDate);
        if (checkReservations != null)
        {
            for (VehicleReservation reservation : checkReservations) 
            {
                //get vehicle id from vehicle first, then check if it's already taken by check reservation system class 
                if (reservation.getVehID().equals(vehID)) 
                {
                    System.out.println("Sorry this vehicle is already reserved, please choose a different date.");
                    return false;
                }
            }
        }
       }
       //below methods calling will set and store relevant data of reseravations
       vehicleReservation.setReservationNo(generateRerservationNo(6));
       vehicleReservation.setCustomerId(customerId);
       vehicleReservation.setVehID(vehID);
       Date date = DateUtil.convertStringToDate(startDate);
       vehicleReservation.setStartDate(date);
       vehicleReservation.setNoOfDays(noOfDays);
       storeVehicleReservation(vehicleReservation);
       return true;
    }
    
    //read reservation data
    public void readReservationData() {
        //read a text file using fileDialog which initially null
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true); 
        String filename = fileBox.getFile();
        String directory = fileBox.getDirectory();
        //if nothing is selected after opening the dialog, readVehicleData will return corresponded message
        if (filename == null) {
            System.out.println("You did not select any file.");
            return;
        }
        File file = new File(directory , filename);
      
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine()) {
                //scan each line of the txt file and get rid of trailing and leading space using trim
                String lineOfText = scanner.nextLine().trim();
                //ignoring empty, comment and line which starts with [
                if (lineOfText.isEmpty())
                {
                    continue;
                }
                else if (lineOfText.startsWith("//"))
                {
                    continue;
                }
               
                else 
                {
                //lineScanner 2 look for space and comma inside the line of the txt and use delimiter to get rid of them
                Scanner lineScanner2 = new Scanner(lineOfText);
                lineScanner2.useDelimiter("\\s*,\\s*");
                VehicleReservation vehicleReservation = new VehicleReservation();
                //lineScanner2 using readData instead of having to redefine all 12 fields here
                vehicleReservation.readDataVehicleReservation(lineScanner2);
                storeVehicleReservation(vehicleReservation);
                lineScanner2.close();
                }
            }
            //printAllVehicles calling will print all the vehicles data when readVehicleData is called
            printAllVehicleReservations();
        } 
       //catching exceptions
       catch(FileNotFoundException ex)
        {
        System.err.println("\n\n*** FileNotFoundException ***");
        System.err.println("Data file <" + filename + "> does NOT exist");
        System.err.println("Please try again");
        }
       catch(IOException ex)
        {
          System.err.println("\n\n*** IOException ***");
          ex.printStackTrace();
          System.err.println("\n*** Unexpected error -- program aborted ***");
          System.exit(1);
        } 
    }
    
    //write vehicle reservation data to a txt file
     public void writeVehicleReservationData () 
     {
      FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.SAVE);
      fileBox.setVisible(true); 
      String filename = fileBox.getFile();
      String directory = fileBox.getDirectory();
       if (filename == null) {
            System.out.println("You did not select a file.");
            return;
        }
      File file = new File(directory, filename);  
      try (PrintWriter pWriter = new PrintWriter(file))
      {
     
       for(VehicleReservation vehicleReservation: vehicleReservationMap.values())
       {
         String lineOfOutput = vehicleReservation.getReservationNo() + ", " +  vehicleReservation.getVehID()+ ", " +  vehicleReservation.getCustomerId()+ ", " +  vehicleReservation.getStartDate() + ", " +  vehicleReservation.getNoOfDays();
         pWriter.println(lineOfOutput);
       }
       pWriter.close();
      } 
      //catching exceptions
       catch(FileNotFoundException ex)
        {
        System.err.println("\n\n*** FileNotFoundException ***");
        System.err.println("Data file <" + filename + "> does NOT exist");
        System.err.println("Please try again");
        }
       catch(IOException ex)
        {
          System.err.println("\n\n*** IOException ***");
          ex.printStackTrace();
          System.err.println("\n*** Unexpected error -- program aborted ***");
          System.exit(1);
        }
    }
    
    //show diary entry for a specific period 
    public void printDiaryEntries( String startDateString, String endDateString) 
    {
        Date startDate = DateUtil.convertStringToDate(startDateString);
        Date endDate = DateUtil.convertStringToDate(endDateString);
        diary.printEntries(startDate, endDate);
    }
    
    //delete a reservation details from the system
    public void deleteVehicleReservation(String reservationNo) 
    {
        VehicleReservation deleteReservation = vehicleReservationMap.get(reservationNo);
        vehicleReservationMap.remove(reservationNo);
        diary.deleteReservation(deleteReservation);
    } 
}



import java.util.Date;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Write a description of class VehicleReservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VehicleReservation
{
    private String reservationNo;
    private String vehID;
    private String customerId;
    private Date startDate;
    private int noOfDays;
    
    //constructor with parameter
    public VehicleReservation(String reservationNo, String vehID, String customerId, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.vehID = vehID;
        this.customerId = customerId;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }
    
    // no parameter constructor
    public VehicleReservation()
    {
        this.reservationNo = reservationNo;
        this.vehID = vehID;
        this.customerId = customerId;
        this.startDate = new Date();
        this.noOfDays = noOfDays;
    }
    
    public String getReservationNo()
    {
        return reservationNo;
    }
    
    public void setReservationNo(String reservationNo)
    {
        this.reservationNo = reservationNo;
    }
    
    public String getVehID()
    {
        return vehID;
    }
    
    public void setVehID(String vehID)
    {
        this.vehID = vehID;
    }
    
    public String getCustomerId()
    {
        return customerId;
    }
    
    public void setCustomerId (String customerId)
    {
        this.customerId = customerId;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    
    public int getNoOfDays()
    {
        return noOfDays;
    }
    
    public void setNoOfDays(int noOfDays)
    {
        this.noOfDays = noOfDays;
    }
    
    //print details of the reservation 
    public void printDetails()
    {
        System.out.println("Reservation No: " + reservationNo);
        System.out.println("Vehicle ID: " + vehID);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Start Date: " +  DateUtil.convertDateToShortString(startDate));
        System.out.println("No of Days: " + noOfDays);
    }
    
    //read reservation data using scanner 
    public void readDataVehicleReservation(Scanner scanner) 
    {
        this.reservationNo = scanner.next();
        this.vehID = scanner.next();
        this.customerId = scanner.next();
        String startDate = scanner.next();
        DateUtil.convertStringToDate(startDate); 
        this.noOfDays = scanner.nextInt();
    }
    
    //customer write data method 
    public void writeData(PrintWriter writer)
    {
        writer.println(reservationNo + ", " + vehID + ", " + customerId + ", " + DateUtil.convertDateToShortString(startDate) + ", " + noOfDays);
    }
    
    public String toString()
    {
        return "Reservation No: " + reservationNo + ", Customer Id: " + customerId + ", Vehicle ID: " + vehID;
    }
}

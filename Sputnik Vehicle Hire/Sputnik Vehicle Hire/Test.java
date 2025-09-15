import java.util.Date;
public class Test {
    public Test() 
    { 
        //test 1: print the vehicle details 
        Vehicle vehicle = new Vehicle("AA", "TF-63403", "MJ09TFE", "Fiat", "Panda Active Eco", false, 22.9, "Unleaded", "five-speed manual", "FWD", 13584, "29-07-2009");
        vehicle.printDetails();
        //this print is to create a white line space for better readability 
        System.out.println();
        //test 2: store the above vehicle details on reservation system
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.storeVehicle(vehicle);
        
        //test 3: print all vehicles that are stored 
        reservationSystem.printAllVehicles();
        
        //test 4: read vehicledata which is passed using read vehicle method call
        reservationSystem.readVehicleData(); 
        System.out.println();
        
        //test 5: Car class print details 
        Car car = new Car("AA","Fiat",2,6);
        car.printDetails();
        System.out.println();
        
        //test 6: Commercial class print details
        Commercial commercial = new Commercial(4.99);
        commercial.printDetails();
        System.out.println();
        
        //test 7: Van class print details 
        Van van = new Van (99.0, false);
        van.printDetails();
        System.out.println();
        
        //test 8: Check if the random genarator working
        reservationSystem.generateCustomerID("AB-",6);
        
        /**Note: Test 9 is commented so it does not replace vehicle data, however example of; how to test 
         * the relevant method is below 
         * test 9: write customer and vehicle reservation data call
         * reservationSystem.writeCustomerData(); 
           reservationSystem.writeVehicleReservationData();
         */
        
        //test 10: create a dateUtil class object
        DateUtil dateUtil = new DateUtil();
        // Convert string dates to Date objects
        Date date1 = dateUtil.convertStringToDate("14-03-2025");
        Date date2 = dateUtil.convertStringToDate("20-03-2025");
        int days = dateUtil.daysBetween(date1, date2);
        //result output is 6
        System.out.println(days);
        
        //Test 11: make a reservation
        boolean makeReservationDetails = reservationSystem.makeVehicleReservation("05678", "TF-63403", "21-03-2025", 6);
        System.out.println(makeReservationDetails);
        System.out.println();

        // Test 12: Get all reservations and print them
        reservationSystem.printAllVehicleReservations();
    }
}

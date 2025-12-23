package com.sujon.vehiclehire.reservation;

import com.sujon.vehiclehire.booking.BookingDetails;
import com.sujon.vehiclehire.customer.Customer;
import com.sujon.vehiclehire.vehicles.Car;
import com.sujon.vehiclehire.vehicles.Truck;
import com.sujon.vehiclehire.vehicles.Van;
import com.sujon.vehiclehire.vehicles.Vehicle;

import java.util.*;
import java.io.*;
import java.awt.*;

public class ReservationSystem {

    private Map<String, Vehicle> vehicleMap;
    private Map<String, Customer> customerMap;
    private Map<String, BookingDetails> vehicleReservationMap;
    private Random randomNumberGenerator;
    private Frame myFrame;
    private Diary diary;

    public ReservationSystem() {
        vehicleMap = new HashMap<>();
        customerMap = new HashMap<>();
        vehicleReservationMap = new HashMap<>();
        randomNumberGenerator = new Random();
        myFrame = new Frame();
        diary = new Diary();
    }

    public void storeVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getVehId(), vehicle);
    }

    public void printAllVehicles() {
        for (Vehicle vehicle : vehicleMap.values()) {
            vehicle.printDetails();
        }
    }

    public void readVehicleData() {
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);

        if (fileBox.getFile() == null) return;

        File file = new File(fileBox.getDirectory(), fileBox.getFile());

        try (Scanner scanner = new Scanner(file)) {
            String type = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("//")) continue;

                if (line.startsWith("[")) {
                    type = line;
                    continue;
                }

                String[] p = line.split("\\s*,\\s*");

                Vehicle vehicle = null;
                String t = type.toLowerCase();

                if (t.contains("car")) vehicle = new Car();
                else if (t.contains("van")) vehicle = new Van();
                else if (t.contains("truck")) vehicle = new Truck();


                if (vehicle != null) {
                    vehicle.readData(p);
                    storeVehicle(vehicle);
                }
            }
            printAllVehicles();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void storeCustomer(Customer customer) {
        if (customer.getCustomerID().equals("unknown")) {
            customer.setCustomerID(generateCustomerID("AB-", 6));
        }
        customerMap.put(customer.getCustomerID(), customer);
    }

    public void printAllCustomers() {
        for (Customer customer : customerMap.values()) {
            customer.printDetails();
        }
    }

    public void readCustomerData() {
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);

        if (fileBox.getFile() == null) return;

        File file = new File(fileBox.getDirectory(), fileBox.getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("//")) continue;

                Scanner ls = new Scanner(line);
                ls.useDelimiter("\\s*,\\s*");

                Customer customer = new Customer();
                customer.readDataCustomer(ls);
                storeCustomer(customer);
                ls.close();
            }
            printAllCustomers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void writeCustomerData() {
        FileDialog fileBox = new FileDialog((Frame) null, "Save", FileDialog.SAVE);
        fileBox.setVisible(true);

        if (fileBox.getFile() == null) return;

        File file = new File(fileBox.getDirectory(), fileBox.getFile());

        try (PrintWriter pw = new PrintWriter(file)) {
            for (Customer c : customerMap.values()) {
                pw.println(c.getCustomerID() + ", " + c.getSurname() + ", " + c.getFirstName() + ", " + c.getOtherInitials() + ", " + c.getTitle());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String generateCustomerID(String prefix, int length) {
        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length) - 1;
        return prefix + (randomNumberGenerator.nextInt(max - min + 1) + min);
    }

    public void storeVehicleReservation(BookingDetails vr) {
        vr.setReservationNo(generateReservationNo());
        vehicleReservationMap.put(vr.getReservationNo(), vr);
        diary.addReservation(vr);
    }

    public void printAllVehicleReservations() {
        for (BookingDetails vr : vehicleReservationMap.values()) {
            vr.printDetails();
        }
    }

    public String generateReservationNo() {
        return String.format("R%03d", vehicleReservationMap.size() + 1);
    }

    public boolean makeVehicleReservation(String customerId, String vehID, String startDate, int noOfDays) {
        if (customerId == null || vehID == null || startDate == null || noOfDays <= 0) return false;

        Date start = DateUtil.convertStringToDate(startDate);
        Date current = start;

        for (int i = 0; i < noOfDays; i++) {
            BookingDetails[] reservations = diary.getReservations(current);
            if (reservations != null) {
                for (BookingDetails r : reservations) {
                    if (r.getVehID().equals(vehID)) return false;
                }
            }
        }

        BookingDetails vr = new BookingDetails();
        vr.setCustomerId(customerId);
        vr.setVehID(vehID);
        vr.setStartDate(start);
        vr.setNoOfDays(noOfDays);
        storeVehicleReservation(vr);
        return true;
    }

    public void readReservationData() {
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);

        if (fileBox.getFile() == null) return;

        File file = new File(fileBox.getDirectory(), fileBox.getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("//")) continue;

                Scanner ls = new Scanner(line);
                ls.useDelimiter("\\s+");

                BookingDetails vr = new BookingDetails();
                vr.readDataVehicleReservation(ls);
                storeVehicleReservation(vr);
                ls.close();
            }
            printAllVehicleReservations();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void writeVehicleReservationData() {
        FileDialog fileBox = new FileDialog((Frame) null, "Save", FileDialog.SAVE);
        fileBox.setVisible(true);

        if (fileBox.getFile() == null) return;

        File file = new File(fileBox.getDirectory(), fileBox.getFile());

        try (PrintWriter pw = new PrintWriter(file)) {
            for (BookingDetails vr : vehicleReservationMap.values()) {
                pw.println(vr.getReservationNo() + " " + vr.getVehID() + " " + vr.getCustomerId() + " " + DateUtil.convertDateToShortString(vr.getStartDate()) + " " + vr.getNoOfDays());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printDiaryEntries(String start, String end) {
        diary.printEntries(DateUtil.convertStringToDate(start), DateUtil.convertStringToDate(end));
    }

    public void deleteVehicleReservation(String reservationNo) {
        BookingDetails vr = vehicleReservationMap.remove(reservationNo);
        if (vr != null) diary.deleteReservation(vr);
    }
}

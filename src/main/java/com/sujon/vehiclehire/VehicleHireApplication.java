package com.sujon.vehiclehire;

import com.sujon.vehiclehire.reservation.ReservationSystem;
import com.sujon.vehiclehire.vehicles.Car;
import com.sujon.vehiclehire.vehicles.Commercial;
import com.sujon.vehiclehire.vehicles.Van;

import java.io.InputStream;
import java.util.Scanner;

public class VehicleHireApplication {
    public static void main(String[] args) {

        Scanner menuScanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        System.out.println("Choose:");
        System.out.println("1 = Car");
        System.out.println("2 = Truck");
        System.out.println("3 = Van");
        System.out.println("4 = Vehicles");
        System.out.println("5 = Customers");
        System.out.println("6 = Reservations");
        System.out.println("7 = All");

        int choice = menuScanner.nextInt();

        switch (choice) {

            case 1 -> {
                InputStream is = VehicleHireApplication.class
                        .getClassLoader()
                        .getResourceAsStream("car.txt");

                if (is == null) throw new RuntimeException("car.txt not found");

                try (Scanner fileScanner = new Scanner(is)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine().trim();
                        if (line.isEmpty() || line.startsWith("//")) continue;

                        String[] p = line.split("\\s*,\\s*");

                        Car car = new Car();
                        car.readData(p);
                        car.printDetails();
                        System.out.println();
                    }
                }
            }



            case 2 -> {
                InputStream is = VehicleHireApplication.class
                        .getClassLoader()
                        .getResourceAsStream("commercial.txt");

                if (is == null) throw new RuntimeException("commercial.txt not found");

                try (Scanner fileScanner = new Scanner(is)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine().trim();
                        if (line.isEmpty() || line.startsWith("//")) continue;

                        String[] p = line.split("\\s*,\\s*");

                        Commercial commercial = new Commercial();
                        commercial.readData(p);
                        commercial.printDetails();
                        System.out.println();
                    }
                }
            }

            case 3 -> {
                InputStream is = VehicleHireApplication.class
                        .getClassLoader()
                        .getResourceAsStream("van.txt");

                if (is == null) throw new RuntimeException("van.txt not found");

                try (Scanner fileScanner = new Scanner(is)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine().trim();
                        if (line.isEmpty() || line.startsWith("//")) continue;

                        String[] p = line.split("\\s*,\\s*");

                        Van van= new Van();
                        van.readData(p);
                        van.printDetails();
                        System.out.println();
                    }
                }
            }

            case 4 -> reservationSystem.readVehicleData();
            case 5 -> reservationSystem.readCustomerData();
            case 6 -> reservationSystem.readReservationData();

            case 7 -> {
                reservationSystem.readVehicleData();
                reservationSystem.readCustomerData();
                reservationSystem.readReservationData();
            }
        }
    }

}

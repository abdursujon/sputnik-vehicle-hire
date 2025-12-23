package com.sujon.vehiclehire.test;

import com.sujon.vehiclehire.booking.BookingDetails;
import java.io.InputStream;
import java.util.Scanner;

public class VehicleReservationTest {
    public static void main(String[] args) {
        InputStream is = VehicleReservationTest.class
                .getClassLoader()
                .getResourceAsStream("reservation.txt");

        if (is == null) {
            throw new RuntimeException("reservation.txt not found");
        }

        Scanner fileScanner = new Scanner(is);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (line.isEmpty()) continue;

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("\\s*,\\s*");

            BookingDetails vr = new BookingDetails();
            vr.readDataVehicleReservation(lineScanner);
            vr.printDetails();

            lineScanner.close();
        }

        fileScanner.close();
    }
}

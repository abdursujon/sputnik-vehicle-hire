package com.sujon.vehiclehire.test;

import com.sujon.vehiclehire.vehicles.Car;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void readAllCarsFromFile() {
        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("car.txt");

        assertNotNull(is, "car.txt not found");

        List<Car> cars = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(is)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("//")) continue;

                String[] p = line.split("\\s*,\\s*");

                Car car = new Car();
                car.readData(p);
                cars.add(car);
            }
        }

        assertFalse(cars.isEmpty());

        for (Car car : cars) {
            car.printDetails();
            assertNotNull(car.getMake());
            assertNotNull(car.getModel());
            assertNotNull(car.getBodyType());
            assertTrue(car.getNoOfDoors() > 0);
            assertTrue(car.getNoOfSeats() > 0);
        }
    }
}

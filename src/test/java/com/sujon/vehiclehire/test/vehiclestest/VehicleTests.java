package com.sujon.vehiclehire.test.vehiclestest;

import com.sujon.vehiclehire.vehicles.Car;
import com.sujon.vehiclehire.vehicles.Commercial;
import com.sujon.vehiclehire.vehicles.Truck;
import com.sujon.vehiclehire.vehicles.Van;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTests {

    /**
     * Reads a CSV-style text file and applies a handler to each non-empty,
     * non-comment line to reduce test boilerplate.
     */
    private void readFile(
            String file,
            BiConsumer<String, String[]> handler
    ) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(file);
        assertNotNull(is, file + " not found");

        String section = null;

        try (Scanner scanner = new Scanner(is)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.startsWith("[") && line.endsWith("]")) {
                    section = line;
                    continue;
                }

                if (line.isEmpty() || line.startsWith("//")) continue;

                handler.accept(section, line.split("\\s*,\\s*", -1));
            }
        }
    }

    @Test
    void readAllVehicleTypesFromMixedFile() {
        List<Car> cars = new ArrayList<>();
        List<Van> vans = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();

        readFile("vehicle_data.txt", (section, p) -> {
            switch (section) {
                case "[main.Car data]" -> {
                    Car c = new Car();
                    c.readData(p);
                    cars.add(c);
                }
                case "[van data]" -> {
                    Van v = new Van();
                    v.readData(p);
                    vans.add(v);
                }
                case "[main.Truck data]" -> {
                    Truck t = new Truck();
                    t.readData(p);
                    trucks.add(t);
                }
            }
        });

        assertFalse(cars.isEmpty());
        assertFalse(vans.isEmpty());
        assertFalse(trucks.isEmpty());

        cars.forEach(Car::printDetails);
        vans.forEach(Van::printDetails);
        trucks.forEach(Truck::printDetails);
    }

    @Test
    void readCarsOnlyData() {
        List<Car> cars = new ArrayList<>();

        readFile("car.txt", (section, p) -> {
            Car c = new Car();
            c.readData(p);
            cars.add(c);
        });

        assertFalse(cars.isEmpty());
        cars.forEach(Car::printDetails);
    }

    @Test
    void readVansOnlyData() {
        List<Van> vans = new ArrayList<>();

        readFile("van.txt", (section, p) -> {
            Van v = new Van();
            v.readData(p);
            vans.add(v);
        });

        assertFalse(vans.isEmpty());
        vans.forEach(Van::printDetails);
    }

    @Test
    void readTrucksOnlyData() {
        List<Truck> trucks = new ArrayList<>();
        readFile("truck.txt",  (section, p) ->{
            Truck tk = new Truck();
            tk.readData(p);
            trucks.add(tk);
        });

        assertFalse(trucks.isEmpty());
        trucks.forEach(Commercial::printDetails);
    }

    @Test
    void readCommercialVehicleData() {
        List<Commercial> commercials = new ArrayList<>();

        readFile("commercial.txt",  (section, p) ->{
            Commercial cm = new Commercial();
            cm.readData(p);
            commercials.add(cm);
        });

        assertFalse(commercials.isEmpty());
        commercials.forEach(Commercial::printDetails);
    }

}

package com.sujon.vehiclehire.vehicles;

/**
 * Represents a commercial vehicle in the vehicle hire system.
 *
 * <p>A {@code Commercial} vehicle extends {@link Vehicle} by adding
 * payload capacity information, measured in kilograms.</p>
 *
 * <p>This class is intended as a base type for commercial vehicle
 * categories such as vans and trucks. Common commercial attributes
 * are parsed here, while subclasses are responsible for handling
 * their own additional fields.</p>
 *
 * <p>Vehicle data is typically loaded from a structured text file.
 * Standard vehicle fields are parsed by {@link Vehicle#readData(String[])},
 * and the commercial-specific payload field is parsed by this class.</p>
 */
public class Commercial extends Vehicle {

    private double payload;

    public Commercial(double payload) {
        this.payload = payload;
    }

    public Commercial() {
        this.payload = payload;
    }

    public double getPayload() {
        return payload;
    }

    @Override
    public void readData(String[] p) {
        super.readData(p);
        this.payload = Double.parseDouble(p[12].trim());
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("; Payload: " + payload + "kg");
        System.out.println();
    }
}

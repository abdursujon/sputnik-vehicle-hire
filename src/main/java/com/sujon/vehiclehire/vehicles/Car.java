package com.sujon.vehiclehire.vehicles;

/**
 * Represents a car available in the vehicle hire system.
 *
 * <p>A {@code Car} is a specific type of {@link Vehicle} with
 * car-specific characteristics such as body type, number of doors,
 * and seating capacity.</p>
 *
 * <p>Instances of this class are typically created by parsing a line
 * of vehicle data from an external text file. The first set of fields
 * are handled by {@link Vehicle#readData(String[])}, while the
 * car-specific fields are parsed and stored by this class.</p>
 *
 * <p>This class is used for passenger vehicles only and does not
 * represent commercial vehicles such as vans or trucks.</p>
 */
public class Car extends Vehicle {

    private String bodyType;
    private int noOfDoors;
    private int noOfSeats;

    public Car(String group, String bodyType, int noOfDoors, int noOfSeats) {
        this.bodyType = bodyType;
        this.noOfDoors = noOfDoors;
        this.noOfSeats = noOfSeats;
    }

    public Car() {}

    public String getBodyType() {
        return bodyType;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    @Override
    public void readData(String[] p) {
        super.readData(p);

        this.bodyType = p[12].trim();
        this.noOfDoors = Integer.parseInt(p[13].trim());
        this.noOfSeats = Integer.parseInt(p[14].trim());
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("""
                Body Type: %s
                Number of Doors: %s
                Number of Seats: %s
                """.formatted(
                bodyType,
                noOfDoors,
                noOfSeats)
        );
    }
}

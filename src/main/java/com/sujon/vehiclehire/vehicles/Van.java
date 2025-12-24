package com.sujon.vehiclehire.vehicles;

/**
 * Represents a van in the vehicle hire system.
 *
 * <p>A {@code Van} is a type of {@link Commercial} vehicle designed for
 * light commercial use. In addition to standard vehicle and payload
 * information, vans include load volume and sliding side door details.</p>
 *
 * <p>Van data is typically loaded from a structured text file. Common
 * vehicle fields and payload capacity are parsed by the superclass
 * hierarchy, while van-specific fields are parsed and stored by this
 * class.</p>
 *
 * <p>This class is suitable for delivery, trade, and utility vehicles
 * where cargo capacity and access features are important.</p>
 */
public class Van extends Commercial {

    private double loadVolume;
    private boolean slidingSideDoor;

    public Van(double loadVolume, boolean slidingSideDoor) {
        this.loadVolume = loadVolume;
        this.slidingSideDoor = slidingSideDoor;
    }

    public Van() {}

    public double getLoadVolume() {
        return loadVolume;
    }

    public boolean hasSlidingSideDoor() {
        return slidingSideDoor;
    }

    @Override
    public void readData(String[] p) {
        super.readData(p);
        this.loadVolume = Double.parseDouble(p[12].trim());
        this.slidingSideDoor = p[13].trim().equalsIgnoreCase("Yes");
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Load Volume: " + loadVolume);
        System.out.println("Sliding Side Door: " + (slidingSideDoor ? "Yes" : "No"));
        System.out.println();
    }
}

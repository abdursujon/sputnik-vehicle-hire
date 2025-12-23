package com.sujon.vehiclehire.vehicles;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a truck in the vehicle hire system.
 *
 * <p>A {@code Truck} is a type of {@link Commercial} vehicle that can
 * have multiple additional features or attributes such as body type,
 * tipping capability, tail-lift, or refrigeration.</p>
 *
 * <p>All standard vehicle fields and the payload capacity are parsed by
 * the superclass hierarchy. Any remaining fields in the input data line
 * are treated as truck-specific attributes and stored as a list of
 * descriptive strings.</p>
 *
 * <p>This flexible design allows trucks with varying configurations to
 * be represented without changing the class structure.</p>
 */
public class Truck extends Commercial {

    private List<String> attributes;

    public Truck(List<String> attributes) {
        this.attributes = attributes;
    }

    public Truck() {
        attributes = new ArrayList<>();
    }

    public List<String> getAttributes() {
        return attributes;
    }

    @Override
    public void readData(String[] p) {
        super.readData(p);

        for (int i = 12; i < p.length; i++) {
            attributes.add(p[i].trim());
        }
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Attributes: " + String.join(", ", attributes));
    }
}
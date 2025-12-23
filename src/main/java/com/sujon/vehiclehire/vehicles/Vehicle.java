package com.sujon.vehiclehire.vehicles;

/**
 * Represents a vehicle in the vehicle hire system.
 *
 * <p>{@code Vehicle} is the base class for all vehicle types, including
 * cars and commercial vehicles. It encapsulates common properties such
 * as identification details, manufacturer information, engine
 * specifications, transmission details, mileage, and registration
 * date.</p>
 *
 * <p>Vehicle objects are typically created by reading structured data
 * from an external text file. This class is responsible for parsing and
 * storing all fields that are common to every vehicle type. Subclasses
 * extend this behaviour to handle additional, type-specific data.</p>
 *
 * <p>This class also provides a standard formatted output of vehicle
 * details that can be reused and extended by subclasses.</p>
 */
public class Vehicle {

    private String group;
    private String vehID;
    private String regNo;
    private String make;
    private String model;
    private boolean airCon;
    private double engineSize;
    private String fuelType;
    private String gearbox;
    private String transmission;
    private int mileage;
    private String dateFirstRegistered;

    public Vehicle(String group, String vehID, String regNo, String make, String model, boolean airCon, double engineSize,
                   String fuelType, String gearbox, String transmission, int mileage, String dateFirstRegistered) {
        this.group = group;
        this.vehID = vehID;
        this.regNo = regNo;
        this.make = make;
        this.model = model;
        this.airCon = airCon;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.gearbox = gearbox;
        this.transmission = transmission;
        this.mileage = mileage;
        this.dateFirstRegistered = dateFirstRegistered;
    }

    public Vehicle() {}

    public String getGroup() {
        return group;
    }

    public String getVehId() {
        return vehID;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean hasAirCon() {
        return airCon;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getTransmission() {
        return transmission;
    }

    public int getMileage() {
        return mileage;
    }

    public String getDateFirstRegistered() {
        return dateFirstRegistered;
    }

    public void printDetails() {
        System.out.print("""
                Make: %s
                Model: %s
                Group: %s
                Vehicle Id: %s
                Air conditioning/Climate Control: %s
                Engine Size: %s
                Fuel type: %s
                Gearbox: %s
                Transmission: %s
                Mileage: %d
                Date first registered: %s
                """.formatted(
                make,
                model,
                group,
                vehID,
                airCon ? "Yes" : "No",
                engineSize,
                fuelType,
                gearbox,
                transmission,
                mileage,
                dateFirstRegistered)
        );
    }

    public void readData(String[] p) {
        this.group = p[0].trim();
        this.vehID = p[1].trim();
        this.regNo = p[2].trim();
        this.make = p[3].trim();
        this.model = p[4].trim();
        this.airCon = p[5].trim().equalsIgnoreCase("Yes");
        this.engineSize = Double.parseDouble(p[6].trim());
        this.fuelType = p[7].trim();
        this.gearbox = p[8].trim();
        this.transmission = p[9].trim();
        this.mileage = Integer.parseInt(p[10].trim());
        this.dateFirstRegistered = p[11].trim();
    }

}

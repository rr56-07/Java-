package encapspoly;

import java.util.ArrayList;
import java.util.List;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 2000;
    }

    public String getInsuranceDetails() {
        return "Car Insurance: ₹2000";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance: ₹500";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000; // Extra loading cost
    }

    public double calculateInsurance() {
        return 3000;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance: ₹3000";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR123", 1500, "POL12345"));
        vehicles.add(new Bike("BIKE456", 500, "POL54321"));
        vehicles.add(new Truck("TRUCK789", 2500, "POL67890"));

        int rentalDays = 3;

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Number   : " + v.getVehicleNumber());
            System.out.println("Vehicle Type     : " + v.getType());
            System.out.println("Rental Cost (" + rentalDays + " days): ₹" + v.calculateRentalCost(rentalDays));

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance Cost   : ₹" + ins.calculateInsurance());
                System.out.println(ins.getInsuranceDetails());
            }

            System.out.println("-------------------------------");
        }
    }
}

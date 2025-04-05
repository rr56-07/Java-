package encapspoly;
import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Unknown";
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/KM: ₹" + ratePerKm;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50;
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20;
    }
}

public class RideHailingApp {
    public static void processRides(List<Vehicle> vehicles, double distance) {
        for (Vehicle v : vehicles) {
            v.updateLocation("Downtown");
            System.out.println(v.getVehicleDetails());
            System.out.println("Current Location: " + v.getCurrentLocation());
            System.out.println("Fare for " + distance + " KM: ₹" + v.calculateFare(distance));
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        rides.add(new Car("CAR101", "Ravi", 15));
        rides.add(new Bike("BIKE202", "Kiran", 5));
        rides.add(new Auto("AUTO303", "Rahul", 8));

        processRides(rides, 10);
    }
}

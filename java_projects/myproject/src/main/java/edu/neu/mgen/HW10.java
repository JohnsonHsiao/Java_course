package edu.neu.mgen;

public class HW10 {
    public static void main(String[] args) {
        // instantiate objects
        Car car = new Car("Toyota", 150, 4);
        Motorbike motorbike = new Motorbike("Harley Davidson", 120, false);
        Aircraft aircraft = new Aircraft("Boeing 747", 900, 35000);
        Ship ship = new Ship("Titanic", 40, 52000);

        // display information and call methods
        car.displayInfo();
        car.start();
        car.stop();
        car.displayCarDetails();

        System.out.println();

        motorbike.displayInfo();
        motorbike.start();
        motorbike.stop();
        motorbike.displayMotorbikeDetails();

        System.out.println();

        aircraft.displayInfo();
        aircraft.start();
        aircraft.stop();
        aircraft.displayAircraftDetails();

        System.out.println();

        ship.displayInfo();
        ship.start();
        ship.stop();
        ship.displayShipDetails();
    }
}
// Vehicle class
abstract class Vehicle {
    protected String name;
    protected double speed;

    public Vehicle(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    // abstract methods
    public abstract void start();
    public abstract void stop();

    // public methods
    public void displayInfo() {
        System.out.println("Vehicle: " + name);
        System.out.println("Speed: " + speed + " km/h");
    }
}

// Car class
class Car extends Vehicle {
    private int numDoors;

    public Car(String name, double speed, int numDoors) {
        super(name, speed);
        this.numDoors = numDoors;
    }

    @Override
    public void start() {
        System.out.println(name + " car starts with a key.");
    }

    @Override
    public void stop() {
        System.out.println(name + " car stops with brakes.");
    }

    public void displayCarDetails() {
        System.out.println("Number of Doors: " + numDoors);
    }
}

// Motorbike class
class Motorbike extends Vehicle {
    private boolean hasSidecar;

    public Motorbike(String name, double speed, boolean hasSidecar) {
        super(name, speed);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void start() {
        System.out.println(name + " motorbike starts with a kick or button.");
    }

    @Override
    public void stop() {
        System.out.println(name + " motorbike stops with hand and foot brakes.");
    }

    public void displayMotorbikeDetails() {
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

// Aircraft class
class Aircraft extends Vehicle {
    private double altitude;

    public Aircraft(String name, double speed, double altitude) {
        super(name, speed);
        this.altitude = altitude;
    }

    @Override
    public void start() {
        System.out.println(name + " aircraft starts with engine ignition.");
    }

    @Override
    public void stop() {
        System.out.println(name + " aircraft stops by landing and braking.");
    }

    public void displayAircraftDetails() {
        System.out.println("Maximum Altitude: " + altitude + " feet");
    }
}

// Ship class
class Ship extends Vehicle {
    private double displacement;

    public Ship(String name, double speed, double displacement) {
        super(name, speed);
        this.displacement = displacement;
    }

    @Override
    public void start() {
        System.out.println(name + " ship starts by activating the engine.");
    }

    @Override
    public void stop() {
        System.out.println(name + " ship stops by reversing thrust.");
    }

    public void displayShipDetails() {
        System.out.println("Displacement: " + displacement + " tons");
    }
}


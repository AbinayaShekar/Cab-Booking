package org.example.cabbooking.model;

public class Booking {
    private String customerName;
    private String destination;
    private String cabType;
    private double distance;
    private double fare;

    // Default constructor (required by Jackson)
    public Booking() {
    }

    // Constructor with fields
    public Booking(String customerName, String destination, String cabType, double distance, double fare) {
        this.customerName = customerName;
        this.destination = destination;
        this.cabType = cabType;
        this.distance = distance;
        this.fare = fare;
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}

package org.example.cabbooking.service;

import org.example.cabbooking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabBookingService {

    @Autowired
    private FareCalculationService fareCalculationService;

    private final List<Booking> bookings = new ArrayList<>();

    public void bookCab(String customerName, String destination, String cabType, double distance) {
        double fare = fareCalculationService.calculateFare(cabType, distance);
        Booking booking = new Booking(customerName, destination, cabType, distance, fare);
        bookings.add(booking);
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}

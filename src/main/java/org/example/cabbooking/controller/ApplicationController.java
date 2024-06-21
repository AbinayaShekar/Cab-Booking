package org.example.cabbooking.controller;

import org.example.cabbooking.model.Booking;
import org.example.cabbooking.service.CabBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    private final CabBookingService cabBookingService;

    @Autowired
    public ApplicationController(CabBookingService cabBookingService) {
        this.cabBookingService = cabBookingService;
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> bookCab(@RequestBody Booking booking) {
        cabBookingService.bookCab(booking.getCustomerName(), booking.getDestination(), booking.getCabType(), booking.getDistance());

        // Assuming you have a way to fetch the newly created booking or you can return the same booking object
        // You should adjust this part based on your actual service logic
        Booking createdBooking = booking; // Replace this with actual logic to retrieve created booking

        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }


    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = cabBookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}

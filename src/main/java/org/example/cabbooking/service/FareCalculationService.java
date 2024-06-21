package org.example.cabbooking.service;

import org.springframework.stereotype.Service;

@Service
public class FareCalculationService {

    public double calculateFare(String cabType, double distance) {
        double baseFare = 50.0;
        double farePerKm;

        switch (cabType.toLowerCase()) {
            case "suv":
                farePerKm = 15.0;
                break;
            case "hatchback":
                farePerKm = 8.0;
                break;
            case "sedan":
            default:
                farePerKm = 10.0;
                break;
        }

        return baseFare + (farePerKm * distance);
    }
}

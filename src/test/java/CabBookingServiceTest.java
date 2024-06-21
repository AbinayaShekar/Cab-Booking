import org.example.cabbooking.model.Booking;
import org.example.cabbooking.service.CabBookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CabBookingServiceTest {

    private CabBookingService cabBookingService;

    @BeforeEach
    public void setUp() {
        // Clear bookings before each test
        cabBookingService.getAllBookings().clear();
    }

    @Test
    public void testBookCab() {
        double distance = 10.0;
        cabBookingService.bookCab("John Doe", "Airport", "sedan", distance);
        List<Booking> bookings = cabBookingService.getAllBookings();

        Assertions.assertEquals(1, bookings.size());
        Booking booking = bookings.get(0);
        Assertions.assertEquals("John Doe", booking.getCustomerName());
        Assertions.assertEquals("Airport", booking.getDestination());
        Assertions.assertEquals("sedan", booking.getCabType());

        double expectedFare = 50.0 + (10.0 * distance); // base fare + (fare per km * distance)
        Assertions.assertEquals(expectedFare, booking.getFare());
    }

    @Test
    public void testMultipleCabs() {
        double distanceSedan = 10.0;
        double distanceSuv = 15.0;
        double distanceHatchback = 5.5;

        cabBookingService.bookCab("John Doe", "Airport", "sedan", distanceSedan);
        cabBookingService.bookCab("Jane Doe", "Mall", "suv", distanceSuv);
        cabBookingService.bookCab("John Smith", "Office", "hatchback", distanceHatchback);

        List<Booking> bookings = cabBookingService.getAllBookings();

        Assertions.assertEquals(3, bookings.size());

        Booking sedanBooking = bookings.get(0);
        Assertions.assertEquals(50.0 + (10.0 * distanceSedan), sedanBooking.getFare());

        Booking suvBooking = bookings.get(1);
        Assertions.assertEquals(50.0 + (15.0 * distanceSuv), suvBooking.getFare());

        Booking hatchbackBooking = bookings.get(2);
        Assertions.assertEquals(50.0 + (8.0 * distanceHatchback), hatchbackBooking.getFare());
    }
}

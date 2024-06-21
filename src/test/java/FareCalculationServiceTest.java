import org.example.cabbooking.service.FareCalculationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FareCalculationServiceTest {


    private FareCalculationService fareCalculationService;

    @Test
    public void testCalculateFare() {
        // Test for sedan cab type and 10.0 km distance
        double fare = fareCalculationService.calculateFare("sedan", 10.0);
        Assertions.assertEquals(150.0, fare); // Expected fare: base fare (50.0) + fare per km (10.0 * 10.0)

        // Test for SUV cab type and 15.0 km distance
        double fareSUV = fareCalculationService.calculateFare("suv", 15.0);
        Assertions.assertEquals(275.0, fareSUV); // Expected fare: base fare (50.0) + fare per km (15.0 * 15.0)

        // Test for hatchback cab type and 5.5 km distance
        double fareHatchback = fareCalculationService.calculateFare("hatchback", 5.5);
        Assertions.assertEquals(94.0, fareHatchback); // Expected fare: base fare (50.0) + fare per km (8.0 * 5.5)
    }
}

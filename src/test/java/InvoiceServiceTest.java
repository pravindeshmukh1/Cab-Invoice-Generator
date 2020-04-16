import cabrideinvoice.Ride;
import invoiceservices.InvoiceServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceServices invoiceService;

    @Before
    public void initSetup() {
        invoiceService = new InvoiceServices();
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateTotalFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnMinimumFare() {
        double distance = 0.4;
        int time = 0;
        double totalFare = invoiceService.calculateTotalFare(distance, time);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleDistanceAndTime_shouldReturnTotalFareSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        double totalFare = invoiceService.calculateTotalFare(rides);
        Assert.assertEquals(30, totalFare, 0.0);
    }
}

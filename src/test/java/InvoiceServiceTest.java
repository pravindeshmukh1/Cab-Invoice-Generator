import invoiceservices.InvoiceServices;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceServices invoiceService = new InvoiceServices();
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateTotalFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnMinimumFare() {
        InvoiceServices invoiceServices = new InvoiceServices();
        double distance = 0.4;
        int time = 0;
        double totalFare = invoiceServices.calculateTotalFare(distance, time);
        Assert.assertTrue(5.0 == totalFare);
    }
}

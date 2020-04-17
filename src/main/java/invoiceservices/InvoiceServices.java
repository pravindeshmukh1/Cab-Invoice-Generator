package invoiceservices;

import cabrideinvoice.InvoiceSummary;
import cabrideinvoice.Ride;

public class InvoiceServices {

    private static final double MINIMUM_FARE = 5;
    private int COST_PER_TIME = 1;
    private double MINIMUM_COST_PER_KILOMETER = 10;

    public double calculateTotalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateTotalFare(Ride[] rides) {
        int totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateTotalFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare, totalFare / rides.length);
    }
}

package invoiceservices;

import cabrideinvoice.InvoiceSummary;
import cabrideinvoice.Ride;
import cabrideinvoice.RideRepository;

public class InvoiceServices {

    private static final double MINIMUM_FARE = 5;
    private int COST_PER_TIME = 1;
    private double MINIMUM_COST_PER_KILOMETER = 10;
    private RideRepository rideRepository = new RideRepository();


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

    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateTotalFare(rideRepository.getRide(userId));
    }
}

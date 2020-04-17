package cabrideinvoice;

public class InvoiceSummary {
    private double averageFare;
    private double totalFare;
    private int numberOfRides;

    public InvoiceSummary(int numberOfRides, double totalFare,double averageFare ) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.averageFare, averageFare) == 0 &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                numberOfRides == that.numberOfRides;
    }
}

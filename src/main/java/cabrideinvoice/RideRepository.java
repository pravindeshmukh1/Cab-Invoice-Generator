package cabrideinvoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRide = new HashMap<>();

    public void addRide(String userId, Ride[] rides) {
        ArrayList<Ride> rideArrayList = this.userRide.get(userId);
        if (rideArrayList == null) {
            this.userRide.put(userId, new ArrayList<>(Arrays.asList(rides)));
        }
    }

    public Ride[] getRide(String userId) {
        return this.userRide.get(userId).toArray(new Ride[0]);
    }
}

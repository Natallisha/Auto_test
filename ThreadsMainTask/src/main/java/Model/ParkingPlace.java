package Model;

import java.util.concurrent.TimeUnit;

public class ParkingPlace {

    private int placeId;
    private static final int PARKING_TIME = 500;

    public ParkingPlace(int PlaceId) {
        this.placeId = PlaceId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void usingParkingPlace() {
        try {
            int randomNumber = (int) (Math.random() * PARKING_TIME);
            TimeUnit.SECONDS.sleep(randomNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


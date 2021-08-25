package Model;

import Exceptions.UnavailableParkingException;

public class Car extends Thread {

    private static final long WAITING_TIME_FOR_PARKING = 200L;
    private boolean isCarOnTheParkingPlace;
    private final Parking<ParkingPlace> pool;
    private final int id;


    public Car(Parking<ParkingPlace> pool, int id) {
        this.pool = pool;
        this.id = id;
    }

    public void run() {

        ParkingPlace parkingPlace = null;

        try {
            parkingPlace = pool.getParkingPlace(WAITING_TIME_FOR_PARKING);
            isCarOnTheParkingPlace = true;
            System.out.println("Car " + this.getId() + " took parking place " + parkingPlace.getPlaceId());
            parkingPlace.usingParkingPlace();

        } catch (UnavailableParkingException e) {
            System.out.println("Car " + this.getId() + " leave the queue" + e.getMessage());
        } finally {
            if (parkingPlace != null) {
                isCarOnTheParkingPlace = false;
                System.out.println("Car " + this.getId() + " leave the parking place " + parkingPlace.getPlaceId());
                pool.returnResources(parkingPlace);
            }
        }
    }

    public long getId() {
        return id;
    }
}

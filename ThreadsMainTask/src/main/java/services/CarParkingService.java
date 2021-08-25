package services;

import Model.Car;
import Model.Parking;
import Model.ParkingPlace;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class CarParkingService {

    public void tryToParkTheCar(int numberOfCarsInQueue, LinkedList parkingPlaces) {

        Parking<ParkingPlace> pool = new Parking<>(parkingPlaces);
        for (int i = 0; i < numberOfCarsInQueue; i++) {
            new Car(pool, i).start();
            System.out.println("Car " + i + " is in the queue");
            //
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

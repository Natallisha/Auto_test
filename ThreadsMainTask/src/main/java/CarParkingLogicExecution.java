import Model.ParkingPlace;
import services.CarParkingService;

import java.util.LinkedList;

public class CarParkingLogicExecution {

    public static void main(String[] args) {
        LinkedList<ParkingPlace> listOfPlaces = new LinkedList<>() {
            {
                this.add(new ParkingPlace(1));
                this.add(new ParkingPlace(2));
                this.add(new ParkingPlace(3));
                this.add(new ParkingPlace(4));
                this.add(new ParkingPlace(5));
            }
        };

        new CarParkingService().tryToParkTheCar(10, listOfPlaces);

    }
}

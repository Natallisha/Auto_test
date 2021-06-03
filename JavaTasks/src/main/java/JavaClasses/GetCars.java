package JavaClasses;

import java.util.Calendar;
import java.util.Locale;

public class GetCars<cars> {

    public GetCars() {
    }

    public GetCars(Car[] cars) {
        this.cars = cars;
    }

    Car[] cars = new Car[7];

    //Ввод  массива
    public void getArray() {
        cars[0] = new Car(1, "Audi", "A1", 2010, "red", 8000, "AA1100");
        cars[1] = new Car(2, "Volkswagen", "Polo", 2020, "silver", 15000, "AA1200");
        cars[2] = new Car(3, "Skoda", "Rapid", 2018, "black", 10000, "AB2200");
        cars[3] = new Car(4, "Volkswagen", "Touareg", 2005, "white", 8900, "MB3897");
        cars[4] = new Car(5, "Audi", "R8", 2008, "orange", 53000, "LA6789");
        cars[5] = new Car(6, "Volkswagen", "Polo", 2005, "green", 4500, "MB3525");
        cars[6] = new Car(7, "Skoda", "Octavia", 2010, "blue", 6900, "MK8272");
    }

    //вывод массива на консоль
    public void printCars() {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    //a) список автомобилей заданной марки;
    public void CertainBrand(String inputBrand) {
        int counter = 0;
        for (Car car : cars) {
            if (car.getBrand().toLowerCase(Locale.ROOT).equals(inputBrand.toLowerCase(Locale.ROOT))) {
                System.out.println(car + "\n");
                counter++;
            }
        }
        if (counter == 0) System.out.println("There is no such brand: " + inputBrand +"\n");

    }

    //b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
    public void CertainMarkYear(String model, int year) {
        int counter = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Car car : cars) {
            if (car.getModel().toLowerCase(Locale.ROOT).equals(model.toLowerCase(Locale.ROOT))
                    & (currentYear - car.getYearOfIssue()) >= year) {
                System.out.println(car +"\n");
                counter++;
            }
        }
        if (counter == 0) System.out.println("There is no such cars.\n");
    }

    //c) список автомобилей заданного года выпуска, цена которых больше указанной.
    public void CertainYearPrice(int year, double price) {
        int counter = 0;
        for (Car car : cars) {
            if (car.getYearOfIssue() == year & car.getPrice() > price) {
                System.out.println(car + "\n");
                counter++;
            }
        }
        if (counter == 0) System.out.println("No such auto.\n");
    }
}


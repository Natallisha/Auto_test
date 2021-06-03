package JavaClasses;
//Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(),
// getТип(), toString(). Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль. В каждом классе, обладающем информацией,
// должно быть объявлено несколько конструкторов.
//Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
//
//Создать массив объектов. Вывести:
//
//a) список автомобилей заданной марки;
//
//b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
//
//c) список автомобилей заданного года выпуска, цена которых больше указанной.


import java.util.Objects;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int yearOfIssue;
    private String color;
    private double price;
    private String registerNum;

    public Car(int id, String brand, String model, int yearOfIssue, String color, double price, String registerNum) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.color = color;
        this.price = price;
        this.registerNum = registerNum;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(String registerNum) {
        this.registerNum = registerNum;
    }

     public boolean equals(String o) {
        return this.brand.equals(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && yearOfIssue == car.yearOfIssue && Double.compare(car.price, price) == 0 && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(registerNum, car.registerNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, yearOfIssue, color, price, registerNum);
    }

    @Override
    public String toString() {
        return "Car " + id + ":" +
                " brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", registerNum='" + registerNum + '\''
                ;
    }
}



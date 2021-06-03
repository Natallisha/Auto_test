package SweetGift.KindsOfSweets;

import SweetGift.Sweet;
import SweetGift.TypeOfSweets.ChocolateType;


public class Chocolate extends Sweet {

    public Chocolate(String kindOfSweet, String name, int quantity, Double weightOfOne, Double calories, int percentOfSugar, ChocolateType type, double percentOfCocoa) {
        super(kindOfSweet, name, quantity, weightOfOne, calories, percentOfSugar);
        this.type = type;
        this.percentOfCocoa = percentOfCocoa;
    }

    ChocolateType type;
    double percentOfCocoa;

    public ChocolateType getType() {
        return type;
    }

    public double getPercentOfCocoa() {
        return percentOfCocoa;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "type=" + type +
                ", percentOfCocoa=" + percentOfCocoa +
                '}');
    }
}

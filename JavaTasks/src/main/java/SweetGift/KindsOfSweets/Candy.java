package SweetGift.KindsOfSweets;

import SweetGift.Sweet;
import SweetGift.TypeOfSweets.CandyType;

public class Candy extends Sweet {

    public Candy(String kindOfSweet, String name,  int quantity, Double weightOfOne, Double calories, int percentOfSugar,CandyType type) {
        super(kindOfSweet,
                name,
                quantity,
                weightOfOne,
                calories,
                percentOfSugar);
        this.type = type;
    }


    CandyType type;


    public CandyType getType() {
        return type;
    }

    public void setType(CandyType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + type +
                "}");
    }



}

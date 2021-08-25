package SweetGift.KindsOfSweets;

import SweetGift.Sweet;
import SweetGift.TypeOfSweets.CookieType;


public class Cookie extends Sweet {

    public Cookie(String kindOfSweet, String name, int quantity, Double weightOfOne, Double calories, int percentOfSugar, CookieType type) {
        super(kindOfSweet, name, quantity, weightOfOne, calories, percentOfSugar);
        this.type = type;
    }

    CookieType type;

    public CookieType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "type=" + type +
                        '}');
    }
}

package SweetGift;

import java.util.Objects;

public abstract class Sweet {

    public Sweet(String kindOfSweet, String name, int quantity, double weightOfOne, double calories, int percentOfSugar) {
        this.kindOfSweet = kindOfSweet;
        this.name = name;
        this.quantity = quantity;
        this.weightOfOne = weightOfOne;
        this.calories = calories;
        this.percentOfSugar = percentOfSugar;
    }

    public Sweet() {
    }

    String kindOfSweet;
    String name;
    int quantity;
    double weightOfOne;
    double calories;
    int percentOfSugar;

    public String getKindOfSweet() {
        return kindOfSweet;
    }

    public void setKindOfSweet(String kindOfSweet) {
        this.kindOfSweet = kindOfSweet;
    }

    public double getWeight() {
        return weightOfOne;
    }

    public void setWeight(Double weight) {
        this.weightOfOne = weight;
    }

    public double getCalories() { return calories; }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public int getPercentOfSugar() {
        return percentOfSugar;
    }

    public void setPercentOfSugar(int percentOfSugar) {
        this.percentOfSugar = percentOfSugar;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getWeightOfOne() {
        return weightOfOne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweet sweet = (Sweet) o;
        return quantity == sweet.quantity && percentOfSugar == sweet.percentOfSugar && Objects.equals(kindOfSweet, sweet.kindOfSweet) && Objects.equals(weightOfOne, sweet.weightOfOne) && Objects.equals(calories, sweet.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindOfSweet, quantity, weightOfOne, calories, percentOfSugar);
    }

    @Override
    public String toString() {
        return "\n" +"Sweet: {" +
                "kindOfSweet='" + kindOfSweet +
                ", name=" + name +
                ", quantity=" + quantity +
                ", weightOfOne=" + weightOfOne +
                ", calories=" + calories +
                ", percentOfSugar=" + percentOfSugar +
                "}";
    }
}

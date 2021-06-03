package SweetGift;
import SweetGift.KindsOfSweets.*;
import SweetGift.TypeOfSweets.*;
import java.util.*;

public class GiftSorter {
    private final List<? extends Sweet> sweets;


    public Double GetTotalWeightOfTheGift(){
        double totalWeight = 0.0;
        for (Sweet sweet: sweets){
            totalWeight += sweet.weightOfOne*sweet.quantity;
        }
        return totalWeight;
    }

    public Double GetWeightOfCandies(){
        double weightOfCandies = 0.0;
        for (Sweet sweet :sweets){
            if(sweet instanceof Candy) weightOfCandies += sweet.weightOfOne*sweet.quantity;
        }
        return weightOfCandies;
    }

    public Double GetWeightOfCookies(){
        double weightOfCookies = 0.0;
        for (Sweet sweet :sweets){
            if(sweet instanceof Cookie) weightOfCookies += sweet.weightOfOne*sweet.quantity;
        }
        return weightOfCookies;
    }

    public Double GetWeightOfChocolate(){
        double weightOfChocolate = 0.0;
        for (Sweet sweet :sweets){
            if(sweet instanceof Candy) weightOfChocolate += sweet.weightOfOne*sweet.quantity;
        }
        return weightOfChocolate;
    }

    public GiftSorter SortByPercentOfSugar(){
        Collections.sort(sweets, (Comparator<Sweet>) (o1, o2) -> o1.getPercentOfSugar() - o2.getPercentOfSugar() );
        return this;
    }

    public GiftSorter SortByKindOfSweet() {
        Collections.sort(sweets, (Comparator<Sweet>) (o1, o2) -> o1.getKindOfSweet().compareTo(o2.getKindOfSweet()));
        return this;
    }

    public GiftSorter SortByCalories(){
        Collections.sort(sweets, (Comparator<Sweet>) (o1, o2) -> Double.compare(o1.getCalories() ,o2.getCalories()));
        return this;
    }

    public GiftSorter SortByQuantity(){
        Collections.sort(sweets, (Comparator<Sweet>) (o1, o2)-> o1.getQuantity() - o2.getQuantity());
        return this;
    }

    public List<Candy> ShowOnlyCandies(){
        List <Candy> onlyCandies = new ArrayList<>();
        for (Sweet sweet: sweets) {
            if (sweet instanceof Candy) onlyCandies.add((Candy) sweet);
        }
        return onlyCandies;
    }

    public List<Cookie> ShowOnlyCookies(){
        List<Cookie> onlyCookies = new ArrayList<>();
        for (Sweet sweet: sweets){
            if (sweet instanceof Cookie) onlyCookies.add((Cookie) sweet);
        }

        return onlyCookies;
    }

    public List<Chocolate> ShowOnlyChocolate(){
        List<Chocolate> onlyChocolate = new ArrayList<>();
        for (Sweet sweet: sweets){
            if (sweet instanceof Chocolate) onlyChocolate.add((Chocolate) sweet);
        }

        return onlyChocolate;
    }

    public List<Chocolate> ShowChocolateWithPercentOfCocoaMoreTheGiven(int current){
        List<Chocolate> onlyChocolate = ShowOnlyChocolate();
        List<Chocolate> sortedByCocoaChocolate = new ArrayList<>();
        for (Chocolate chocolate: onlyChocolate){
            if (chocolate.getPercentOfCocoa()> current) sortedByCocoaChocolate.add(chocolate);
            }
        return sortedByCocoaChocolate;
        }

    public List<Sweet> ShowSweetsWithCaloriesMoreTheGiven(int current){
        List<Sweet> sortedByCalories = new ArrayList<>();
        for (Sweet sweet: sweets){
            if (sweet.getCalories() > current) sortedByCalories.add(sweet);
        }
        return sortedByCalories;
    }

    public List<Candy> ShowOnlyLollipop(){
        List <Candy> onlyCandies = ShowOnlyCandies();
        List <Candy> onlyLollipop = new ArrayList<>();
        for (Candy candy: onlyCandies){
            if (candy.getType() == CandyType.LOLLIPOP) onlyLollipop.add(candy);
        }
        return onlyLollipop;
    }


    @Override
    public String toString() {
        return sweets.toString();
    }

    public GiftSorter(List<? extends Sweet> sweets) {
        this.sweets = sweets;
    }
}

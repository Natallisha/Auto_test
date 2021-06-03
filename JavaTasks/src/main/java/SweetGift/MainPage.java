package SweetGift;

import SweetGift.KindsOfSweets.*;
import SweetGift.TypeOfSweets.*;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainPage {

    static List<Sweet> gift = Arrays.asList(
            new Candy("Candy","Alenka", 4, 15.0, 83.0, 70, CandyType.CHOCO_CANDY),
            new Cookie("Cookie", "Fantazy", 1, 100.0,430.0, 40, CookieType.SUGAR_COOKIES),
            new Candy("Candy", "Aeroflot", 6, 14.2, 56.4, 68, CandyType.WAFFLE_CANDY),
            new Chocolate ("Chocolate", "Komunarka", 1, 200.0, 900.0, 70, ChocolateType.MILK, 37.2),
            new Chocolate("Chocolate", "Mindal", 1, 100.0, 574.0, 40, ChocolateType.BITTER, 68.0),
            new Chocolate("Chocolate", "Lybimaya Alenka", 1, 20.0, 112.0, 73, ChocolateType.MILK, 31.1),
            new Candy("Candy", "Chupa Chups", 1, 12.0, 11.4, 88, CandyType.LOLLIPOP),
            new Cookie("Cookie", "Picnik", 1, 76.0, 364.8, 56, CookieType.WAFFLE),
            new Candy("Candy", "KitKat", 7, 16.4, 87.0, 69, CandyType.WAFFLE_CANDY),
            new Candy("Candy", "Znichka", 6, 15.3, 67.4, 67, CandyType.WAFFLE_CANDY),
            new Candy("Candy", "Mont Blank", 5, 23.6, 135.9,47, CandyType.CANDY_WITH_FONDANT)


);
    public static void main(String[] args) {
        GiftSorter giftSorter = new GiftSorter(gift);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Total weight of the gift: " + giftSorter.GetTotalWeightOfTheGift() + " g.");
        System.out.println("1. Show all sweets.\n" +
                "2. Show only candies and total weight of them.\n" +
                "3. Show only cookies and total weight of them.\n" +
                "4. Show only Chocolate and total weight of them.\n" +
                "5. Show only lollipops.\n" +
                "6. Sorted by percent of sugar.\n" +
                "7. Sorted by calories.\n" +
                "8. Sorted by quantity.\n" +
                "9. Sorted by kind of sweets.\n" +
                "10. Show the chocolate with percent of cocoa more than given.\n" +
                "11. Show the sweets with calories more than given.\n" +
                "12.Exit.");
        do{
            System.out.println("Choose the menu item that you wanted to see (1-12):");
        int userChoice = Integer.parseInt(scanner.nextLine());
        if (userChoice == 12) break;
            switch (userChoice) {
                case 1:
                    System.out.println(giftSorter);
                    break;
                case 2:
                    System.out.println(giftSorter.ShowOnlyCandies() + "\n" +
                            "Total weight of candies: " + giftSorter.GetWeightOfCandies() + "\n");
                    break;
                case 3:
                    System.out.println(giftSorter.ShowOnlyCookies() + "\n" +
                            "Total weight of cookies: " + giftSorter.GetWeightOfCookies()+ "\n");
                    break;
                case 4:
                    System.out.println(giftSorter.ShowOnlyChocolate() + "\n" +
                            "Total weight of chocolate: " + giftSorter.GetWeightOfChocolate()+ "\n");
                    break;
                case 5:
                    System.out.println(giftSorter.ShowOnlyLollipop()+ "\n");
                    break;
                case 6:
                    System.out.println(giftSorter.SortByPercentOfSugar()+ "\n");
                    break;
                case 7:
                    System.out.println(giftSorter.SortByCalories()+ "\n");
                    break;
                case 8:
                    System.out.println(giftSorter.SortByQuantity()+ "\n");
                    break;
                case 9:
                    System.out.println(giftSorter.SortByKindOfSweet()+ "\n");
                    break;
                case 10:
                    System.out.println("Enter the percent of cocoa: ");
                    int customPercent = Integer.parseInt(scanner.nextLine());
                    System.out.println(giftSorter.ShowChocolateWithPercentOfCocoaMoreTheGiven(customPercent)+ "\n");
                    break;
                case 11:
                    System.out.println("Enter the calories: ");
                    int customCalories = Integer.parseInt(scanner.nextLine());
                    System.out.println(giftSorter.ShowSweetsWithCaloriesMoreTheGiven(customCalories)+ "\n");
                    break;
                default:
                    System.out.println("You enter the wrong number or don't enter it at all.\n");
                    break;
            }
        } while (true) ;
    }
}

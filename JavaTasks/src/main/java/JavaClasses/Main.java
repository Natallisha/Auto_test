package JavaClasses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GetCars getCars = new GetCars();
        getCars.getArray();
        getCars.printCars();

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Choose number of sort (1-3):");
            System.out.println("1: List of cars of a given brand \n" +
                    "2: List of cars of given model and more then given use time \n" +
                    "3: List of cars of given year and more than given price \n" +
                    "4. Exit");
            System.out.print("Your choice: ");

            int userChoice = Integer.parseInt(in.nextLine());
            if (userChoice == 4) break;
            switch (userChoice) {
                case 1:
                    System.out.print("Input a brand to sort: ");
                    String customBrand = in.nextLine();
                    if (customBrand.equals("")) System.out.println("You don't enter any brand \n");
                    else getCars.CertainBrand(customBrand);
                    break;
                case 2:
                    try {
                        System.out.print("Input a model to sort: ");
                        String customModel = in.nextLine();
                        if (customModel.equals("")) System.out.println("You don't enter any model \n");
                        else {
                            System.out.print("Input the number of years the car has been in use: ");
                            int customYears = Integer.parseInt(in.nextLine());
                            getCars.CertainMarkYear(customModel, customYears);
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("You enter the wrong number or don't enter it at all.\n");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Input a year of issue: ");
                        int customYearIssue = Integer.parseInt(in.nextLine());
                        System.out.print("Input a price: ");
                        double customPrice = Double.parseDouble(in.nextLine());
                        getCars.CertainYearPrice(customYearIssue, customPrice);
                    } catch (NumberFormatException ex) {
                        System.out.println("You enter the wrong number or don't enter it at all.\n");
                    }
                    break;
                default:
                    System.out.println("You enter the wrong number or don't enter it at all.\n");
                    break;
            }
        } while (true);

    }
}

package JavaFundamentals;

import java.util.Scanner;

public class MainTask5 {
    public static void main(String[] args) {
        String [] month = {"January","February", "March", "April", "May", "June", "July", "August", "September",
                            "October", "November", "December"};
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of month: ");
        int inputNumber = in.nextInt();

        if (inputNumber <13 & inputNumber >0){
            System.out.println("The " + inputNumber + " month is " + month[inputNumber -1]);
        }
        else {
            System.out.println("Incorrect number of month");
        }

    }
}

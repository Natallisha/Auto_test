package JavaFundamentals;

import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number: ");
        int i = in.nextInt();
        int[] arr = new int[i];
        for (int y = 0; y<i; y++) {
            arr[y] = (int) (Math.random() * 35);
        }
        System.out.println("Output "+ i + " random numbers in a column:");
        for (int x:arr){
            System.out.println(x);
        }
        System.out.println("Output " +i + " random numbers in a string:");
        for (int x:arr){
            System.out.print(x + " ");
        }
    }
}

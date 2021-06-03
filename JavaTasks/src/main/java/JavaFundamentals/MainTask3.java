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
        for (int x:arr){
            System.out.println(x);
        }
        for (int x:arr){
            System.out.print(x + " ");
        }
    }
}

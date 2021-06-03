//2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

package JavaCollections;
import java.util.Scanner;
import java.util.Stack;

public class OptionalTask2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int inputNumber = Integer.parseInt(scanner.nextLine());
        while (inputNumber!=0){
            stack.push(inputNumber%10);
            inputNumber /= 10;
        }

        for (Integer stack1 : stack){
            System.out.print(stack1);
        }
    }
}

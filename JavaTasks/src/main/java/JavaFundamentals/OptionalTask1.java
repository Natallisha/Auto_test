package JavaFundamentals;

import java.util.*;

public class OptionalTask1 {

    //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    private static void elemLength(String[] array) { //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        int maxVal = 0;
        int minVal = array[0].length();
        String maxNum = null;
        String minNum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > maxVal) {
                maxVal = array[i].length();
                maxNum = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() < minVal) {
                minVal = array[i].length();
                minNum = array[i];
            }
        }
        System.out.println("Max number: " + maxNum + " Length: " + maxVal);
        System.out.println("Min number: " + minNum + " Length: " + minVal);
    }

    //2. Вывести числа в порядке возрастания (убывания) значений их длины.
    private static void sort(String[] array) {
        Arrays.sort(array, Comparator.comparing(String::length));
        System.out.print("Sort in ascending order: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    //3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
    private static void midLen(String[] array) {
        int sumElements = 0;
        int midSum;
        for (int i = 0; i < array.length; i++) {
            sumElements += array[i].length();
        }
        midSum = sumElements / array.length;
        for (String elem : array) {
            if (elem.length() > midSum)
                System.out.println("Length of the element " + elem + " is more than average. Length is " + elem.length());
        }
        for (String elem : array){
            if (elem.length() < midSum)   System.out.println("Length of the element "+elem+ " is less than average. Length is " + elem.length());

        }
    }

    //4. Подсчет различных элементов в числе
    private static int getArray(int element) {
        int[] array = new int[10];
        int num;
        if (element == 0) num = 1;
        while (element > 0) {
            num = element % 10;
            array[num]++;
            element /= 10;
        }
        int numDifElem = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) numDifElem++;

        }

        return numDifElem;
    }

    //5. Найти количество чисел, содержащих только четные цифры.
    private static int EvenNum(int element) {
        int[] array = new int[10];
        int a = 0;
        int num;
        int evenNum = 0;
        int CountEvenNum2 = 0;
        if (element == 0) num = 1;
        while (element > 0) {
            num = element % 10;
            array[num]++;
            if (num%2 == 0) evenNum++;
            a++;
            element /= 10;
        }
        if (evenNum == a) CountEvenNum2++;
        return CountEvenNum2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the desired number of values: ");
        String n = in.nextLine();
        int k = Integer.parseInt(n);
        String[] arr = new String[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Input " + i + " number: ");
            arr[i] = in.nextLine();
        }
        for (String x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        elemLength(arr);
        sort(arr);
        midLen(arr);
        int firstNumDif = getArray(Integer.parseInt(arr[0])); // 4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
        String outputElem = arr[0];
        for (int i = 0; i < k; i++) {
            int numDif = getArray(Integer.parseInt(arr[i]));
            if (numDif < firstNumDif) {
                firstNumDif = numDif;
                outputElem = arr[i];
            }
        }
        System.out.println("Number that contains minimal number of different elements: " + outputElem);

        int evenNum = 0;
        for (int i = 0; i < k; i++) {
            evenNum += EvenNum(Integer.parseInt(arr[i]));
        }
        System.out.println("Numbers containing only even digits: "+ evenNum);

    }
}



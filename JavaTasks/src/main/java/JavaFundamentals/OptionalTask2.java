package JavaFundamentals;
import java.util.Random;
import java.util.Scanner;

public class OptionalTask2 {

    public static int[][] getArray() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the desired number of values: ");
        String n = in.nextLine();
        System.out.print("Enter a number: ");
        String m = in.nextLine();
        int M = Integer.parseInt(m);
        int arraySize = Integer.parseInt(n);
        int[][] arr = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                Random random = new Random();
                int k = -M + random.nextInt(M-(-M)+1);
                arr[i][j] = k;
            }
        }
        return arr;
    }

    public static void printArray(int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("arr[" + i + "]" + "[" + j + "]" + ": " + arr[i][j]);
            }
        }
    }

    //1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
    public static int[][] asc(int[][]arr, int stringNum){
        boolean needIteration = true;
        while(needIteration) {
            needIteration = false;
            for (int j =0; j < arr.length-1; j++) {
                if (arr[stringNum][j] > arr[stringNum][j+1]) {
                    int temp = arr[stringNum][j];
                    arr[stringNum][j] = arr[stringNum][j+1];
                    arr[stringNum][j+1] = temp;
                    needIteration = true;
                }
            }
        }
        return arr;
    }

    //4. Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
    public static int[][] arrayWithoutMaxValue(int[][]arr) {
        int maxValue = 0;
        int maxI = 0;
        int maxJ = 0;
        int newI = 0;
        int newJ = 0;
        int[][] newArray = new int[arr.length - 1][arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != maxI) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (j != maxJ) {
                        newArray[newI][newJ] = arr[i][j];
                        newJ++;
                    }

                }
                newJ = 0;
                newI++;
            }
        }
        return newArray;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][]array = getArray();
        printArray(array);

        System.out.println("Array without max value:");
        printArray(arrayWithoutMaxValue(array));

        System.out.println("Enter a number of line to sort:");
        int lineNum = Integer.parseInt(in.nextLine())-1;
       try{
            array = asc(array, lineNum);
            printArray(array);
                }
       catch (ArrayIndexOutOfBoundsException ex) {
           System.out.println("You enter the wrong number of line!");
       }


    }


}

package JavaFundamentals;
public class MainTask2 {
    public static void main(String[] args) {
        System.out.println("Command-line arguments:");
            for (int i = args.length - 1; i>=0; i--) {
                System.out.println("arg [" + i + "]" + args[i]);
            }
    }
}


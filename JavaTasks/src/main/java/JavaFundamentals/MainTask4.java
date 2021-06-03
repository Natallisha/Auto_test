package JavaFundamentals;

public class MainTask4 {
    public static void main(String[] args) {
        int sum =0;
        int multi=1;

            for (int i = args.length - 1; i>=0; i--) {
                sum += Integer.parseInt(args[i]);
                multi *= Integer.parseInt(args[i]);
            }

        System.out.println(sum);
        System.out.println(multi);
    }
    }


import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {
        double[] numbers = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Double.parseDouble(args[i]);
        }
        
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) System.out.print(" ");
            if (numbers[i] == (long) numbers[i]) {
                System.out.print((long) numbers[i]);
            } else {
                System.out.print(numbers[i]);
            }
        }
        System.out.println();
    }
}

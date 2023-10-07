import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] counts = new int[10];

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            counts[digit]++;
        }

        counts[6] = (counts[6] + counts[9] + 1) / 2;
        counts[9] = 0;

        int maxCount = 0;
        for (int count : counts) {
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
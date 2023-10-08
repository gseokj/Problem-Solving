import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        
        for (int i = l; i <= 100; i++) {
            double x = n - i * (i + 1) / 2.0;
            if (x % i == 0) {
                x /= i;
                if (x >= -1) {
                    for (double j = x + 1; j <= x + i; j++) {
                        System.out.print((int)j+ " ");
                    }
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}

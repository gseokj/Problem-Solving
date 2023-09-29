import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            double dist = y - x; 
            double dpow = Math.sqrt(dist);
            int pow = (int) Math.round(Math.sqrt(dist)); 
            
            if (dpow <= pow) {
                System.out.println(pow * 2 - 1);
            } else {
                System.out.println(pow * 2);
            }
        }
    }
}
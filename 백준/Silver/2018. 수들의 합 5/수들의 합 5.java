import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        
        for (int i = 1; i * (i - 1) / 2 < n; i++) {
            if ((n - i * (i - 1) / 2) % i == 0) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}
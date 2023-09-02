import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int result = dfs(A, B);

        System.out.println(result);
    }

    public static int dfs(long A, long B) {
        int cnt = 0;
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                return -1;
            }
            cnt++;
        }
        return (A == B) ? cnt + 1 : -1;
    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = s.nextInt();
        }
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int gender = s.nextInt();
            int idx = s.nextInt();
            if (gender == 1) {
                for (int j = idx; j <= n; j += idx) {
                    a[j] = 1 - a[j];
                }
            } else if (gender== 2) {
                int l = idx - 1;
                int r = idx + 1;
                while (l >= 1 && r <= n && a[l] == a[r]) {
                    a[l] = 1 - a[l];
                    a[r] = 1 - a[r];
                    l--;
                    r++;
                }
                a[idx] = 1 - a[idx];
            }
        }
        
        //20개씩출력
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}

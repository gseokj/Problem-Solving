import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cnt = 0, ans = 0;

        for (int i = 1; i < m - 1; ) {
            if (str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                cnt++;
                if (cnt == n) {
                    if (str.charAt(i - (cnt * 2 - 1)) == 'I') {
                        ans++;
                    }
                    cnt--;
                }
                i += 2;
            } else {
                cnt = 0;
                i++;
            }
        }

        System.out.println(ans);
    }
}
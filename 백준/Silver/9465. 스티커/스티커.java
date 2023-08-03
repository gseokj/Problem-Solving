import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringTokenizer st2;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int x = 0; x < T; x++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[2][n];
			dp = new int[2][n];
			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[0][i]=Integer.parseInt(st.nextToken());
			    arr[1][i]=Integer.parseInt(st2.nextToken());
			}
			//초기작업세팅
			if (n >= 1) {
                dp[0][0] = arr[0][0];
                dp[1][0] = arr[1][0];
            }

            if (n >= 2) {
                dp[0][1] = arr[1][0] + arr[0][1];
                dp[1][1] = arr[0][0] + arr[1][1];
            }

			//max(dp[i-2]+arr[i],arr[i]+arr[i-1]+dp[i-3]
			for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
			}
			 System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
		}
	}

}

import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] arr;
	static int[] dp;
	static int[] res;
	static int T;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int x = 1; x <= T; x++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			res = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp, 1);
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (arr[j] < arr[i]) {
						dp[i] = Math.max(dp[j] + 1, dp[i]);
						res = Math.max(res,dp[i]);
					}
				}
			}
			System.out.println("#" + x + " " + res);
		}
	}

}
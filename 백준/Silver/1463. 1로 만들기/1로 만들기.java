import java.util.*;
public class Main {
	static int[] dp;
	static int N;
	public static void main(String[] args) {
		dp = new int[1000001];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		for (int i = 4; i < N + 1; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				int temp1 = Math.min(dp[i / 3], dp[i - 1]);
				int temp2 = Math.min(dp[i / 2], dp[i - 1]);
				dp[i] = Math.min(temp1, temp2)+1;
			}
			else if (i % 3 == 0)dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
			else if (i % 2 == 0)dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
			else dp[i] = dp[i - 1] + 1;
		}
		System.out.println(dp[N]);
	}
}
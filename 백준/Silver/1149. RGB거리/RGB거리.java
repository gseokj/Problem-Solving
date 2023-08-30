import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] RGB ;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGB = new int[3][N];
		dp = new int[3][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			RGB[0][i] =r;
			RGB[1][i] =g;
			RGB[2][i] =b;
		}
		dp[0][0] = RGB[0][0];
		dp[1][0] = RGB[1][0];
		dp[2][0] = RGB[2][0];
		
		for (int i = 1; i < N; i++) {
			dp[0][i] = Math.min(dp[1][i-1],dp[2][i-1])+RGB[0][i];
			dp[1][i] = Math.min(dp[0][i-1],dp[2][i-1])+RGB[1][i];
			dp[2][i] = Math.min(dp[0][i-1],dp[1][i-1])+RGB[2][i];
		}
		System.out.println(Math.min(dp[0][N-1], Math.min(dp[1][N-1],dp[2][N-1])));
	}

}

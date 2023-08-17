import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr,arr_rev;
	static int[] dp, dp_rev,sum;
	static int res;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
		}
		dp = new int[N];
		init(dp); // 1씩 더해주는 과정
		dp_rev = new int[N];
		init(dp_rev); // 1씩 더해주는 과정
		searchValue(dp,arr);
		arr_rev = reverse(arr);
		
		searchValue(dp_rev,arr_rev);
		dp_rev = reverse(dp_rev);
		sum = new int[N];
		sum = add(dp_rev,dp);
		System.out.println(res(sum));
		
	}


	private static int[] add(int[] arr1, int[] arr2) {
		int sum[] =new int[N];
		for (int i = 0; i < N; i++) {
			sum[i] = arr1[i] + arr2[i];
		}
		return sum;
		
	}


	private static void init(int[] dp) {
		for (int i = 0; i < N; i++) {
			dp[i] += 1;
		}
	}


	private static int[] reverse(int[] arr1) {
		int[] arr2 = new int[N]; 
		int cnt = 0;
		for (int i = N - 1; i > -1; i--) {
			arr2[cnt++] = arr1[i];
		}
		return arr2;

	}

	private static void searchValue(int[] dp, int[] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

		}

	}

	private static void print(int[] dp) {
		for (int i = 0; i < N; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
	}

	private static int res(int[] dp) {
		for (int i = 0; i < N; i++) {
			res = Math.max(res, dp[i]);
		}
		return res-1;
	}
}
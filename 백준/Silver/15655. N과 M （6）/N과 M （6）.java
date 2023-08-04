import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int[] P;
	static int[] Nums;
	static int N;
	static int R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		P = new int[N];
		Nums = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		combi(0,0);
	}
	static void combi(int cnt,int start) {
		if (cnt==R) {
			for (int n : Nums) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			Nums[cnt] = P[i];
			combi(cnt+1,i+1);
			Nums[cnt] = 0;
		}
	}

}
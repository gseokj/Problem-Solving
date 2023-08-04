import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] P;
	static int[] Nums;
	static int N;
	static int R;
	static boolean[] Visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		P = new int[N];
		Visited = new boolean[N];
		Nums = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		
		
		
		combi(0,0);
		System.out.println(sb.toString());
	}
	static void combi(int cnt,int start) {
		if (cnt==R) {
			for (int n : Nums) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			Visited[i] =true;
			Nums[cnt] = P[i];
			combi(cnt+1,i);
			Nums[cnt] = 0;
			Visited[i] =false;
			
			
		}
	}

}
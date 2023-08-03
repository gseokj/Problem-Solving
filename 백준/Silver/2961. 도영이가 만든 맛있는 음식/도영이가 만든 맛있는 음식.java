import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] sour;
	static int[] bit;
	static int n;
	static int r;
	static boolean[] visited;
	static int[] nums;
	static StringTokenizer st;
	static int res;
	static int s;
	static int b;
	static boolean flag=false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(br.readLine());
		sour = new int[n];
		bit = new int[n];
		res=Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] =Integer.parseInt(st.nextToken());
			bit[i] =Integer.parseInt(st.nextToken());
		}
		nums = new int[r];
		visited = new boolean[n];
		subset(0);
		System.out.println(res);
	}

	static void subset(int cnt) {
		if (cnt==n) {
			s=1;
			b=0;
			flag = false;
			for (int i = 0; i < n; i++) {
				if(visited[i]) {
					flag = true;
					s*=sour[i];
					b+=bit[i];
				}
			}
			if (flag)
			res= Math.min(Math.abs(s-b), res);
			return;
		}
			subset(cnt+1);
			visited[cnt] = true;
			subset(cnt+1);
			visited[cnt] = false;
			
		}
		
		

}
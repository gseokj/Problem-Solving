import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T,n,w;
	static int[] a;
	static int[] nums;
	static int max;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < T+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			a = new int[n];
			visited = new boolean[n];
			nums = new int[2];
			max=-1;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.print("#"+i+" ");
			System.out.println(max);
			
		}
	}
	static void dfs(int cnt,int tot) {
		if(cnt==2) {
			if (tot>w) return;
			max=Math.max(max, tot);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i]==true) continue;
			visited[i] = true;
			nums[cnt] = a[i];
			dfs(cnt+1,tot+a[i]);
			nums[cnt] = a[0];
			visited[i] = false;
			
			
			
		}
		
	}

}
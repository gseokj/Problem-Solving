import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int[] nums;
	static int n;
	static int r;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		p = new int[n];
		visited = new boolean[n];
		nums = new int[r];
		for (int i = 0; i < n; i++) {
			p[i] = i+1;
		}
		perm(0);
	}
	static void perm(int cnt) {
		if (cnt==r) {
			for (int num : nums) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i] == true) continue;
			visited[i] = true;
			nums[cnt] = p[i];
			perm(cnt+1);
			nums[cnt] = 0;
			visited[i] = false;
		}
	}

}

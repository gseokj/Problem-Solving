import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] dn = {-1,1,2};
	static Queue<int[]> que;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new ArrayDeque<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		que.offer(new int[] {N,0});
		visited[N] =true;
		
		
		System.out.println(bfs());
		
	}
	private static int bfs() {
		while(!que.isEmpty()) {
			int[] temp =que.poll();
			int t =temp[0];
			int cnt = temp[1];
			if (t==M) return cnt;
			for (int i = 0; i < 3; i++) {
				int nt = t;
				if (i==2) {
					nt = t*i;
				}else {
					nt = t+dn[i];
				}
				if(!check(nt)) continue;
				if(!visited[nt]) {
					visited[nt] = true;
					que.offer(new int[] {nt,cnt+1});
				}
			}
		}
		return -1;
	}
	private static boolean check(int t) {
		return t>=0 && t<=100000;
	}

}
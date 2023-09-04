import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int map[][];
	static int visited[][];
	static int wall,cnt;
	static Queue<int[]> que;
	static Queue<int[]> que2;
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	static boolean flag;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		wall = 0;
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j)-'0';
				if (map[i][j] == 0)
					wall++;
			}
		}
		
		visited = new int[N][N];
		que = new ArrayDeque<>();
		visited[0][0] =1;
		cnt = 0;
		flag = false;
		que.offer(new int[] {0,0});
		bfs(que);
//		print();
		System.out.println(cnt);
	}


	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		
	}


	private static void bfs(Queue<int[]> que) {
		Queue<int[]> que2 = new ArrayDeque<>();
		while(!que.isEmpty()) {
			int temp[] = que.poll();
			int r = temp[0];
			int c= temp[1];
			if(r==N-1 && c==N-1) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(!check(nr,nc) || visited[nr][nc] == 1) continue;
				if(map[nr][nc] == 1) {
					que.offer(new int[] {nr,nc});
					visited[nr][nc] = 1;
				}else if(map[nr][nc] == 0) {
					que2.offer(new int[] {nr,nc});
					visited[nr][nc] = 1;	
				}
			}
		}
		if(!que2.isEmpty()) bfs(que2);
		cnt++;
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}

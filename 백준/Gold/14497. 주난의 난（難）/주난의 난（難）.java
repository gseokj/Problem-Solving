import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static char map[][];
	static int visited[][];
	static int wall,cnt;
	static Queue<int[]> que;
	static Queue<int[]> que2;
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		br.readLine();
		map = new char[N][M];
		que = new ArrayDeque<>();
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == '*') {
					map[i][j] = '0';
					que.offer(new int[] {i,j});
					visited[i][j] =1;
				}
			}
		}
		
		
		cnt = 0;
		
		bfs(que);
		System.out.println(cnt);
	}


	private static void bfs(Queue<int[]> que) {
		Queue<int[]> que2 = new ArrayDeque<>();
		cnt++;
		while(!que.isEmpty()) {
			int temp[] = que.poll();
			int r = temp[0];
			int c= temp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(!check(nr,nc) || visited[nr][nc] == 1) continue;
				if(map[nr][nc] == '0') {
					que.offer(new int[] {nr,nc});
					visited[nr][nc] = 1;
				}else if(map[nr][nc] == '1') {
					que2.offer(new int[] {nr,nc});
					visited[nr][nc] = 1;	
				}else if(map[nr][nc] == '#') {
					return;
				}
			}
		}
		if(!que2.isEmpty()) bfs(que2);
		
	}


	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
}
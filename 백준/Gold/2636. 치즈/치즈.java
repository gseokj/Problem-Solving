import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] map_copy;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		map_copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// -----------------------------------
		int res = 0;
		int tot = N*M;
		int last=0;
		while (true) {
			int cnt = 0;
			int cur = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0){
						cur++;
						}
					}
				}
			if(tot==cur) break;
			last =0;
			res++;
			for (int i = 0; i < N; i++) {
				map_copy[i] = map[i].clone();
			}
			cnt++;
			bfs(0, 0, cnt + 1);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map_copy[i][j] == 2) {
						bfs2(i, j, 3);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if(map_copy[i][j]==3) {
						last++;
					}
				}

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != map_copy[i][j]) {
						map[i][j] = 0;
					}
				}
			}
		}
		System.out.println(res);
		System.out.println(last);
	}

	static void bfs(int r, int c, int g) {
		Queue<int[]> que = new ArrayDeque<int[]>();
		que.offer(new int[] { r, c });
		map_copy[r][c] = g;
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!check(nr, nc))
					continue;
				if (map_copy[nr][nc] == 0) {
					que.offer(new int[] { nr, nc });
					map_copy[nr][nc] = g;
				}
			}
		}
	}

	static void bfs2(int r, int c, int g) {
		Queue<int[]> que = new ArrayDeque<int[]>();
		que.offer(new int[] { r, c });
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!check(nr, nc))
					continue;
				if (map_copy[nr][nc] == 1) {
					map_copy[nr][nc] = g;
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
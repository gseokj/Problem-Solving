import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, res;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		for (int k = 0; k < 100; k++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > k && !visited[i][j]) {
						visited[i][j] = true;
						dfs(cnt++, k, i, j);
					}
				}
			}
			res = Math.max(cnt, res);
		}
		System.out.println(res);
	}

	private static void dfs(int cnt, int depth, int r, int c) {
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc))
				continue;
			if (!visited[nr][nc] && map[nr][nc] > depth) {
				visited[nr][nc] = true;
				dfs(cnt, depth, nr, nc);
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
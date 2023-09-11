import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int[][] visited;
	static int N, M, res;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					init();
					visited[i][j] = 1;
					bfs(i, j);
					maxCheck();
				}
			}
		}
		System.out.println(res);
	}

	private static void bfs(int rr, int cc) {
		Queue<int[]> que = new ArrayDeque();
		que.offer(new int[] { rr, cc });
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int r = temp[0];
			int c = temp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!check(nr, nc))
					continue;
				if (visited[nr][nc] == 0 && map[nr][nc] == 'L') {
					visited[nr][nc] = visited[r][c] + 1;
					que.offer(new int[] { nr, nc });
				}
			}

		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	private static void maxCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res = Math.max(visited[i][j] - 1, res);
			}
		}

	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = 0;
			}
		}

	}
}
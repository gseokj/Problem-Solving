import java.io.*;
import java.util.*;

public class Main {
	// 초기 작업세팅
	static int N, M;
	static int[][] map;
	static int[][] clone;
	// bfs
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static List<int[]> virus = new ArrayList();
	static boolean[][] visited;
	// 콤비
	static int X, R;
	static int[] wallCol = new int[3];
	static int[] P = { 1, 2, 3, 4, 5 };
	static int count;

	// result
	static int res;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		clone = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				clone[i][j] = a;
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		X = P.length;
		wallCol = new int[3]; // 벽
		res = 0;
		combi(0, 0);

		System.out.println(res);

	}

	private static int counting() {
		int tot = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					tot++;
			}
		}
		return tot;
	}

	private static void combi(int cnt, int start) {
		if (cnt == 3) {
			
			for (int a : wallCol) {
				int row = a / M;
				int col = a % M;
				map[row][col] = 1;
				
			}
			
			bfs();
			int tot = counting();
			res = Math.max(tot, res);
			return;
		}
		for (int i = start; i < M * N; i++) {
			init();
			int row = i/M;
			int col = i%M;
			if(map[row][col] == 2 || map[row][col] == 1) continue;
			wallCol[cnt] = i;
			combi(cnt + 1, i + 1);
			wallCol[cnt] = 0;

		}
	}

	private static void bfs() {
		Queue<int[]> que = new ArrayDeque();
		for (int[] v : virus) {
			int[] temp = v;
			visited[temp[0]][temp[1]] = true;
			que.offer(temp);
		}

		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int r = temp[0];
			int c = temp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!checked(nr, nc) || visited[nr][nc] || map[nr][nc] == 1)
					continue;
				visited[nr][nc] = true;
				map[nr][nc] = 2;
				que.offer(new int[] { nr, nc });
			}

		}
	}

	private static boolean checked(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
				map[i][j] = clone[i][j];
			}
		}
	}

}
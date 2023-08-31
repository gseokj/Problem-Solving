import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = { -1, 1, 0, 0, 2, -2, -1, -1, 1, 1, 2, 2 };
	static int dc[] = { 0, 0, -1, 1, -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[][][] visited;
	static int[][] map;
	static int N, M, K;
	static Queue<int[]> que;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine())+1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[K][N][M];
		que = new ArrayDeque();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit_Init(); // -1로 초기화 해준다. 
		bfs(); // bfs시작
//		print(2);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < K; i++) {
			if(visited[i][N-1][M-1]!=-1) res = Math.min(visited[i][N-1][M-1], res);
		}
		 if (res==Integer.MAX_VALUE) System.out.println(-1);
		 else {System.out.println(res-1);};
	}

	private static void bfs() {
		visited[0][0][0] = 1;
		que.offer(new int[] { 0, 0, 0 });
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int r = temp[0];
			int c = temp[1];
			int k = temp[2];
			for (int i = 0; i < 12; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (!check(nr, nc))
					continue;
				if (i <= 3 && visited[k][nr][nc] == -1) {
					que.offer(new int[] { nr, nc, k });
					visited[k][nr][nc] = visited[k][r][c] + 1;
				} else if (K > k + 1 && i > 3 && visited[k + 1][nr][nc] == -1) {
					visited[k + 1][nr][nc] = visited[k][r][c] + 1;
					que.offer(new int[] { nr, nc, k + 1 });
				}

			}

		}
	}

	private static void visit_Init() {
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(visited[i][j], -1);
			}
		}
	}

	private static void print(int k) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[k][i][j] + "|");
			}
			System.out.println();
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M && map[r][c] == 0;
	}

}
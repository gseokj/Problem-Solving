import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int res, T, N, M;
	static int[][][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[2][N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			for (int j = 0; j < M; j++) {

				map[0][i][j] = a.charAt(j) - 48;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[1][i][j] = map[0][i][j];
			}
		}
//		print();
		int res = bfs();
		System.out.println(res);
	}

	private static int bfs() {
		Queue<int[]> que = new ArrayDeque<int[]>();
		que.offer(new int[] { 0, 0, 1, 0 });
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int r = temp[0];
			int c = temp[1];
			int dis = temp[2];
			int z = temp[3];
			if (N - 1 == r && M - 1 == c) {
				return dis;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (!check(nr, nc))
					continue;
				if (z == 0) {
					if (map[z][nr][nc] == 0) {
						map[z][nr][nc] =1;
						que.offer(new int[] { nr, nc, dis + 1, 0 });
					} else if (map[z][nr][nc] == 1) {
						que.offer(new int[] { nr, nc, dis + 1, 1 });
					}
				} else if (map[z][nr][nc] == 0) {
					map[z][nr][nc] =1;
					que.offer(new int[] { nr, nc, dis + 1, 1 });
				}
			}

		}
		return -1;
	}

//	private static void print() {
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//			
//		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//				
//			}
//			System.out.println();
//		}
//		
//	}
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
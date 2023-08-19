import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int M, N, H;
	static int[][][] map;
	static int[] dh = { -1, 1, 0, 0, 0, 0 }; // Up, down, left, right, front, back
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, 1, -1 };

	static Queue<int[]> que;

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new ArrayDeque();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j][k] = temp;
					if (temp == 1) {
						que.offer(new int[] { i, j, k });
					}
				}
			}
		}
		int day = -1; 
		while (!que.isEmpty()) {
			day++;
			bfs();
		}

		if (!isTomato()) {
			System.out.println(-1);
		} else {
			System.out.println(day);
		}
	}

	private static void print() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(map[i][j][k]);
				}
				System.out.println();
			}
			System.out.println("------"+i+"-------");
			
		}
		System.out.println();
	}

	private static void bfs() {
		int size = que.size();
		while (size-- > 0) {
			int[] temp = que.poll();
			int h = temp[0];
			int r = temp[1];
			int c = temp[2];
			for (int i = 0; i < 6; i++) {
				int nh = h + dh[i];
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (!check(nh, nr, nc)) continue;
				if (map[nh][nr][nc] == 0) {
					map[nh][nr][nc] = 1;
					que.offer(new int[] { nh, nr, nc });
				}
			}
		}
	}

	private static boolean check(int h, int r, int c) {
		return h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M;
	}

	private static boolean isTomato() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

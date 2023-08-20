import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		que = new ArrayDeque<int[]>();
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'I') {
					que.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}
		cnt =0;
		bfs();
		if (cnt==0) {
			System.out.println("TT");
		}else {
			System.out.println(cnt);
		}
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int temp[] = que.poll();
			int r = temp[0];
			int c = temp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc))
					continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 'O' ||  map[nr][nc] == 'P') {
					if (map[nr][nc] == 'P')  cnt++;
					que.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}

			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static Queue<int[]> jihun;
	static Queue<int[]> fire;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int x = 0; x < t; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			jihun = new ArrayDeque<>();
			fire = new ArrayDeque<>();
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];

			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = temp.charAt(j);
					if (map[i][j] == '@') {
						jihun.offer(new int[] { i, j, 1 });
					}
					if (map[i][j] == '*')
						fire.offer(new int[] { i, j });
				}
			}
			int count = 0;
			while (true) {
				if (jihun.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					break;
				}
				count = goJihun();
				if (count > 0) {
					System.out.println(count);
					break;
				}
				goFire();

			}
		}
	}

	private static void goFire() {
		int size = fire.size();
		while (size-- > 0) {
			int temp[] = fire.poll();
			int r = temp[0];
			int c = temp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (exit(nr, nc))
					continue;
//				if(map[nr][nc] == '#') continue;
				if (map[nr][nc] == '.' || map[nr][nc] == '@') {
					map[nr][nc] = '*';
					fire.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static int goJihun() {
		int size = jihun.size();
		while (size-- > 0) {
			int temp[] = jihun.poll();
			int r = temp[0];
			int c = temp[1];
			int time = temp[2];
			if (map[r][c] == '*')
				continue;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (exit(nr, nc))
					return time;
				if (map[nr][nc] == '#' || map[nr][nc] == '*')
					continue;
				if (map[nr][nc] == '.') {
					map[nr][nc] = '@';
					jihun.offer(new int[] { nr, nc, time + 1 });
				}
			}
		}
		return -1;
	}

	private static boolean exit(int r, int c) {
		return r < 0 || c < 0 || r >= N | c >= M;
	}

}

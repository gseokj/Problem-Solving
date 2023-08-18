import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N, M;
	static int sin[];
	static char[][] map;
	static Queue<int[]> person;
	static Queue<int[]> devil;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int x = 1; x < T + 1; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person = new ArrayDeque<int[]>();
			devil = new ArrayDeque<int[]>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				for (int j = 0; j < M; j++) {
					char temp = a.charAt(j);
					map[i][j] = temp;
					if (temp == 'S') {
						person.offer(new int[] { i, j, 0 });
					} else if (temp == '*') {
						devil.offer(new int[] { i, j });
					} else if (temp == 'D') {
						sin = new int[] { i, j };
					}

				}
			}

			while (true) {
				bfsD();
				int cnt = bfsP();
				if (cnt > 0) {
					System.out.println("#"+x+" "+cnt);
					break;

				}
				if (person.size() == 0) {
					System.out.println("#"+x+" GAME OVER");
					break;
				}
			}

		}
	}

	private static void bfsD() {
		int size = devil.size();
		while (size-- > 0) {
			int[] temp = devil.poll();
			int r = temp[0];
			int c = temp[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
					map[nr][nc] = '*';
					devil.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static int bfsP() {
		int size = person.size();
		while (size-- > 0) {
			int[] temp = person.poll();
			int r = temp[0];
			int c = temp[1];
			int depth = temp[2];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == 'D') {
					return depth + 1;
				} else if (map[nr][nc] == '.') {
					map[nr][nc] = 'S';
					person.offer(new int[] { nr, nc, depth + 1 });
				}
			}
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(map[i]);
		}

	}

}
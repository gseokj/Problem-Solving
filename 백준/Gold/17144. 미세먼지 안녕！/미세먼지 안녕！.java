import java.io.*;
import java.util.*;

public class Main {
	static int R, C, T;
	static int[][] map;
	static int[][] tempDust;
	static int[] d_dr = { 1, -1, 0, 0 };
	static int[] d_dc = { 0, 0, 1, -1 };

	static int[] t_dr = { -1, 0, 1, 0 };
	static int[] t_dc = { 0, 1, 0, -1 };

	static int[] b_dr = { 1, 0, -1, 0 };
	static int[] b_dc = { 0, 1, 0, -1 };
	static Queue<int[]> que;
	static int[] topAir;
	static int[] bottomAir;
	
	
	static int res;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		tempDust = new int[R][C];
		
		int[] temp = new int[2];
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					temp[cnt++] = i;
				}
			}
		}
		topAir = new int[] { temp[0], 0 };
		bottomAir = new int[] { temp[1], 0 };
		res=0;
		for (int i = 0; i < T; i++) {
			dustStart();
			airCleanerStart();
		}
		print();
		System.out.println(res);
	}

	private static void airCleanerStart() {
		topAirStart();
		bottomAirtStart();
		
	}

	private static void topAirStart() {
		int r = topAir[0];
		int c = topAir[1];
		boolean flag = false;
		int dir = 0;
		while(true) {
			int nextR = r+t_dr[dir];
			int nextC = c+t_dc[dir];
			if(!t_check(nextR,nextC)) {
				dir++;
				continue;
			}
			if(flag) {
				if(map[nextR][nextC] != -1) {
					map[r][c] = map[nextR][nextC];
				}else {
					map[r][c] = 0;
				}
			}else {
				flag = true;
				map[nextR][nextC] = 0;
			}
			r = nextR;
			c = nextC;
			
			if(map[r][c]==-1) break;
		}

	}

	private static void bottomAirtStart() {
		int r = bottomAir[0];
		int c = bottomAir[1];
		boolean flag = false;
		int dir = 0;
		while(true) {
			int nextR = r+b_dr[dir];
			int nextC = c+b_dc[dir];
			if(!b_check(nextR,nextC)) {
				dir++;
				continue;
			}
			if(flag) {
				if(map[nextR][nextC] != -1) {
					map[r][c] = map[nextR][nextC];
				}else {
					map[r][c] = 0;
				}
			}else {
				flag = true;
				map[nextR][nextC] = 0;
			}
			r = nextR;
			c = nextC;
			if(map[r][c]==-1) break;
		}

	}

	private static void dustStart() {
		init(); // 한 번에 추가할 2중배열을 초기화
		addDustToQue(); // 한 번에 추가할 먼지를 Que에 담기
		toDust(); // 먼지가 4방으로 이동 temp 담기
		moveDust(); // 이동한 먼지를 더하거나 한 번에 차감
	}

	private static void moveDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += tempDust[i][j];
			}
		}

	}

	private static void toDust() {
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int r = temp[0];
			int c = temp[1];
			int dust = map[r][c] / 5;
			int dir_cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + d_dr[d];
				int nc = c + d_dc[d];
				if (!check(nr, nc) || map[nr][nc] == -1)
					continue;
				dir_cnt++;
				tempDust[nr][nc] += dust;
			}
			int moveDust = dir_cnt * dust;
			tempDust[r][c] -= moveDust;
		}
	}

	private static void addDustToQue() {
		que = new ArrayDeque<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] > 4)
					que.offer(new int[] { r, c });
			}
		}
	}

	private static void init() {
		for (int i = 0; i < R; i++) {
			Arrays.fill(tempDust[i], 0);
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	private static boolean t_check(int r, int c) {
		return r >= 0 && c >= 0 && r <= topAir[0] && c < C;
	}
	private static boolean b_check(int r, int c) {
		return r >= bottomAir[0] && c >= 0 && r < R && c < C;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
				res+=map[i][j];
			}
//			System.out.println();
		}
		res+=2;
//		System.out.println("-----------------");
	}
}
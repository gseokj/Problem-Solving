import java.util.*;
import java.io.*;

class Main {
	static int N, Q, L;
	static int[][] map,copy;
	static Queue<int[]> que;
	static int[] dr= {1,0,-1,0};
	static int[] dc= {0,1,0,-1};
	static int res;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = 1<<Integer.parseInt(st.nextToken()); // 1<<3 = 8
		Q = Integer.parseInt(st.nextToken()); // 1<<3 = 8
		map = new int[N][N];
		copy = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		st = new StringTokenizer(br.readLine());
		for (int T = 0; T < Q; T++) {
			L = 1<<Integer.parseInt(st.nextToken());
			que = new ArrayDeque();
			for (int i = 0; i < N; i = i + L) {
				for (int j = 0; j < N; j = j + L) {
					int r = i;
					for (int k = 0; k < L / 2; k++) {
						que.offer(new int[] { i+k,j+k,L-(k*2) }); // start, len
					}
				}
			}
			rotate();
			fireStorm();

		}

		int tot = 0;
		res = 0;
		
		tot(); // 전체 합계
		tot = mass();
		System.out.println(res);
		System.out.println(tot);
	}


	private static int mass() {
		int tot = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(visited[r][c] || map[r][c] < 1) continue;
				tot = Math.max(tot, bfs(r,c));
				
			}
		}
		return tot;
	}


	private static int bfs(int rr, int cc) {
		int tot = 1;
		Queue<int[]> que = new ArrayDeque();
		que.offer(new int[] {rr,cc});
		visited[rr][cc] = true;
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int r = temp[0];
			int c=  temp[1];
			for (int d = 0; d < 4; d++) {
				int nr = r +dr[d];
				int nc = c +dc[d];
				if(!check(new int[] {0,0},nr,nc,N) || visited[nr][nc]|| map[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				que.offer(new int[] {nr,nc});
				tot++;
			}
		}
		return tot;
	}


	private static void fireStorm() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(copy[i], 0);
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int ice = 0;
				if(map[r][c] <=0) continue;
				for (int d = 0; d < 4; d++) {
					int nr = r +dr[d];
					int nc = c +dc[d];
					if(!check(new int[]{0,0},nr,nc,N) ) continue;
					if(map[nr][nc]>0) ice++;
				}
				if(ice<3) {
					copy[r][c] =-1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += copy[i][j];
			}
		}
	}


	private static void rotate() {
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			
			int len = temp[2];
			for (int i = 0; i < len-1; i++) {
				
			
			int[] start = {temp[0],temp[1]};
			int r = start[0];
			int c = start[1];
			
			int nextR;
			int nextC;
			
			int dir = 0;
			
			int first = map[r][c];
			while(true) {
				nextR = r+dr[dir];
				nextC = c+dc[dir];
				if(nextR==start[0] && nextC==start[1]) {
					map[r][c] = first;
					break;
				}
				if(!check(start,nextR,nextC,len)) {
					dir++;
					continue;
				}
				
				map[r][c] = map[nextR][nextC];
				
				r = nextR;
				c = nextC;
				
			}
		}
		}
	}
	private static void tot() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res+=map[i][j];
			}
		}
		
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static boolean check(int[] start, int r, int c,int len) {
		return r>=start[0] &&c>=start[1] && r<len+start[0] && c<len+start[1];
	}
	
}
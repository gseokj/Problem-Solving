import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Chicken {
		private int r;
		private int c;
		private int dis;

		public Chicken() {
			super();
		}

		public Chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public int getR() {
			return r;
		}

		public int getC() {
			return c;
		}

		public int getDis() {
			return dis;
		}

		public void setDis(int dis) {
			this.dis = dis;
		}

		@Override
		public String toString() {
			return "r=" + r + ", c=" + c + ", dis=" + dis;
		}

	}

	static class Home {
		private int r;
		private int c;
		private int dis;

		public Home() {
			super();
		}

		public Home(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public int getDis() {
			return dis;
		}

		public void setDis(int dis) {
			this.dis = dis;
		}

		public int getR() {
			return r;
		}

		public int getC() {
			return c;
		}

		@Override
		public String toString() {
			return "r=" + r + ", c=" + c;
		}

	}

	static int N, M;
	static int[] P;
	static int chickens;
	static int R;
	static int[] nums;
	static int[][] map, copy;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] visited;
	static int res, total;
	static List<Chicken> chi;
	static List<Home> h;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chi = new ArrayList<>();
		h = new ArrayList<>();
		map = new int[N][N];
		copy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) {
					map[i][j] = a;
					copy[i][j] = a;
					h.add(new Home(i, j));
				} else if (a == 2) {
					chi.add(new Chicken(i, j));
					chickens++;
				}

			}

		}
		

		
		// 백트래킹시작
		R = M;
		P = new int[chickens];
		for (int i = 0; i < chickens; i++) {
			P[i] = i;
		}
		res = Integer.MAX_VALUE;
		nums = new int[R];
		combi(0,0);
		System.out.println(res);
		
	}
	
	
	static void combi(int cnt, int start) {
		if (R==cnt) {
			int tot = 0;
			cInit();
			
			for (int i = 0; i < R; i++) {
					int tempR = chi.get(nums[i]).getR();
					int tempC = chi.get(nums[i]).getC();
					map[tempR][tempC] = 2;
			}
			hInit();
			for (int x = 0; x < R; x++) {
				int tempR = chi.get(nums[x]).getR();
				int tempC = chi.get(nums[x]).getC();
				visited = new int[N][N];
				bfs(tempR,tempC);
			}
			tot = hAdd(tot);
			res=Math.min(res, tot);
			return;
		}
		
		for (int i = start; i < P.length; i++) {
			nums[cnt] = P[i];
			combi(cnt+1,i+1);
			nums[cnt] = 0;
		}
		
	}






	private static void cInit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}


	private static int hAdd(int tot) {
		for (int i = 0; i < h.size(); i++) {
			tot+=h.get(i).getDis();
		}
		return tot;
	}


	private static void hInit() {
		for (int i = 0; i < h.size(); i++) {
			h.get(i).setDis(0);
		}
		
	}


	static void bfs(int r, int c) {
		Queue<int []> que = new ArrayDeque<>();
		que.offer(new int[] {r,c});
		visited[r][c] = 1;
		while(!que.isEmpty()){
			int temp [] =que.poll();
			int xr =  temp[0];
			int xc =  temp[1];
			if (map[xr][xc] == 1) {
				for (int i = 0; i < h.size(); i++) {
					int vis = visited[xr][xc];
					if (h.get(i).getR() == xr && h.get(i).getC()== xc) {
						if (h.get(i).getDis()==0) {
							h.get(i).setDis(vis-1);
						}else {
							h.get(i).setDis(Math.min(h.get(i).getDis(),vis-1));
						}
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int nr = xr+dr[i];
				int nc = xc+dc[i];
				
				if (!check(nr,nc)) continue;
				if (visited[nr][nc] ==0) {
					visited[nr][nc] = visited[xr][xc]+1;
					que.offer(new int[] {nr,nc});
				}
				
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r< N && c<N && map[r][c] != 2;
	}

}
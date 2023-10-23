import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int N, M;
	static char[][] map;
	static boolean[][] vis;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int w;

		public Node(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
		

	}

	static StringTokenizer st;
	static List<Node> prisoner;
	static int result;

	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N + 2][M + 2];
			prisoner = new ArrayList<>();
			vis = new boolean[N+2][M+2];

			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i+1][j+1] = temp.charAt(j);
					if (map[i+1][j+1] == '$') {
						prisoner.add(new Node(i+1, j+1));
					}
				}
			}
			int[][] prisoner1 = new int[N+2][M+2];
			int[][] prisoner2 = new int[N+2][M+2];
			int[][] person = new int[N+2][M+2];
			dijk(prisoner1,prisoner.get(0));
			dijk(prisoner2,prisoner.get(1));
			dijk(person,new Node(0,0));
			int res = Integer.MAX_VALUE;
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < M; j++) {
					if(map[i][j] == '*') continue;
					if(!vis[i][j]) continue;
					int tot = 0;
					tot+=prisoner1[i][j]+prisoner2[i][j]+person[i][j];
					if(map[i][j] =='#') {
						tot+=-2;
					}
					res = Math.min(res, tot);
				}
				
			}
			System.out.println(res);
		}
	}

	private static void dijk(int[][] p, Node n) {
		boolean[][] visited = new boolean[N+2][M+2];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(n);
		visited[n.r][n.c]=true; 
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int r = temp.r;
			int c = temp.c;
			int w = temp.w;
			
			for (int d = 0; d < 4; d++) {
				int nr = dr[d]+r;
				int nc = dc[d]+c;
				if(!check(nr,nc)|| visited[nr][nc]||map[nr][nc]=='*') continue;
				visited[nr][nc] = true;
				if(map[nr][nc]=='#') {
					int nextW = w+1;
					pq.offer(new Node(nr,nc,nextW));
					p[nr][nc]=nextW;
					vis[nr][nc] = true;
				}else {
					p[nr][nc]=w;
					pq.offer(new Node(nr,nc,w));
					vis[nr][nc] = true;
					
				}
			}
			
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N+2 && c<M+2;
	}

	private static void print() {
		for (int i = 0; i < N+2; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
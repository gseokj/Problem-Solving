import java.util.*;

import java.io.*;

public class Main {
	static int N;
	static int K;
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> keys;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] S;
	static int[][] minM;
	static final int INF = Integer.MAX_VALUE;
	static int[][] idx;
	static int cnt;

	static class Node implements Comparable<Node> {
		int s;
		int e;
		int w;

		public Node(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}

	}

	static PriorityQueue<Node> nodes;
	static int[] p, r;
	static int V;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visited = new boolean[N][N];
		keys = new ArrayList();
		S = new int[2];
		nodes = new PriorityQueue<>();
		V = K + 1;
		p = new int[V];
		r = new int[V];
		idx = new int[N][N];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				char a = temp.charAt(j);
				map[i][j] = a;
				if (a == 'S') {
					S[0] = i;
					S[1] = j;
				} else if (a == 'K') {
					keys.add(new int[] { i, j });
					idx[i][j] = cnt;
					cnt++;
				}
			}
		}
		keys.add(new int[] { S[0], S[1] });
		idx[S[0]][S[1]] = cnt;

		makeSet();

		for (int i = 0; i < keys.size(); i++) {
			int[] start = keys.get(i);
			bfs(start[0], start[1]);
		}
		int res = 0;
		while (!nodes.isEmpty()) {
			Node node = nodes.poll();
			if (union(node.s, node.e)) {
				res += node.w;
			}
		}
		int x = find(0);
		boolean flag = true;
		for (int i = 1; i < V; i++) {
			if(x!=find(i)) {
				flag = false;
				break;
			}
		}
		if(flag)System.out.println(res);
		else System.out.println(-1);
	}

	private static void makeSet() {
		for (int i = 0; i < V; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

	private static int find(int x) {
		if (p[x] == x)
			return p[x];
		else
			return p[x] = find(p[x]);
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		if (r[x] > r[y]) {
			r[x] += r[y];
			p[y] = x;
		} else {
			r[y] += r[x];
			p[x] = y;
		}
		return true;
	}

	private static void bfs(int sr, int sc) {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(sr, sc, 0));
		int[][] visited = new int[N][N];
		int index = idx[sr][sc];
		while (!que.isEmpty()) {
			Node cur = que.poll();
			int r = cur.s;
			int c = cur.e;
			int cnt = cur.w;
			int nextIndex = idx[r][c];
			if (index != nextIndex && (map[r][c] == 'K' || map[r][c] == 'S')) {
				nodes.add(new Node(index, nextIndex, cnt));
			}
			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + r;
				int nc = dc[d] + c;
				if (!check(nr, nc) || map[nr][nc] == '1')
					continue;
				int next = cnt + 1;
				if ((nr != sr || nc != sc) && visited[nr][nc] == 0) {
					visited[nr][nc] = next;
					que.offer(new Node(nr, nc, next));
				}

			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
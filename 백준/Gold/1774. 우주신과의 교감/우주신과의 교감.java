import java.util.*;
import java.io.*;

public class Main {
	static int V,E;
	static int N;
	static int[][] map;
	static class Node implements Comparable<Node>{
		int s;
		int e;
		double w;
		
		public Node(int s, int e, double w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(w,o.w);
		}
	}
	static int[] r;
	static int[] p;
	static PriorityQueue<Node> pq;
		public static void main(String[] args) throws Exception {
			//System.setIn(new FileInputStream("src/input.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[V+1][V+1];
			r = new int[V+1];
			p = new int[V+1];
			for (int i = 1; i < V+1; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[i][0] = x;
				map[i][1] = y;
			}
			pq = new PriorityQueue<>();
			for (int i = 1; i < V; i++) {
				for (int j = i+1; j < V+1; j++) {
					pq.offer(new Node(i,j,distance(i,j)));
				}
			}
			makeSet();
			double min = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				union(s,e);
			}
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				if(union(node.s,node.e)) {
					min+=node.w;
				}
			}
			System.out.println(String.format("%.2f",min));
			
			
		}
		private static double distance(int x, int y) {
			double x2=(map[x][0] - map[y][0]);
			double y2=(map[x][1] - map[y][1]);
			return Math.sqrt(Math.pow(x2, 2)+Math.pow(y2, 2));
			
		}
		private static void makeSet() {
			for (int i = 0; i < V+1; i++) {
				r[i] =1;
				p[i] = i;
			}
		}
		private static int find(int x) {
			if(p[x] ==x) return p[x];
			else return p[x] = find(p[x]);
		}
		private static boolean union(int x, int y) {
			x = find(x);
			y = find(y);
			if(x==y) return false;
			if(r[x]>r[y]) {
				r[x]=r[y];
				p[y] =x;
			}else {
				r[y]+=r[x];
				p[x] = y;
			}
			return true;
	}
}
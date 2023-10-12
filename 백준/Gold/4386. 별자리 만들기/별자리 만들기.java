import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static StringTokenizer st; 
	static int[] p;
	static int[] r;
	static double[][] map;
	static PriorityQueue<Node> pq;
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
			return Double.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new double[N+1][N+1];
		pq = new PriorityQueue<Node>();
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			map[i][0] = x;
			map[i][1] = y;
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = i+1; j < N+1; j++) {
				pq.offer(new Node(i,j,distance(i,j)));
			}
		}
		p = new int[N+1];
		r = new int[N+1];
		makeSet();
		double res = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(union(node.s,node.e)) {
				res+=node.w;
			}
		}
		System.out.println(String.format("%.2f",res));
		
	}
	
	
	private static int find(int x) {
		if(p[x]==x) return p[x];
		else return p[x]= find(p[x]);
	}


	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		if(p[x]>p[y]) {
			r[x]+=r[y];
			p[y] = x;
		}else {
			r[y]+=r[x];
			p[x] = y;
		}
		return true;
	}


	private static void makeSet() {
		for (int i = 0; i < N+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}


	private static double distance(int x, int y) {
		double x2=(map[x][0] - map[y][0]);
		double y2=(map[x][1] - map[y][1]);
		return Math.sqrt(Math.pow(x2, 2)+Math.pow(y2, 2));
		
	}
}
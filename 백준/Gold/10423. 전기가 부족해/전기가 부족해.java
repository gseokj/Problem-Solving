import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;
	static StringTokenizer st;
	static int N, M, K;
	static final int INF = Integer.MAX_VALUE;
	static int[] p;
	static int[] r;

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
		public String toString() {
			return "node [s=" + s + ", e=" + e + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}

	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		r = new int[N + 1];
		p = new int[N + 1];
		makeSet();
		int x = find(1);
		boolean a = union(1, 1);
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K-1; i++) {
			union(first,Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Node(s,e,w));
		}
		long res =0L;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(union(node.s,node.e)){
				res+=node.w;
			}
		}
		System.out.println(res);
		
	}

	private static void makeSet() {
		for (int i = 0; i < 1 + N; i++) {
			r[i] = 1;
			p[i] = i;
		}
	}

	private static int find(int x) {
		if(p[x]==x) return p[x];
		else return p[x]=find(p[x]);
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		if(r[x]>=r[y]) {
			r[x]+=r[y];
			p[y]= x;
		}else {
			r[y]+=r[x];
			p[x]=y;
		}
		return true;
	}

}
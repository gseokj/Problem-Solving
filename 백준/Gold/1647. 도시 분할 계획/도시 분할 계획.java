import java.util.*;
import java.io.*;

public class Main {
	static int N, M;

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
			return this.w - o.w;
		}

	}

	static int[] r;
	static int[] p;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Node(s, e, w));
		}
		
		int res = 0;
		int max = 0;
		r = new int[N+1];
		p = new int[N+1];
		makeSet();
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(union(node.s,node.e)) {
				res+=node.w;
				max= Math.max(max,node.w);
			}
		}
		System.out.println(res-max);
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

	private static int find(int x) {
		if (p[x] == x)
			return p[x];
		else
			return p[x] = find(p[x]);
	}

	private static void makeSet() {
		for (int i = 0; i < N+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

}
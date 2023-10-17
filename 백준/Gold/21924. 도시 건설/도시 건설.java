import java.util.*;
import java.io.*;

public class Main {
	static int V;
	static int E;

	static class Node implements Comparable<Node> {
		int s;
		int e;
		long w;

		public Node(int s, int e, long w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(w, o.w);
		}
	}

	static PriorityQueue<Node> pq;
	static long total;
	static int[] p, r;

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		total = 0;
		pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			pq.offer(new Node(s, e, w));
			total += w;
		}
		p = new int[V+1];
		r = new int[V+1];
		makeSet();
		long min = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (union(node.s, node.e)) {
				min += node.w;
			}
		}
		int x = find(1);
		boolean flag = true;
		for (int i = 1; i < V+1; i++) {
			if (x != find(p[i])) {
				flag = false;
				
				break;
			}
		}

		if (flag)
			System.out.println(total - min);
		else
			System.out.println(-1);
	}

	private static void makeSet() {
		for (int i = 0; i < V+1; i++) {
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

}
import java.util.*;
import java.io.*;

public class Main {
	static int V;
	static int E;

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

	static int[] p, r;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		p = new int[V];
		r = new int[V];
		long tot=0;
		for (int i = 0; i < V; i++) {
			String temp = br.readLine();
			for (int j = 0; j < V; j++) {
				if(temp.charAt(j)=='0') continue;
				int w = check(temp.charAt(j));
				tot+=w;
				if (i == j)
					continue;
				pq.offer(new Node(i, j, w));
			}
		}
		makeSet();
		long min = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(union(curr.s,curr.e)) {
				min+=curr.w;
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
		
		if(flag)System.out.println(tot-min);
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
		if(x==y) return false;
		if(r[x]>r[y]) {
			r[x]+=r[y];
			p[y]=x;
		}else {
			r[y]+=r[x];
			p[x]=y;
		}
		return true;
	}

	private static int check(char c) {
		if ((int) c >= 'a')
			return c - 'a' + 1;
		else
			return c - 'A' + 27;

	}
}
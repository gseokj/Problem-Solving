import java.util.*;
import java.io.*;

public class Main {
	static int V;
	static int E;
	static int[] p,r;
	static PriorityQueue<Node> pq;
	static StringTokenizer st ;
	static class Node implements Comparable<Node>{
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
			return w-o.w;
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		p = new int[V];
		r = new int[V];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				int w = Integer.parseInt(st.nextToken());
				if(i==j) continue;
				pq.add(new Node(i,j,w));
			}
		}
		
		makeSet();
		long min = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(union(node.s,node.e)) {
				min+=node.w;
			}
		}
		System.out.println(min);
	}
	private static void makeSet() {
		for (int i = 0; i < V; i++) {
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
		if (r[x]>r[y]) {
			r[x]+=r[y];
			p[y]=x;
		}else {
			r[y]+=r[x];
			p[x]=y;
		}
		return true;
	}
}
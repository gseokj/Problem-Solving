import java.util.*;
import java.io.*;
public class Main {
	static int V;
	static int E;
	static class Node implements Comparable<Node>{
		int idx;
		int s;
		int e;
		double w;
		public Node(int s, int e, double w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		
		public Node(int idx, double w) {
			super();
			this.idx = idx;
			this.w = w;
		}


		@Override
		public int compareTo(Node o) {
			return Double.compare(this.w, o.w);
		}


		@Override
		public String toString() {
			return "Node [s=" + s + ", e=" + e + ", w=" + w + "]";
		}


		
		
		
	}
	static List<Node>[] X;
	static int[] p,r;
	static StringTokenizer st;
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		p = new int[V+1];
		r = new int[V+1];
		X  = new ArrayList[3];
		for (int i = 0; i < 3; i++) {
			X[i] = new ArrayList();
		}
		pq = new PriorityQueue();
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			X[0].add(new Node(i,x));
			X[1].add(new Node(i,y));
			X[2].add(new Node(i,z));
		}
		for (int i = 0; i < 3; i++) {
			Collections.sort(X[i]);
			for (int s = 0; s < V-1; s++) {
				Node cur = X[i].get(s);
				Node next = X[i].get(s+1);
				double weight = Math.abs(cur.w-next.w);
				pq.offer(new Node(cur.idx,next.idx,weight));
			}
		}
		makeSet();
		int cnt=0;
		double min = 0;
		while(!pq.isEmpty()) {	
			Node curr = pq.poll();
			if(union(curr.s,curr.e)) {
				min+=curr.w;
			}
		}
		System.out.println((int)min);
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return false;
		if(r[x]>r[y]) {
			r[x]+=r[y];
			p[y] = x;
		}else {
			r[y]+=r[x];
			p[x] = y;
		}
		return true;
	}
	private static int find(int x) {
		if(p[x]==x) return p[x];
		else return p[x] = find(p[x]);
	}
	private static void makeSet() {
		for (int i = 0; i < V+1; i++) {
			p[i] =i;
			r[i] = 1;
		}
		
	}

}
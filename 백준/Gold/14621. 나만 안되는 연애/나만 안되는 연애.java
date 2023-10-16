import java.util.*;
import java.io.*;

public class Main{
	static int V;
	static int E;
	static int[] p,r;
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
		@Override
		public String toString() {
			return "Node [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
		
	}
	static PriorityQueue<Node> pq;
	static StringTokenizer st;
	static char[] sep;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		p = new int[V];
		r = new int[V];
		sep = new char[V];
		st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>();
		for (int i = 0; i < V; i++) {
			char a = st.nextToken().charAt(0);
			sep[i] = a;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			if(sep[s]==sep[e]) continue;
			pq.offer(new Node(s,e,w));
		}
		makeSet();
		long min =0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(union(node.s,node.e)) {
				min+=node.w;
			}
		}
		boolean flag = true;
		int x = find(0);
		for (int i = 1; i < V; i++) {
			int temp = find(i);
			if(temp!=x) {
				flag=false;
				break;
			}
		}
		if(flag)System.out.println(min);
		else System.out.println(-1);
	}
	private static void makeSet() {
		for (int i = 0; i < V; i++) {
			r[i] = 1;
			p[i] = i;
		}
	}
	private static int find(int x) {
		if (p[x]==x) return p[x];
		else return p[x] = find(p[x]);
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
}
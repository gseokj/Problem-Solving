import java.util.*;
import java.io.*;
 
public class Main {
    static int N,M;
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
			return this.w-o.w;
		}
		
    }
    static PriorityQueue<Node> pq;
    static StringTokenizer st;
    static int[] r;
    static int[] p;
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pq = new PriorityQueue<Node>();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s= Integer.parseInt(st.nextToken())-1;
			int e= Integer.parseInt(st.nextToken())-1;
			int w= Integer.parseInt(st.nextToken());
			pq.offer(new Node(s,e,w));
		}
		r = new int[N];
		p = new int[N];
		makeSet();
		
		int res = 0;
		Node temp = null;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(union(temp.s,temp.e)) {
				res+=temp.w;
			}
		}
		System.out.println(res);
	}
	private static int find(int x) {
		if(p[x]==x) return p[x];
		else return p[x]=find(p[x]);
	}
	private static boolean union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		if(r[x]<r[y]) {
			r[y] +=r[x];
			p[x] = y;
		}else {
			r[x] +=r[y];
			p[y] = x;
		}
		return true;
	}
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}
 
}
import java.util.*;
import java.io.*;

public class Main {
	static int V;
	static int E;
	static int[] r,p;
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
	static PriorityQueue<Node> pqR;
	
	public static void main(String[] args) throws Exception {
		 pq = new PriorityQueue<>();
		 pqR = new PriorityQueue<>(Collections.reverseOrder());
		 //System.setIn(new FileInputStream("src/input.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 V = Integer.parseInt(st.nextToken());
		 E = Integer.parseInt(st.nextToken())+1;
		 p = new int[V+1];
		 r = new int[V+1];
		 for (int i = 0; i < E; i++) {
			 st = new StringTokenizer(br.readLine());
			 int s = Integer.parseInt(st.nextToken());
			 int e = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
			 if(w==0) w++;
			 else w--;
			 pq.offer(new Node(s,e,w));
			 pqR.offer(new Node(s,e,w));
		}
		 makeSet();
		 int min =0;
		 int max = 0;
		 while(!pq.isEmpty()) {
			 Node node = pq.poll();
			 if(union(node.s,node.e)) {
				 min+=node.w;
			 }
		 }
		 makeSet();
		 while(!pqR.isEmpty()) {
			 Node node = pqR.poll();
			 if(union(node.s,node.e)) {
				 max+=node.w;
			 }
		 }
		 System.out.println((int)(Math.pow(max,2)-Math.pow(min,2)));
	}

	private static void makeSet() {
		for (int i = 0; i < V+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

	private static int find(int x) {
		if(p[x] == x) return p[x];
		return p[x] =find(p[x]);
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
			p[x]= y;
		}
		return true;
	}
}
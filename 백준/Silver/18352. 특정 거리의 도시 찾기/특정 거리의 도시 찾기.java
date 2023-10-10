import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int n;
		int dis;
		public Node(int n, int dis) {
			super();
			this.n = n;
			this.dis = dis;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dis, o.dis);
		}
		
		
	}
	static int V,E,K,X;
	static int[] min;
	static List<Node>[] map;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		min = new int[V];
		map = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			map[i] = new ArrayList<>();
			min[i] = INF;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			map[s].add(new Node(e,1));
		}
		
		dijkstra(X-1);
		boolean flag = true;
		for (int i = 0; i < V; i++) {
			if(min[i] == K) {
				System.out.println(i+1);
				flag =false;
			}
		}
		if(flag) {
			System.out.println(-1);
		}
	}
	private static void dijkstra(int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(k,0));
		min[k] = 0;
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int curr = temp.n;
			int currDis = temp.dis;
			for (Node node : map[curr]) {
				int next = node.n;
				int nextDis = node.dis;
				if(min[next]>currDis+nextDis) {
					min[next] = currDis+nextDis;
					pq.offer(new Node(next,currDis+nextDis));
				}
			}
		}
	}
	

}
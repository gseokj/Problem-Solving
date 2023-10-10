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
	static int N,E;
	static int[] min;
	static List<Node>[] map;
	static final int INF = Integer.MAX_VALUE;
	static int speS;
	static int speE;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		min = new int[N];
		map = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<>();
			min[i] = INF;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			map[s].add(new Node(e,c));
			map[e].add(new Node(s,c));
		}
		st = new StringTokenizer(br.readLine());
		speS =  Integer.parseInt(st.nextToken())-1;
		speE =  Integer.parseInt(st.nextToken())-1;
		
		int res = Math.min(dist(0,speS,speE,N-1),dist(0,speE,speS,N-1));
		System.out.println(res);
			
		
		
	}
	private static int dist(int from,int mid1, int mid2, int to) {
		int res1 =  dijkstra(0, mid1);
		Arrays.fill(min,INF);
		int res2 =  dijkstra(mid1, mid2);
		Arrays.fill(min,INF);
		int res3 =  dijkstra(mid2, N-1);
		Arrays.fill(min,INF);
		if(res1==-1 ||res2==-1 ||res3==-1 ) {
			return -1;
		}
		return res1+res2+res3;
		
	}
	private static int dijkstra(int s, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s,0));
		min[s] = 0;
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int curr = temp.n;
			int currDis = temp.dis;
			if(curr==e) return currDis;
			for (Node node : map[curr]) {
				int next = node.n;
				int nextDis = node.dis;
				if(min[next]>nextDis+currDis) {
					min[next] = nextDis+currDis;
					pq.offer(new Node(next,nextDis+currDis));
				}
			}
		}
		return -1;
	}
	

}
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int v;
		int w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}

	}
	static final int INF =Integer.MAX_VALUE;
	static int[] min;
	static int N, M, R;
	static int[] items;
	static int[][] res;
	static List<Node>[] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = new int[N + 1];
		map = new ArrayList[N+1];
		res = new int[N][N];
		sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[s].add(new Node(e,w));
			map[e].add(new Node(s,w));
		}
		
		Arrays.fill(min, INF);
		for (int i = 1; i < N+1; i++) {
			dijkstra(i);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j)sb.append("- ");
				else sb.append(res[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		Arrays.fill(min, INF);
		min[start] = -1;
		res[start-1][start-1] = -1;
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int curr = temp.v;
			int dist = temp.w;
			
			for (Node node : map[curr]) {
				int next = node.v;
				int nextDist = node.w;
				if(min[next]>dist+nextDist) {
					min[next] = dist+nextDist;
					res[node.v-1][start-1] = curr;
					
					pq.offer(new Node(next,dist+nextDist));
				}
			}
		}
	}

}
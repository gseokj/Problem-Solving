import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int v;
		int e;

		public Node(int v, int e) {
			super();
			this.v = v;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			return this.e - o.e;
		}

	}
	static final int INF =Integer.MAX_VALUE;
	static int[] min;
	static int N, M, R;
	static int[] items;
	static List<Node>[] map;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		min = new int[N + 1];
		items = new int[N + 1];
		map = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++)
			items[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < R + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			map[s].add(new Node(e, m));
			map[e].add(new Node(s, m));
		}
		int res = 0;
		for (int i = 1; i < N+1; i++) {
			int tot = 0;
			for (int j = 1; j < N + 1; j++) {
				Arrays.fill(min, INF);
				if(dijkstra(i, j)) {
					tot+=items[j];
				}
				res = Math.max(tot, res);
			}
		}
		System.out.println(res);
	}

	private static boolean dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		min[start] = 0;
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int curr = temp.v;
			int dist = temp.e;
			if(curr==end) return true;
			
			for (Node node : map[curr]) {
				int next = node.v;
				int nextDist = node.e;
				
				if(min[next]>dist+nextDist) {
					min[next] = dist+nextDist;
					if(dist+nextDist <= M)
					pq.offer(new Node(next,dist+nextDist));
				}
			}
		}
		return false;
	}

}
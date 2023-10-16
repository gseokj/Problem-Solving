import java.util.*;
import java.io.*;

public class Main {
	static int V;
	static int[] halls;

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
			return w - o.w;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}
		
	}

	static List<Node>[] adj;
	static StringTokenizer st;
	static PriorityQueue<Node> minHall;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		halls = new int[V];
		adj = new ArrayList[V];
		minHall = new PriorityQueue<>();
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList();

		for (int i = 0; i < V; i++) { // Watering hall 소요비용
			minHall.add(new Node(i, Integer.parseInt(br.readLine())));
		}
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (i == j)
					continue;
				adj[i].add(new Node(j, w));
			}

		}
		int res = prim();
		System.out.println(res);
	}

	private static int prim() {
//		PriorityQueue<Node> pq = new PriorityQueue<>();
		int min = 0;
		int cnt = 0;
		boolean[] visited = new boolean[V];
//		pq.offer(minHall.poll());
		while (!minHall.isEmpty()) {
			Node node = minHall.poll();
			if(visited[node.v]) continue;
			visited[node.v] = true;
			min+=node.w;
			if(++cnt==V) return min;
			for (int i = 0; i < adj[node.v].size(); i++) {
				Node next = adj[node.v].get(i);
				if(visited[next.v]) continue;
				minHall.offer(next);
			}
		}
		return min;
	}
}
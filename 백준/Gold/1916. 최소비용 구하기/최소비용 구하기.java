import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int loc;
		int cost;
		int[] path;

		public Node(int loc, int cost, int[] path) {
			super();
			this.loc = loc;
			this.cost = cost;
			this.path = path;
		}

		public Node(int loc, int cost) {
			super();
			this.loc = loc;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return "Node [loc=" + loc + ", cost=" + cost + ", path=" + Arrays.toString(path) + "]";
		}

		
	}

	static int N, M;
	static int S, E;
	static StringTokenizer st;
	static List<Node>[] map;
	static int[] min;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		map = new ArrayList[N+1];
		min = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			map[i] = new ArrayList<>();
			min[i] = INF;
		}
		for (int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[s].add(new Node(e, cost));
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		Node res = dijkstra();
		System.out.println(res.cost);
		
		
	}

	private static Node dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		min[S] = 0;
		pq.offer(new Node(S, 0, new int[] { S }));
		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			int curr = temp.loc;
			int currCost = temp.cost;
			int[] path = temp.path.clone();
			if(curr==E) return new Node(curr,currCost,path);
			for (Node node : map[curr]) {
				int next = node.loc;
				int nextCost = node.cost;
				if(min[next]>currCost+nextCost) {
					min[next] = currCost+nextCost;
					int[] nextPath = new int[path.length+1];
					nextPath[path.length] = next;
					System.arraycopy(path, 0, nextPath, 0, path.length);
					pq.offer(new Node(next,currCost+nextCost,nextPath));
				}
			}
		}
		return null;
	}

	

}
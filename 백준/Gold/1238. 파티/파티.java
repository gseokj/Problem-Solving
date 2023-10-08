import java.io.*;
import java.util.*;

public class Main {
	static int N, M, X;
	static StringTokenizer st;
	static PriorityQueue<Node> pq;
	static int[] minTime;
	static List<Node>[] map;
	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int s;
		int e;
		int time;

		public Node(int s, int time) {
			super();
			this.s = s;
			this.time = time;
		}

		public Node(int s, int e, int time) {
			super();
			this.s = s;
			this.e = e;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<Node>();
		}

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			map[s].add(new Node(s, e, t));
		}
		int res = 0;
		minTime = new int[N + 1];
		init();
		for (int i = 1; i < N + 1; i++) {
			init();
			res = Math.max(res, dijkstra(new Node(i, 0)));
		}
		System.out.println(res);
	}

	private static int dijkstra(Node n) {

		pq = new PriorityQueue<Node>();
		pq.offer(n);
		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			int curr = temp.s;
			int time = temp.time;
			if (curr == X) {
				init();
				pq = new PriorityQueue<Node>();
				pq.offer(new Node(X, time));
				while (!pq.isEmpty()) {
					Node temp2 = pq.poll();
					int curr2 = temp2.s;
					int time2 = temp2.time;
					if (curr2 == n.s)
						return time2;
					for (Node node2 : map[curr2]) {
						int next2 = node2.e;
						int nodeTime2 = node2.time;
						int nextTime2 = nodeTime2 + time2;
						if (minTime[next2] > nextTime2) {
							minTime[next2] = nextTime2;
							pq.offer(new Node(next2, nextTime2));
						}
					}
				}
			}

			for (Node node : map[curr]) {
				int next = node.e;
				int nodeTime = node.time;
				int nextTime = nodeTime + time;
				if (minTime[next] > nextTime) {
					minTime[next] = nextTime;
					pq.offer(new Node(next, nextTime));
				}
			}
		}
		return 0;
	}

	private static void init() {
			Arrays.fill(minTime, INF);
	}
}
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
			return Integer.compare(this.e, o.e);
		}
	}

	static int INF = Integer.MAX_VALUE;
	static int X, N, M, T;
	static int S, G, H;
	static List<Node>[] map;
	static int[] min;
	static int midStart, midEnd;
	static int[] target;
	static List<Integer> res;
//	S -> g[]  중 어디있는지 찾기.
//
//	n 교차로
//	m 도로
//	t 목적지
//
//
//	a~b d 거리 (양방향)

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		for (int t = 0; t < X; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // vertex
			M = Integer.parseInt(st.nextToken()); // edge
			T = Integer.parseInt(st.nextToken()); // 목표 위치 개수

			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken()); // 시작위치
			midStart = Integer.parseInt(st.nextToken()); // 지나간 곳1
			midEnd = Integer.parseInt(st.nextToken()); // 지나간곳2
			map = new ArrayList[N + 1];

			for (int i = 1; i < N + 1; i++) {
				map[i] = new ArrayList();
			}
			min = new int[N + 1];
			for (int i = 1; i < M + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				map[start].add(new Node(end, dis));
				map[end].add(new Node(start, dis));

			}
			target = new int[T];
			for (int i = 0; i < T; i++) {
				target[i] = Integer.parseInt(br.readLine());
			}
			Arrays.fill(min, INF);
			int temp = Integer.MAX_VALUE;
			res = new ArrayList();
			for (int i = 0; i < T; i++) {
				int compare1 = predictDis(S, midStart, midEnd, target[i]);
				int compare2 = dijkstra(S, target[i]);
				if(compare1==compare2) res.add(target[i]);
			}
			Collections.sort(res);
			for (int fin : res) {
				System.out.print(fin+" ");
			}
			System.out.println();
		}
	}

	private static int predictDis(int s, int midStart, int midEnd, int e) {
		int res = 0;
		int res2 = 0;
		res += dijkstra(s, midStart);
		res += dijkstra(midStart, midEnd);
		res += dijkstra(midEnd, e);
		res2 += dijkstra(s, midEnd);
		res2 += dijkstra(midEnd, midStart);
		res2 += dijkstra(midStart, e);
		return Math.min(res, res2);

	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		Arrays.fill(min, INF);
		min[start] = 0;
		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			int curr = temp.v;
			int dis = temp.e;
			if (curr == end)
				return dis;
			for (Node node : map[curr]) {
				int next = node.v;
				int nextDis = node.e;
				if (min[next] > nextDis + dis) {
					min[next] = nextDis + dis;
					pq.offer(new Node(next, nextDis + dis));
				}
			}
		}
		return 0;
	}

}
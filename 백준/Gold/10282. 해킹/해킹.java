import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int v;
		int e;
		int cnt;

		public Node(int v, int e) {
			super();
			this.v = v;
			this.e = e;
		}

		public Node(int v, int e, int cnt) {
			super();
			this.v = v;
			this.e = e;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.e - o.e;
		}

	}

	static int T;
	static int N, D, C;
	static int[] min;
	static List<Node>[] map;
	static boolean[] visited;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // v
			D = Integer.parseInt(st.nextToken()); // e
			C = Integer.parseInt(st.nextToken()); // 해킹컴
			map = new ArrayList[N + 1];
			min = new int[N+1];
			visited = new boolean[N+1];
			Arrays.fill(min,INF);
			for (int i = 1; i < N + 1; i++)
				map[i] = new ArrayList<>();
				
			for (int i = 1; i < D + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				map[end].add(new Node(start, time));
			}
			dijkstra();
			int cnt =0;
			int res = 0;
			for (int a : min) {
				if(a==Integer.MAX_VALUE) continue;
				res = Math.max(a,res);
			}
			
			for (int i = 1; i < N+1; i++) if(visited[i]) cnt++;
			System.out.print(cnt+" ");
			System.out.println(res);
		}
		

	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		min[C] = 0;
		pq.offer(new Node(C, 0, 1));
		Node res=null;
		visited[C] = true;
		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			int curr = temp.v;
			int time = temp.e;
			int cnt = temp.cnt;

			for (Node node : map[curr]) {
				
				int next = node.v;
				int nextTime = node.e;
				cnt = cnt+1;
				visited[next]= true;
				if (min[next] > nextTime + time) {
					min[next] = nextTime + time;
					res = new Node(next,nextTime+time,cnt);
					pq.offer(res);
				}
			}
		}
	}
}
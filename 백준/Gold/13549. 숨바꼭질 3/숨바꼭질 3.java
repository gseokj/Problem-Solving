import java.io.*;
import java.util.*;

public class Main {
	static int S, E;
	static int[] minCnt;
	static int[] dL = { 1, -1, 2 };
	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int loc;
		int cnt;

		public Node(int loc, int cnt) {
			super();
			this.loc = loc;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(cnt, o.cnt);
		}
	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		minCnt = new int[100001];
		Arrays.fill(minCnt, INF);
		dijkstra();
		System.out.println(minCnt[E]);
		
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(S,0));
		minCnt[S] = 0;
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int currLoc = temp.loc;
			int cnt = temp.cnt;
			if(currLoc==E) break;
			for (int d = 0; d < 3; d++) {
				int nLoc= 0;
				int nextCnt = cnt;
				if(d==0) {
					if(currLoc>E) continue;
					nLoc = dL[d] + currLoc;
					nextCnt = cnt+1;
				}
				else if(d==1) {
					nLoc = dL[d] + currLoc;
					nextCnt = cnt+1;
					
				}
				else {
					if(currLoc>E) continue;
					nLoc = dL[d] * currLoc;
				}
				if (!check(nLoc)) continue;
				if(minCnt[nLoc] > nextCnt) {
					minCnt[nLoc] = nextCnt;
					pq.offer(new Node(nLoc,nextCnt));
				}
			}
		}

	}

	private static boolean check(int l) {
		return l >= 0 && l < 100001;
	}

}
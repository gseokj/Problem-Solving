import java.util.*;
import java.io.*;

public class Main {
	static int N, K;

	static class Gem implements Comparable<Gem> {
		int m;
		int v;

		public Gem(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Gem o) {
			return m - o.m;
		}


	}

	static PriorityQueue<Integer> pq;
	static PriorityQueue<Integer> bags;
	static PriorityQueue<Gem> gems;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue(Collections.reverseOrder());
		bags = new PriorityQueue<Integer>();
		gems = new PriorityQueue();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			gems.add(new Gem(m, v));
		}
		for (int i = 0; i < K; i++) {
			bags.offer(Integer.parseInt(br.readLine()));
		}
		Long res = 0L;
		while (!bags.isEmpty()) {
			int bag = bags.poll();
			while (!gems.isEmpty() && gems.peek().m <= bag) {
				pq.offer(gems.poll().v);
			}
			if (!pq.isEmpty()) {
				res += pq.poll();
			}
		}
		System.out.println(res);
	}
}
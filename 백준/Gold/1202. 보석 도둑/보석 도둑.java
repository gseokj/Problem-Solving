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
				if (o.m == this.m)
					return o.v - this.v;
				else
					return this.m - o.m;
			}
	
			@Override
			public String toString() {
				return "Gem [m=" + m + ", v=" + v + "]";
			}
	
		}
	
		static PriorityQueue<Integer> pq;
		static List<Gem> gems = new ArrayList();
		static List<Integer> bag;
	
		public static void main(String[] args) throws Exception {
			//System.setIn(new FileInputStream("src/input.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue(Collections.reverseOrder());
			bag = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				gems.add(new Gem(m, v));
			}
			Long res = 0L;
			int max = 0;
			Collections.sort(gems);
			for (int i = 0; i < K; i++) {
				int m = Integer.parseInt(br.readLine());
				max = Math.max(max, m);
				bag.add(m);
			}
			Collections.sort(bag);
	        for (int i = 0, j = 0; i < K; i++) {
	            while (j < N && gems.get(j).m <= bag.get(i)) {
	                pq.offer(gems.get(j).v);
	                j++;
	            }
	            if (!pq.isEmpty()) {
	                res += pq.poll();
	            }
	        }
	        System.out.println(res);
			
		}
	}
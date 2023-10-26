import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int idx;
		int num;
		public Node(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}
		@Override
		public int compareTo(Node o) {
			return o.idx-this.idx;
		}
	}
	static int N;
	static int[] arr;
	static PriorityQueue<Node> res;
	static Deque<Node> que;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		res = new PriorityQueue();
		que = new ArrayDeque();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = N-1; i > -1; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			while(!que.isEmpty()&&que.peek().num<arr[i]) {
				res.offer(new Node(que.poll().idx,N-i));
			}
			que.offerFirst(new Node(i+1,arr[i]));
		}
		while(!que.isEmpty()) {
			res.offer(new Node(que.poll().idx,0));
		}
		while(!res.isEmpty()) {
			System.out.print(res.poll().num+" ");
		}
	}

}
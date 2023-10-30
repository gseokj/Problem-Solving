import java.util.*;
import java.io.*;

public class Main {
	static long[] tree;
	static long[] nums;
	static int N, M, K;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new long[N + 1];
		tree = new long[4 * N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				
				update(1, N, 1,b,c);
			} else {
				System.out.println(sum(1,N,1,b,c));
			}
		}
	}

	private static long sum(int start, int end, int node, int left, int right) {
		if(left>end || right<start) return 0;
		if(left<=start && end<=right) return tree[node];
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right);
	}

	private static void update(int start, int end, int node, int idx, int dif) {
		if(idx<start || idx>end) return;
		tree[node] +=dif;
		if(start==end) return;
		int mid = (start+end)/2;
		update(start,mid,node*2,idx,dif);
		update(mid+1,end,node*2+1,idx,dif);
	}
}
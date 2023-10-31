import java.util.*;
import java.io.*;

public class Main {
	static long[] tree;
	static long[] tree2;
	static long[] nums;
	static int N,M,K;
	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new long[4*N];
		tree2 = new long[4*N];
		nums = new long[N+1];
		for (int i = 1; i < N+1; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		init(1,N,1);
		init2(1,N,1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
				System.out.println(sum(1,N,1,a,b)-sum2(1,N,1,a,b));
		}
	}
	private static long sum (int start, int end, int node, int left, int right) {
		if(left>end || right <start) return 0;
		if(left<=start && end <=right) return tree2[node];
		int mid = (start+end)/2;
		return Math.max(sum(start,mid,node*2,left,right),sum(mid+1,end,node*2+1,left,right));
	}
	private static long sum2 (int start, int end, int node, int left, int right) {
		if(left>end || right <start) return Integer.MAX_VALUE;
		if(left<=start && end <=right) return tree[node];
		int mid = (start+end)/2;
		return Math.min(sum2(start,mid,node*2,left,right),sum2(mid+1,end,node*2+1,left,right));
	}
	private static Long init(int start, int end, int node) {
		if(start==end) return tree[node] = nums[start];
		int mid = (start+end)/2;
		return tree[node] = Math.min(init(start,mid,node*2),init(mid+1,end,node*2+1));
	}
	private static Long init2(int start, int end, int node) {
		if(start==end) return tree2[node] = nums[start];
		int mid = (start+end)/2;
		return tree2[node] = Math.max(init2(start,mid,node*2),init2(mid+1,end,node*2+1));
	}

}
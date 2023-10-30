import java.util.*;
import java.io.*;

public class Main {
	static long[] tree;
	static long[] nums;
	static int N,M,K;
	static StringBuilder sb ;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new long[N+1];
		tree = new long[4*N];
		for (int i = 1; i < N+1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		init(1,N,1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) { //update
				nums[b] = c;
				update(1,N,1,b);
			}else {
				sb.append(sum(1,N,1,b,(int)c)+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	private static long init(int start, int end, int node) {
		if(start==end) return tree[node] = nums[start];
		int mid = (start+end)/2;
		return tree[node] = Math.min(init(start,mid,node*2),init(mid+1,end,node*2+1));
	}
	private static long sum(int start, int end, int node, int left, int right) {
		if(left>end || right<start) return Integer.MAX_VALUE;
		if(left<=start && end<=right) return tree[node];
		int mid =(start+end)/2;
		return Math.min(sum(start,mid,node*2,left,right), sum(mid+1,end,node*2+1,left,right));
	}
	private static long update(int start, int end, int node, int idx) {
		if(start>idx || end<idx) return tree[node];
		if(start==end) return tree[node] = nums[start];
		int mid =(start+end)/2;
		return tree[node] = Math.min(update(start,mid,node*2,idx),update(mid+1,end,node*2+1,idx));
	}
	

}
import java.util.*;
import java.io.*;

public class Main {
	static int[] tree;
	static int[] nums;
	static int N,M,K;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N*4];
		nums = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		init(1,N,1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(find(1,N,1,a,b)+"\n");
		}
		System.out.println(sb.toString());
		
	}
	private static int find(int start, int end, int node, int left, int right) {
		if(left>end || right<start) return Integer.MAX_VALUE;
		if(left<=start && end<=right) return tree[node];
		int mid = (start+end)/2;
		return Math.min(find(start,mid,node*2,left,right), find(mid+1,end,node*2+1,left,right));
	}
	private static int init(int start, int end, int node) {
		if(start==end) return tree[node] = nums[start];
		int mid = (start+end)/2;
		return tree[node] = Math.min(init(start,mid,node*2),init(mid+1,end,node*2+1));
	}

}
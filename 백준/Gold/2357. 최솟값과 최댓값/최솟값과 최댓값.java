import java.util.*;
import java.io.*;

public class Main {
	static int[] tree;
	static int[] treeR;
	static int[] nums;
	static int min;
	static int max;
	static int N,M,K;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N*4];
		treeR = new int[N*4];
		nums = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		init(1,N,1);
		initR(1,N,1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			max = 0;
			int r1 =find(1,N,1,a,b);
			int r2=findR(1,N,1,a,b);
			System.out.println(r1+" "+r2);

		}
	}
	private static int init(int start, int end, int node) {
		if(start==end) return tree[node] = nums[start];
		int mid = (start+end)/2;
		return tree[node] = Math.min(init(start,mid,node*2),init(mid+1,end,node*2+1));
	}
	
	private static int find(int start, int end, int node, int left, int right) {
		if(left>end || right<start) return Integer.MAX_VALUE;
		if(left<=start && end<=right) {
			return tree[node];
		}
		int mid = (start+end)/2;
		return Math.min(find(start,mid,node*2,left,right),find(mid+1,end,node*2+1,left,right));
	}
	private static int initR(int start, int end, int node) {
		if(start==end) return treeR[node] = nums[start];
		int mid = (start+end)/2;
		return treeR[node] = Math.max(initR(start,mid,node*2),initR(mid+1,end,node*2+1));
	}
	
	private static int findR(int start, int end, int node, int left, int right) {
		if(left>end || right<start) return 0;
		if(left<=start && end<=right) {
			return treeR[node];
		}
		int mid = (start+end)/2;
		return Math.max(findR(start,mid,node*2,left,right),findR(mid+1,end,node*2+1,left,right));
	}


}
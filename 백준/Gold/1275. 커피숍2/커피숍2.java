import java.util.*;
import java.io.*;

public class Main {
	static long[] tree;
	static long[] nums;
	static int N,M,K;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new long[4*N];
		nums = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		init(1,N,1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(x<y)
			System.out.println(sum(1,N,1,x,y));
			else
				System.out.println(sum(1,N,1,y,x));
			long dif = b-nums[a];
			nums[a] = b;
			update(1,N,1,a,dif);
			
			
			
		}
	}
	private static long sum (int start, int end, int node, int left, int right) {
		if(left>end || right <start) return 0;
		if(left<=start && end <=right) return tree[node];
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right);
	}
	private static void update(int start, int end, int node, int idx, long dif) {
		if(idx<start || idx>end) return;
		tree[node]+=dif;
		if(start==end) return;
		int mid  = (start+end)/2;
		update(start,mid,node*2,idx,dif);
		update(mid+1,end,node*2+1,idx,dif);
	}
	private static Long init(int start, int end, int node) {
		if(start==end) return tree[node] = nums[start];
		int mid = (start+end)/2;
		return tree[node] = init(start,mid,node*2) + init(mid+1,end,node*2+1) ;
	}

}
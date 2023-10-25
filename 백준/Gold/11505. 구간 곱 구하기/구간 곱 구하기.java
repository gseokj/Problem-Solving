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
		K = Integer.parseInt(st.nextToken());
		tree = new long[4*N];
		nums = new long[N+1];
		for (int i = 1; i < N+1; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		init(1,N,1);
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				long dif = c;
				update(1,N,1,b,dif);
				nums[b] = c;
//				init(1,N,1);
			}else {
				System.out.println(sum(1,N,1,b,(int)c));
			}
			
		}
	}
	private static long sum (int start, int end, int node, int left, int right) {
		if(left>end || right <start) return 1;
		if(left<=start && end <=right) return tree[node];
		int mid = (start+end)/2;
		return ((sum(start,mid,node*2,left,right))%1000000007*(sum(mid+1,end,node*2+1,left,right))%1000000007)%1000000007;
	}
	private static Long update(int start, int end, int node, int idx, long dif) {
		if(idx<start || idx>end) return tree[node];
		tree[node]=tree[node]/idx*dif;
		if(start==end) return tree[node]=dif;
		int mid  = (start+end)/2;
		return tree[node]=(update(start,mid,node*2,idx,dif)%1000000007*update(mid+1,end,node*2+1,idx,dif)%1000000007)%1000000007;
	}
	private static Long init(int start, int end, int node) {
		if(start==end) return tree[node] = nums[start];
		int mid = (start+end)/2;
		return tree[node] = ((init(start,mid,node*2)%1000000007) * (init(mid+1,end,node*2+1))%1000000007) %1000000007;
	}

}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static long[] nums,tree;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 총 개수
		int M = Integer.parseInt(st.nextToken()); // 변경 횟수
		int K = Integer.parseInt(st.nextToken()); // 합을 구하는 횟수
		nums = new long[N+1];
		tree = new long[4*N];
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
				long dif = c -nums[b];
				nums[b] = c;
				update(1,N,1,b,dif);
			}else {
				System.out.println(sum(1,N,1,b,(int)c));
			}
		}
		
		
		}
	static long init(int start, int end, int node) {
		if(start==end) return tree[node] = nums[start];
		int mid=(start+end)/2;
		return tree[node] = init(start,mid,node*2)+init(mid+1,end,node*2+1);
	}
	static long sum(int start, int end, int node, int left, int right) {
		if(left>end||right<start) return 0;
		if(left<=start&&end<=right) return tree[node];
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right);
	}
	static void update(int start, int end, int node, int index, long dif) {
		if(index<start||index>end) return;
		tree[node]+=dif;
		if(start==end) return;
		int mid = (start+end)/2;
		update(start,mid,node*2,index,dif);
		update(mid+1,end,node*2+1,index,dif);
	}
}
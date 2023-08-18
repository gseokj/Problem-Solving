import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int cnt;
	public static void main(String[] args) {
		Scanner scann  = new Scanner(System.in);
		int a = scann.nextInt();
		System.out.println(bfs(a));
//		dfs(a);
	}

//	private static void dfs(int a,int cnt) {
//	}

	private static int bfs(int a) {
		Queue<int []> que = new ArrayDeque<>();
		que.offer(new int [] {a,0});
		while(!que.isEmpty()) {
			int[] t = que.poll();
			int b = t[0];
			int bb = t[1];
			if(b==1) {
				return bb;
			}
			if(b%3==0) {
				int temp = b/3;
				que.offer(new int[] {temp,bb+1});
			}
			if(b%2==0) {
				int temp = b/2;
				que.offer(new int[] {temp,bb+1});
			}
			int temp = b-1;
			que.offer(new int[] {temp,bb+1});
			
		}
		return -1;
		
	}

}
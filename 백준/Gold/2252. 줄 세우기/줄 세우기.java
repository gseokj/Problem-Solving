import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static List<Integer>[] arr;
	static int degree[];

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		N = scann.nextInt();
		M = scann.nextInt();

		arr = new ArrayList[N + 1];
		degree = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int from = scann.nextInt();
			int to = scann.nextInt();
			arr[from].add(to);
			degree[to] ++;
		}
		
		ts(arr,degree);
	}

	private static void ts(List<Integer>[] arr, int[] degree) {
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i < N+1; i++) {
			if(degree[i] == 0) {
				que.offer(i);
			}
		}
		while(!que.isEmpty()) {
			System.out.print(que.peek()+" ");
			int cur = que.poll();
			
			for (int i = 0; i < arr[cur].size(); i++) {
				int to = arr[cur].get(i);
				degree[to]--;
				if(degree[to] == 0) {
					que.offer(to);
				}
			}
		}
		
		
	}
}
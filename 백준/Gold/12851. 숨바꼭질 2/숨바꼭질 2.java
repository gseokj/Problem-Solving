import java.util.*;
import java.io.*;
public class Main {
	static int N,K,res_cnt;
	static int[] nd= {-1,1,2};
	static int[] visited;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		visited = new int[100002];
		res_cnt = 0;
		if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }
		
		bfs();
		System.out.println(visited[K]);
		System.out.println(res_cnt);
	}

	

	private static void bfs() {
		Queue<Integer> que = new ArrayDeque();
		que.offer(N);
		while(!que.isEmpty()) {
			int curr = que.poll();
			if(visited[curr] > K) return;
			if (curr==K) {
				res_cnt++;
			}
			for (int i = 0; i < 3; i++) {
				int next;
				if (i!=2)next = curr+nd[i];
				else next=curr * nd[i];
				if(!check(next)) continue;
				if(visited[next]==0 ||(visited[next] !=0 && visited[curr]+1 == visited[next])) {
					visited[next] = visited[curr] +1;
					que.offer(next);
				}
			}
		}
		
	}



	private static boolean check(int n) {
		return n>=0 && n<K+2;
	}

}
import java.util.*;
import java.io.*;

public class Main {
	static int r,c,w;
	static int N,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[]dr = {-1,0,1,0};
	static int[]dc = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		w=2;
		cnt=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]== 9) {
					r = i;
					c = j;
					map[i][j] = 0;
				}
			}
		}
		int t_Move = 0;
		int feed = 0;
		while(true) {
			init();
			int move = search();
			if (move==-1) break;
			t_Move+=move;
			feed++;
			if(feed==w) {
				w++;
				feed=0;
			}
		}
		System.out.println(t_Move);
		
		
	}
	
	

	private static int search() {
	    int tempR = r;
	    int tempC = c;
	    int weight = w;
	    
	    visited[r][c] = true;
	    Queue<int[]> que = new ArrayDeque();
	    que.offer(new int[] {tempR, tempC, 0});
	    
	    int min_r = Integer.MAX_VALUE;
	    int min_c = Integer.MAX_VALUE;
	    int result=Integer.MAX_VALUE;
	    while (!que.isEmpty()) {
	        int[] temp = que.poll();
	        int rr = temp[0];
	        int cc = temp[1];
	        int dis = temp[2];

	        if (map[rr][cc] < weight && map[rr][cc] != 0 && result>=dis) {
	            if (min_r == rr) {
	                if (min_c > cc) {
	                    min_r = rr;
	                    min_c = cc;
	                }
	            } else if (min_r > rr) {
	                min_r = rr;
	                min_c = cc;
	            }
	            
	            result = dis;
	            
	        }

	        for (int d = 0; d < 4; d++) {
	            int nr = rr + dr[d];
	            int nc = cc + dc[d];
	            if (!check(nr, nc) || weight < map[nr][nc] || visited[nr][nc]) continue;
	            visited[nr][nc] = true;
	            que.offer(new int[] {nr, nc, dis + 1});
	        }
	    }
	    if(min_r == Integer.MAX_VALUE && min_c==Integer.MAX_VALUE)
	    	return -1;
	    else {
	    	map[min_r][min_c] = 0;
	    	r = min_r;
            c = min_c;
	    	return result;
	    }
	}



	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
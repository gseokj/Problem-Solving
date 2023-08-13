import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] selected;
	static int res;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		selected = new int[101][101];
		for (int x = 0; x < N; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
						selected[i][j] = 1;
				}

			}
			

		}
		res=0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(selected[i][j] ==1) {
					bfs(i,j);
				}
			}
		}
        System.out.println(res);
    }
	
	private static void bfs(int r,int c) {
		
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(selected[nr][nc] ==0) res++;
				
				
			}
		}
	


}
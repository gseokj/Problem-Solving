import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[] dr= {0,-1,-1,-1,0,1,1,1};
	static int[] dc= {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		if(m==0&&n==0) break;
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt =0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				if(map[i][j] == 1) {
					cnt++;
					dfs(i,j,cnt+1);
				
				}
			}
		}
		System.out.println(cnt);
		}
	}
	static void dfs(int r, int c, int cnt) {
		map[r][c] = cnt;
		for (int d = 0; d < 8; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc]==1) {
				map[nr][nc] =cnt;
				dfs(nr,nc,cnt);
			}
		}
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<n && c<m;
	}
}
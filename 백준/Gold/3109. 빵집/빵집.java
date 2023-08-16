import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N,M,cnt;
	static boolean flag;
	static int[][] mat;
	static boolean[][] vis;
	static int[] dr= {-1,0,1};
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		vis = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String a =st.nextToken();
			for (int j = 0; j <M; j++) {
				if(a.charAt(j)=='.') mat[i][j] = 0;
				else mat[i][j] = 1;
			}
		}
		for (int i = 0; i < N; i++) {
			flag = false;
			vis[i][0] =true;
			dfs(i,0);
			
		}
		System.out.println(cnt);
	}
	static void dfs(int r,int c) {
		if(flag) return;
		if(c==M-1) {
			flag=true;
			cnt++;
		};
		for (int d = 0; d < 3; d++) {
			int tempR = dr[d] + r; 
			int tempC = c+1;
			if(!check(tempR,tempC)) continue;
			if(!vis[tempR][tempC]) {
				if(flag) return;
				vis[tempR][tempC] = true;
				dfs(tempR,tempC);
			}
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0  && r<N && c<M && mat[r][c] == 0;
	}
}
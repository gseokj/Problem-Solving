import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] map;
	static int[][] copy;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int v;
	static int tempN, tempM;
	static boolean[][] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		
		for (int x = 0; x < R; x++) {
			tempN = N - 1;
			tempM = M - 1;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				copy[i] = map[i].clone();
				
			}

			while (tempN > 1 || tempM > 1) {
				v = 0;
				dfs(tempN, tempM);
				tempN--;
				tempM--;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				sb.append(map[i][j] + " ");

			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int n, int m) {
	    int nr = n + dr[v];
	    int nc = m + dc[v];
	    
	    if (check(nr, nc)) {
	        if (!visited[nr][nc]) {
	            visited[nr][nc] = true;
	            map[nr][nc] = copy[n][m];
	            dfs(nr, nc);
	        }
	    } else {
	        v++;
	        v %= 4;
	        nr = n + dr[v];
	        nc = m + dc[v];
	        
	        if (check(nr, nc) && !visited[nr][nc]) {
	            visited[nr][nc] = true;
	            map[nr][nc] = copy[n][m];
	            dfs(nr, nc);
	        }
	    }
	}

	private static boolean check(int r, int c) {
	    return r >= N - tempN - 1 && c >= M - tempM - 1 && r <= tempN && c <= tempM;
	}


}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] map, copy;
	static int[] dr = { 0, 1, 0, -1};
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
			}
		}
		int tempR = N;
		int tempC = M;
		for (int i = 0; i < Math.min(M, N) / 2; i++) {
			rotate(i, tempR * 2 + tempC * 2 - 4);
			tempR -= 2;
			tempC -= 2;

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void rotate(int start, int len) {
		int cnt = R%len;
			for (int i = 0; i < cnt; i++) {
				int r = start;
				int c = start;
				int v = 0;
				int temp = map[r][c]; 
				while(v<4) {
					int nr=r+dr[v];
					int nc=c+dc[v];
					if(nr==start && nc==start) break;
					if(nr>=start && nc>=start && nr<N-start && nc<M-start) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
					}else {
						v++;
					}
				}
				map[start+1][start] = temp;
				
			}
			
		}

}
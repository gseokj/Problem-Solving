import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		int res =0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int r = dr[k]+i;
						int c = dc[k]+j;
						if(map[r][c] == 0) res++; 
					}
					
				}
			}
		}
		System.out.println(res);
		
	}


}
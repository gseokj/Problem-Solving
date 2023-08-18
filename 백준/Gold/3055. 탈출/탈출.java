import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int res, T, N, M;
	static char[][] map;
	static Queue<int[]> go;
	static Queue<int[]> water;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		go = new ArrayDeque<int[]>();
		water = new ArrayDeque<int[]>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			for (int j = 0; j < M; j++) {
				char temp = a.charAt(j);
				map[i][j] = temp;
				if (temp == 'S') {
					go.offer(new int[] { i, j, 1 });
				} else if (temp == '*') {
					water.offer(new int[] { i, j });
				} else if (temp == 'D') {
				}

			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(map[i]);
//		}
		
		while(true) {
			if(go.size()==0) {
				System.out.println("KAKTUS");
				break;
			}
			bfsWater();
			int cnt = bfsGo();
			if(cnt>0) {
				System.out.println(cnt);
				break;
			}
			
		}
		
	}

	private static int bfsGo() {
		int size = go.size();
		while(size-->0) {
			int[] temp = go.poll();
			int r = temp[0];
			int c = temp[1];
			int cnt = temp[2];
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(!check(nr,nc))continue;
				if(map[nr][nc] == 'D') {
					return cnt;
				}
				if(map[nr][nc] == '.') {
					go.offer(new int[] {nr,nc,cnt+1});
					map[nr][nc] = 'S';
				}
			}
		}
		return -1;
	}

	private static void bfsWater() {
		int size = water.size();
		while(size-->0) {
			int[] temp = water.poll();
			int r =temp[0];
			int c = temp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(!check(nr,nc))continue;
				if(map[nr][nc] == '.' || map[nr][nc] == 'S') {
					water.offer(new int[] {nr,nc});
					map[nr][nc] = '*';
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}

}
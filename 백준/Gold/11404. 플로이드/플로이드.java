import java.io.*;
import java.util.*;
public class Main {
	static int[][] map; // 인접행렬로 우선
	static int N; // City
	static int B; // Bus
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		map = new int[N][N];
		init();
		for (int i = 0; i < B; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				int s =Integer.parseInt(st.nextToken())-1;
				int e =Integer.parseInt(st.nextToken())-1;
				int cost = Integer.parseInt(st.nextToken());
				
				map[s][e] = Math.min(cost,map[s][e]);
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k==i) continue;
				for (int j = 0; j < N; j++) {
					if(k==j || i==j) continue;
					map[i][j] = Math.min(map[i][k] + map[k][j],map[i][j]);
				}
			}
		}
		init2();
		print();
		
	}
	private static void init2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if(map[i][j] == Integer.MAX_VALUE/2) map[i][j]= 0;
			}
		}
		
	}
	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				map[i][j] = Integer.MAX_VALUE/2;
			}
		}
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
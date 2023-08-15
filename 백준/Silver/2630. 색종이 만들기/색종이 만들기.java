import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int white, blue;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		white = 0;
		blue = 0;
		colorPrint(N, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void colorPrint(int n, int r, int c) {
		if (is_equal(n, r, c)) {
			if (map[r][c] == 1)
				blue++;
			else
				white++;
		} else {
			int half = n / 2;
			colorPrint(half, r, c);
			colorPrint(half, r, c + half);
			colorPrint(half, r + half, c);
			colorPrint(half, r + half, c + half);
		}
	}

	private static boolean is_equal(int n, int r, int c) {
		int obj = map[r][c];
		for (int i = r; i < n + r; i++) {
			for (int j = c; j < n + c; j++) {
				if (obj != map[i][j])
					return false;
			}
		}
		return true;
	}

}
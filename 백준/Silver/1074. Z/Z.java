import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N, C, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(z(1 << N, R, C, 0));
	}

	private static int z(int n, int r, int c, int total) {
		if (n == 0)
			return total;
		int half = n / 2;
		if (r < half) {
			if (c < half) {
			} else {
				total += half * half;
				c -= half;
			}
		} else {
			if (c < half) {
				total += half * half * 2;
				r -= half; // r =3+half , c =1;
			} else {
				total += half * half * 3;
				r -= half;
				c -= half;
			}
		}

		return z(half, r, c, total);

	}
}
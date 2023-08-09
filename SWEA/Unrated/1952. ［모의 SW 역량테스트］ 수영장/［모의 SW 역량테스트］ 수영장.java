import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int res;
	static int a, b;
	static int T;

	static int[] fee;
	static int[] month;
	static int tot;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		fee = new int[4];
		month = new int[12];
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int x = 1; x < T+1; x++) {

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				int temp = Integer.parseInt(st.nextToken());
				tot += temp;
				month[i] = temp;
			}
			res = fee[3];
		
		f(0, 0);
		sb.append("#"+x+" ");
		sb.append(res+"\n");
		}
		System.out.println(sb.toString());
	}

	static void f(int m, int tot) {
		if (m>11) {
			res = Math.min(res, tot);
			return;
		}
			
			f(m+3,tot+fee[2]);
			f(m+1,tot+fee[1]);
			f(m+1,tot+fee[0]*month[m]);
		
	}
}
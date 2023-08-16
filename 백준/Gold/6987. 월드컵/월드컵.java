import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int win[], lose[], draw[], t1[], t2[];
	static boolean isPossible;
	static int w = 0, l = 0, d = 0;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		t1 = new int[15]; // 경기하는 2팀 -테이블 만들기
		t2 = new int[15];
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) { // 경기팀 배정 A-B A-C A-D A-E A-F
				t1[cnt] = i;
				t2[cnt++] = j;
			}
		}
		for (int i = 0; i < 4; i++) { // 4줄
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			win = new int[6];
			lose = new int[6];
			draw = new int[6];
			isPossible = false;
			w = 0;
			l = 0;
			d = 0;
			for (int j = 0; j < 6; j++) {
				w += win[j] = Integer.parseInt(st.nextToken());
				d += draw[j] = Integer.parseInt(st.nextToken());
				l += lose[j] = Integer.parseInt(st.nextToken());
			}
			if (w + d + l != 30)
				isPossible = false;
			else
				dfs(0);
			if (isPossible)
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}
	}

	static void dfs(int cnt) {
		if (isPossible)
			return;
		if (cnt == 15) {
			isPossible = true;
			return;
		}

		int a = t1[cnt];
		int b = t2[cnt];

		if (win[a] > 0 && lose[b] > 0) {
			win[a]--;
			lose[b]--;
			dfs(cnt + 1);
			win[a]++;
			lose[b]++;
		}
		if (draw[a] > 0 && draw[b] > 0) {
			draw[a]--;
			draw[b]--;
			dfs(cnt + 1);
			draw[a]++;
			draw[b]++;
		}
		if (lose[a] > 0 && win[b] > 0) {
			lose[a]--;
			win[b]--;
			dfs(cnt + 1);
			lose[a]++;
			win[b]++;
		}
	}
}
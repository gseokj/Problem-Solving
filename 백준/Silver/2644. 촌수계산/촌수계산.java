import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int tar;
	static int tar2;
	static boolean flag;
	static List<ArrayList<Integer>> map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n + 1; i++) {
			map.add(new ArrayList<Integer>());
		}
		st = new StringTokenizer(br.readLine());
		tar = Integer.parseInt(st.nextToken());
		tar2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.get(a).add(b);
			map.get(b).add(a);
		}
		// --------------------------------------------
		int cnt = 0;
		dfs(tar, cnt);
		if (!flag) System.out.println(-1);
	}
	private static void dfs(int tar, int cnt) {
		if (flag) return;
		if (tar == tar2) {
			System.out.println(cnt);
			flag=true;
		}
		visited[tar] = true;
		for (int x : map.get(tar)) {
			if (visited[x])
				continue;
			dfs(x, cnt + 1);
		}
	}

}
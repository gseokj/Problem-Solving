import java.util.*;
import java.io.*;

public class Main {
	static int[] tree;
	static int[] nums;
	static int N, M, K;
	static StringBuilder sb;
	static StringTokenizer st;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			tree = new int[4 * N];
			nums = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			init(1, N, 1);

			sb.append(getMax(1, N, N)+"\n");
		}
		System.out.println(sb.toString());
	}

	private static long getMax(int start, int end, int node) {
		int m = find(1, N, 1, start, end);

		long res = (end - start + 1) * (long) nums[m];
		if (start <= m - 1) {
			long tmp = getMax(start, m - 1, N);

			res = Math.max(res, tmp);
		}

		if (m + 1 <= end) {
			long tmp = getMax(m + 1, end, N);

			res = Math.max(res, tmp);
		}

		return res;
	}

	private static int find(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return -1;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		int m1 = find(start, mid, node * 2, left, right);
		int m2 = find(mid + 1, end, node * 2 + 1, left, right);

		if (m1 == -1) {
			return m2;
		} else if (m2 == -1) {
			return m1;
		} else {
			if (nums[m1] <= nums[m2]) {
				return m1;
			} else {
				return m2;
			}
		}
	}

	private static void init(int start, int end, int node) {
		if (start == end)
			tree[node] = start;
		else {
			int mid = (start + end) / 2;
			init(start, mid, node * 2);
			init(mid + 1, end, node * 2 + 1);
			if (nums[tree[node * 2]] <= nums[tree[node * 2 + 1]]) {
				tree[node] = tree[node * 2];
			} else {
				tree[node] = tree[node * 2 + 1];
			}

		}
	}

}
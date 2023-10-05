import java.io.*;
import java.util.*;

public class Main {
	static class Tree implements Comparable<Tree> {
		int r;
		int c;
		int age;

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return o.age - age;
		}

		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", age=" + age + "]";
		}

	}

	static int N, M, K;
	static int[][] map, copy;
	static Deque<Tree> trees;
	static Deque<Tree> tempTrees;
	static Deque<Tree> deadTrees;
	// (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c),
	// (r+1, c+1)
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 맵의 크기
		M = Integer.parseInt(st.nextToken()); // 나무의 개수
		K = Integer.parseInt(st.nextToken()); // 몇 년 뒤인지?

		map = new int[N][N];
		copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(map[i], 5);
			for (int j = 0; j < N; j++) {
				copy[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		trees = new ArrayDeque();
		tempTrees = new ArrayDeque();
		deadTrees = new ArrayDeque();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			if(trees.isEmpty() || trees.peek().age>age)
			trees.offerFirst(new Tree(r, c, age));
			else trees.offer(new Tree(r, c, age));
		}
		for (int i = 0; i < K; i++) {

			start_Year();
		}
		System.out.println(trees.size());
	}

	private static void start_Year() {
		spring();
		summer();
		fall();
		winter();
	}

	private static void spring() {
		int size = trees.size();
		while (size-->0) {
			Tree tree = trees.poll();
			int r = tree.r;
			int c = tree.c;
			int age = tree.age;
			if (map[r][c] >= age) {
				tree.age++;
				map[r][c] -= age;
				trees.offer(tree);
			} else {
				deadTrees.offer(tree);
			}
			
		}
	}

	private static void summer() {
		int size = deadTrees.size();
		while (size-->0) {
			Tree tree = deadTrees.poll();
			int r = tree.r;
			int c = tree.c;
			int age = tree.age;
			map[r][c] += age / 2;
		}
	}

	private static void fall() {
		int size = trees.size();
		while (size-->0) {
			Tree tree = trees.poll();
			trees.offer(tree);
			if (tree.age % 5 != 0)
				continue;
			int r = tree.r;
			int c = tree.c;
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc))
					continue;
				tempTrees.offer(new Tree(nr, nc, 1));
			}
		}
		size = tempTrees.size();
		while(size-->0) {
			trees.offerFirst(tempTrees.poll());
		}
	}

	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += copy[i][j];
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int max, min, cutting, res;
	static int[] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		max = 0;
		cutting = 0;
		min = 0;
		res = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		long total = 0;
		while(max>min) {
			cutting = (max+min)/2;
			total = 0;
			
			for (int tree : trees) {
				if(tree-cutting>0) {
					total+=tree-cutting;
				}
			}
			if(total<M) max = cutting;
			else min = cutting+1;
		}
		
		System.out.println(min-1);
	}
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int R,cal;
	static int max;
	static boolean visited[];
	static int[] scores;
	static int[] calories;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < T+1; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			R =Integer.parseInt(st.nextToken());
			cal =Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			visited = new boolean[R];
			scores = new int[R];
			calories= new int[R];
			for (int j = 0; j < R; j++) {
				st= new StringTokenizer(br.readLine());
				scores[j] =Integer.parseInt(st.nextToken());
				calories[j] =Integer.parseInt(st.nextToken());
			}
			subset(0,0,0);
			System.out.print("#"+i+" ");
			System.out.println(max);
		}
		
	}
	private static void subset(int cnt, int total_score, int total_calorie) {
		if (total_calorie>cal) return;
		if(cnt==R) {
			max = Math.max(max, total_score);
			return;
		}
		visited[cnt] =true;
		subset(cnt+1,total_score+scores[cnt],total_calorie+calories[cnt]);
		visited[cnt] =false;
		subset(cnt+1,total_score,total_calorie);
	}

}
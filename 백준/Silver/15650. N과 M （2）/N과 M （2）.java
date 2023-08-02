import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int n;
	static int r;
	static int nums[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		p = new int[n];
		for (int i = 0; i < n; i++) p[i] = i+1;
		nums = new int[r];
		perm(0,0);
		
	}

	static void perm(int cnt, int start) {
		if(cnt==r) {
			for (int i = 0; i < r; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			nums[cnt] = p[i];
			perm(cnt+1,i+1);
			nums[cnt] = 0;
		}
		
	}
}

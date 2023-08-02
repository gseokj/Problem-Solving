import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// nCr = nPr/r!
public class Main {
	static int[] p;
	static int n;
	static int r;
	static int[] nums;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		p = new int[n];
		for (int i = 0; i < n; i++) p[i] = i+1;
		nums = new int[r];
		perm(0);
		System.out.println(sb.toString());
		
	}

	static void perm(int cnt) {
		if (cnt==r) {
			for(int num:nums) {
				sb.append(num+" ");
			}
			sb.append("\n");
		return;
		}
		for (int i = 0; i < n; i++) {
			nums[cnt] = p[i];
			perm(cnt+1);
			nums[cnt]=0;
			
		}
	}
}

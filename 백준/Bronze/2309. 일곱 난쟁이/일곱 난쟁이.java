import java.util.Arrays;
import java.util.Scanner;

public class Main {
static int[] C;
static int n;
static int r;
static int[] nums;
static boolean flag;
static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = new int[9];
		n = C.length;
		r = 7;
		nums = new int[r];
		res = new int[r];
		for (int i = 0; i < 9; i++) {
			C[i] = sc.nextInt();
		}
		combi(0,0);
		for (int i = 0; i < r; i++) {
			System.out.println(res[i]);
		}
	}
	static void combi(int cnt, int start) {
		if (cnt==r) {
			int tot=0;
			for (int num : nums) {
				tot+=num;
			}
			if (tot==100) {
				Arrays.sort(nums);
				for (int i =0; i <r; i++) {
					res[i] =nums[i];
				}
			}
			return;
		}
		for (int i = start; i < n; i++) {
			nums[cnt] = C[i];
			combi(cnt+1,i+1);
			nums[cnt] = 0;
			
		}
		
	}

}
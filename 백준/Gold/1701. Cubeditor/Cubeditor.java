import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int max;

	static void computeLPSArray(String pat, int M, int[] lps) {
		int i = 1;
		lps[0] = 0;
		int len = 0;
		while(i<M) {
			if(pat.charAt(len)==pat.charAt(i)) {
				len++;
				lps[i] = len;
				max = Math.max(len,max);
				i++;
			}
			
			else {
				if(len!=0) {
					len = lps[len-1];
				}else {
					i++;
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pat = br.readLine();
		max = 0;
		for (int i = 0; i < pat.length(); i++) {
			int M = pat.length()-i;
			String pat2 = pat.substring(i);
			int[] lps = new int[M];
			computeLPSArray(pat2,M,lps);
		}
		if(max>1) {
			System.out.println(max);
		}else {
			System.out.println(0);
		}
	}

}
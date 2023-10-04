import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int cnt;
	static StringBuilder sb;
	static void KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		int lps[] = new int[M];
		int j = 0;
		computeLPSArray(pat, M, lps);

		int i = 0;
		while ((N - i) >= (M - j)) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				cnt++;
				sb.append(i - j+1+"\n");
				j = lps[j - 1];
			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	static void computeLPSArray(String pat, int M, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;

		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					i = i + 1;
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String txt = br.readLine();
		String pat = br.readLine();
		sb = new StringBuilder();
		cnt = 0;
		int M = pat.length();
		int N = txt.length();
		KMPSearch(pat, txt);
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

}
import java.io.*;
import java.util.*;

public class Main {
	static String txt;
	static int M;
	static int[] lps;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			txt =br.readLine();
			if(txt.equals(".")) break;
			M = txt.length();
			lps = new int[M];
			computeLPSArrays(txt,M,lps);
			int a = lps[0];
			int zeroCnt = M - lps[M-1];
            if (M % zeroCnt != 0) System.out.println(1);
            else System.out.println(M/zeroCnt);
		}
	}
	private static void computeLPSArrays(String txt, int m, int[] lps) {
		int i = 1;
		lps[0] = 0;
		int len = 0;
		while(m>i) {
			if(txt.charAt(i)==txt.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}else {
				if(len!=0) {
					len = lps[len-1];
				}else {
					i++;
				}
			}
		}
	}
}
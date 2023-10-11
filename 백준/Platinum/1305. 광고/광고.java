import java.io.*;
import java.util.*;

public class Main {
	static int L;
	static String lit;
	static StringBuilder txt;
	static StringBuilder path;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		lit = br.readLine();
		int res = 0;
		int[] lps = new int[lit.length()];
		computeLPSArrasy(lit.toString(),lit.length(),lps);
		System.out.println(L-lps[lit.length()-1]);
	}

	private static void computeLPSArrasy(String path, int m, int[] lps) {
		int i = 1;
		int len = 0;
		lps[0] = 0;
		while(i<m) {
			if(path.charAt(i)==path.charAt(len)) {
				len++;
				lps[i] = len;
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
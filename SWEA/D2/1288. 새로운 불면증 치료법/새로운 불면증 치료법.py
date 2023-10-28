import java.util.*;
import java.io.*;

public class Solution {
	static int T,N;
	static int nums;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int res = (1<<10)-1;
		
		for (int i = 1; i < T+1; i++) {
			int cnt = 0;
			nums = 0;
			char b= 'a';
			N = Integer.parseInt(br.readLine());
			int n = N;
			while(nums!=res) {
				cnt++;
				char[] sheep = String.valueOf(n).toCharArray();
				for (int j = 0; j < sheep.length; j++) {
					
					nums = nums|1<<(int)sheep[j]-'0';
				}
				
				n+=N;
			}
			System.out.println("#"+i+" "+N*cnt);
		}
	}
}
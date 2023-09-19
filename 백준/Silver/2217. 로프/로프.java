import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int arr[];
	static int res;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		arr = new int[N];
		res = 0;
		int cnt = N;
		while(cnt>0) {
			cnt--;
			arr[cnt] = scann.nextInt();
		}
		Arrays.sort(arr);
		cnt = N;
		while(cnt>0) {
			cnt--;
			 res = Math.max(arr[cnt]*(N-cnt),res);
		}
		System.out.println(res);
	}
}
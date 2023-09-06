import java.io.*;
import java.util.*;
public class Main {
	static char[] S;
	static Deque<Character> deq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String temp  = br.readLine();
		deq = new ArrayDeque<>();
		int idx = temp.length();
		S = new char[idx];
		for (int i = 0; i < idx; i++) {
			S[i] = temp.charAt(i);
		}
		for (char a : S) {
			if(deq.isEmpty()) {
				deq.add(a);
			}else if(deq.peek()>=a) {
				deq.offerFirst(a);
			}else {
				deq.offerLast(a);
			}
		}
		for (char a : deq) {
			sb.append(a);
		}
		System.out.println(sb.toString());

	}

}
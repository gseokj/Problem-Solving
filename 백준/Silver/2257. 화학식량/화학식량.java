import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static String input;
	static Stack<Integer> st = new Stack<>();
	static int value;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		
		for (int i = 0; i < input.length(); i++) {
			
			char c = input.charAt(i);
			int temp =0;
			
			if(c == '(') { 
				st.push(0);
				
			}else if (c == ')') { 
				
				while (true) {
					int n = st.pop();
					if(n == 0) break;
					temp += n;
				}
				st.push(temp);
				
			}else if((int)c>49 &&(int)c<=57) { 
				temp = st.pop();
				temp *= (int)c-'0';
				st.push(temp);
				
			}else { 
				
				switch (c) {
				case 'H': {
					st.push(1);
					break;
				}
				case 'C': {
					st.push(12);
					break;
				}
				case 'O': {
					st.push(16);
					break;
				}
				}
			}
		}
		
		
		
		while (!st.isEmpty()) {
			value+=st.pop();
		}
		
		System.out.println(value);
		
		
	}

}
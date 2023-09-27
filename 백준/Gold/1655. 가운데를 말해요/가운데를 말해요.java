import java.util.*;
import java.io.*;
public class Main {
	static PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
	
	static PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	static StringBuilder sb;
	static int N;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		min.offer(Integer.parseInt(br.readLine()));
		sb.append(min.peek()+"\n");
		for (int i = 1; i < N; i++) {
			int next = Integer.parseInt(br.readLine());
			if(max.size()==min.size()) {
				if(max.peek()>next) {
					min.offer(max.poll());
					max.offer(next);
					sb.append(min.peek()+"\n");
				}else {
					min.offer(next);
					sb.append(min.peek()+"\n");
				}
				
			}else {
				if(min.peek()<next) {
					max.offer(min.poll());
					min.offer(next);
					sb.append(max.peek()+"\n");
				}else {
					max.offer(next);
					sb.append(max.peek()+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
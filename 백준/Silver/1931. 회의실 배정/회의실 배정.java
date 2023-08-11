import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Room{
		private int start;
		private int end;
		
		public Room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		

		public int getStart() {
			return start;
		}


		public void setStart(int start) {
			this.start = start;
		}


		public int getEnd() {
			return end;
		}


		public void setEnd(int end) {
			this.end = end;
		}


		public Room() {
			super();
		}


		@Override
		public String toString() {
			return "start : " + start + "  end : " + end;
		}
		
	}
	static int N;
	static int cnt;
	static int cur;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Room> rooms = new ArrayList<>();
		cnt=0;
		cur=0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			rooms.add(new Room(a,b));
		}
		rooms.sort((o1, o2) -> o1.getEnd()-o2.getEnd()==0 ? o1.getStart()-o2.getStart() :o1.getEnd()-o2.getEnd() );
		
		
		
		cur = rooms.get(0).getEnd();
		cnt++;
		for (int i = 1; i < N; i++) {
			if (cur>rooms.get(i).getStart()) continue;
			else {
				cnt++;
				cur = rooms.get(i).getEnd();
			};
			
		}
		System.out.println(cnt);
	}
}
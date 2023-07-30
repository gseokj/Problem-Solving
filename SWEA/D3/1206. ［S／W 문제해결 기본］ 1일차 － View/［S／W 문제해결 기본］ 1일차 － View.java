import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) {
		try {
			int x = 10;
			//System.setIn(new FileInputStream("input.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			for (int i = 1; i < x+1; i++) {
				List<Integer> lis = new ArrayList<>();
				int res = 0;
				int idx,sub;
				idx = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < idx; j++) {
					lis.add(Integer.parseInt(st.nextToken()));
				}
			for (int j = 2; j < idx-2; j++) {
					int lMax, rMax,max= 0;
					lMax = Math.max(lis.get(j-2),lis.get(j-1));
					rMax = Math.max(lis.get(j+2),lis.get(j+1));
					max = Math.max(lMax,rMax);
					sub = lis.get(j)-max;
					if (sub>0) {
						res+=sub;
						
					}
				}
			System.out.println("#"+i+" "+res);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

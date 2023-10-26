import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static class Node{
		int s;
		int e;
		public Node(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		
		
	}
	static StringTokenizer st;
	static int[] r;
	static int[] p;
	static Queue<Node> que;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		r = new int[N];
		p = new int[N];
		que = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int e=Integer.parseInt(st.nextToken());
				if(e==0) continue;
				que.add(new Node(i,j));
			}
			
		}
		makeSet();
		while(!que.isEmpty()) {
			Node node = que.poll();
			union(node.s,node.e);
		}
		StringTokenizer st= new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken())-1;
		boolean flag = true;
		while(st.hasMoreTokens()) {
			int e = Integer.parseInt(st.nextToken())-1;
			if(find(s)!=find(e)) {
				flag = false;
				break;
			}
			s = e;
		}
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			r[i] = 1;
			p[i] = i;
		}
	}
	private static int find(int x) {
		if(p[x]==x) return p[x];
		else return p[x] = find(p[x]);
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		if(r[x]>r[y]) {
			r[x]+=r[y];
			p[y]=x;
		}else {
			r[y]+=r[x];
			p[x]=y;
		}
		return true;
	}

}
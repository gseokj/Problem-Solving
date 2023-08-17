import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int T, N=200;
	static int x1, x2,y1,y2;
	static int [] dr= {-1,0,1, 0};
	static int [] dc= { 0,1,0,-1};  // 상우하좌 d=0,2, d=1,3
	static int[][][] visited;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
			Scanner scann=new Scanner(System.in);
			T=scann.nextInt();
			for (int t = 1; t <= T; t++) {
				x1=scann.nextInt()+100;
				y1=scann.nextInt()+100;
				x2=scann.nextInt()+100;
				y2=scann.nextInt()+100;
				// Reading
				// 로직시작
				visited=new int[N+1][N+1][2];
				Queue<int[]> que=new LinkedList<>();
				que.offer(new int[] {x1,y1,0,0});  // 거리, 방향  dir=0, d=0,2, d=1,3 양옆
				que.offer(new int[] {x1,y1,0,1});  // 거리, 방향  dir=0, d=0,2, d=1,3 위아래
				visited[x1][y1][0]=1;  // dir0
				visited[x1][y1][1]=1;  // dir1
				int value=-1;
				while(!que.isEmpty()) {
					int [] cur=que.poll();
					int r=cur[0];
					int c=cur[1];
					int cnt=cur[2];
					int dir=cur[3];
					if(r==x2 && c==y2) {
						value=cnt;
						break;
					}
					for (int d = 1; d < 4; d+=2) {
						int s=(dir+d)%4;  // 0+1 -> 1    1+1=> 2
						int u=(dir+d)%2;  // new dir 
						int nr=r+dr[s];
						int nc=c+dc[s];
						if(!check(nr,nc))continue;
						if(visited[nr][nc][u]==0) {
							visited[nr][nc][u]=1;
							que.offer(new int[] {nr,nc,cnt+1,u});
						}
					}
				}
				// 출력
				System.out.println("#"+t +" "+value);
			}

		}

		static boolean check(int r, int c) {
			return r>=0 && r<N+1 && c>=0 && c<N+1;
		}}
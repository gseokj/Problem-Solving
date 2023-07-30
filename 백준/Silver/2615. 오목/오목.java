import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int n = 19;
	final static int[] dr = {1,1,1,0};
	final static int[] dc = {-1,0,1,1};
	static int stone;
	static int cnt;
	static int[] cur;
	public static void main(String[] args) {
		try {
			cur = new int[2];
			int[][] mat = new int[n][n];
			// System.setIn(new FileInputStream("input.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			exitloop:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tempR = i;
					int tempC = j;
					stone = mat[i][j]; // 시작한 시점의 돌색
					cur[0] = tempR;
					cur[1] = tempC;
					if (stone ==0) continue;
					for (int v = 0; v < 4; v++) {
						cnt = 1;
					//역방향
						tempR=i;
						tempC=j;
						while(true) {
							tempR-=dr[v];
							tempC-=dc[v];
						if(tempR>=0 && tempC>=0 && tempR<19 && tempC<19 && mat[tempR][tempC] == stone) {
							cnt++;
						}else {
							break;
							}
						}
					//정방향
						tempR=i;
						tempC=j;
						while(true) {
							tempR+=dr[v];
							tempC+=dc[v];
							if(tempR>=0 && tempC>=0 && tempR<19 && tempC<19 && mat[tempR][tempC] == stone) {
								cnt++;
							}else {
								break;
							}
						}
						if(cnt==5) {
							System.out.println(stone);
							if(v!=0) {
							System.out.println((cur[0]+1)+" "+(cur[1]+1));
							}else {
								System.out.println((cur[0]+1+4*dr[v])+" "+(cur[1]+1+4*dc[v]));
                            }
							return;}
					}
				}
			}
            if (cnt!=5){
                System.out.println(0);
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] map;
    public static int[][] res;

    public static void main(String[] args) throws IOException {
//    	System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        res = new int[n][n];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0,1,0);
        System.out.println(res[n-1][n-1]);
    }

	private static void dfs(int r, int c, int v) {
		if(check(r,c)) return;
		
		if(v==0) {
			dfs(r,c+1,0);
			dfs(r+1,c+1,1);
		}else if(v==1) {
			if(map[r-1][c] == 1 || map[r][c-1] ==1) return;
			dfs(r,c+1,0);
			dfs(r+1,c+1,1);
			dfs(r+1,c,2);
		}else {
			dfs(r+1,c+1,1);
			dfs(r+1,c,2);
		}
		res[r][c]++;
	}

	private static boolean check(int r, int c) {
		return r>=n || c>=n || map[r][c] ==1;
	}

   
}
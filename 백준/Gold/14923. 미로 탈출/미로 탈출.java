import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int startr = stoi(st.nextToken()) - 1;
        int startc = stoi(st.nextToken()) - 1;
        st = new StringTokenizer(in.readLine());
        int endr = stoi(st.nextToken()) - 1;
        int endc = stoi(st.nextToken()) - 1;
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        
        bfs(startr, startc, endr, endc);
    }
    
    static void bfs(int r, int c, int endR, int endC) {
        int d[][] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        Queue<int[]> q = new LinkedList<>();
        boolean visit[][][] = new boolean[N][M][2];
        q.add(new int[] {r, c, 1, 0});
        visit[r][c][1] = true;
        int answer = -1;
        
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int cnt = cur[2];
            
            if (curR == endR && curC == endC) {
                answer = cur[3];
                break;
            }
            
            for (int k = 0; k < 4; k++) {
                int nr = curR + d[k][0];
                int nc = curC + d[k][1];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                
                if (cnt > 0 && !visit[nr][nc][cnt - 1] && map[nr][nc] == 1) {
                    visit[nr][nc][cnt - 1] = true;
                    q.add(new int[] {nr, nc, cnt - 1, cur[3] + 1});
                }
                
                if (!visit[nr][nc][cnt] && map[nr][nc] == 0) {
                    visit[nr][nc][cnt] = true;
                    q.add(new int[] {nr, nc, cnt, cur[3] + 1});
                }
            }
        }
        
        System.out.println(answer);
    }
    
    static int stoi(String s) {
        return Integer.valueOf(s);
    }
}
import java.util.*;
import java.io.*;

class Main {
    static class Solver {
        int r, c;
        int[][] map, visited, melt;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public Solver(int r, int c, int[][] map) {
            this.r = r;
            this.c = c;
            this.map = map;
            visited = new int[r][c];
            melt = new int[r][c];
        }

        void solve() {
            int year = 0;

            while (true) {
                int count = 0;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (visited[i][j] == 0 && map[i][j] != 0) {
                            dfs(i, j);
                            count++;
                        }
                    }
                }

                if (count == 0) {
                    System.out.println(0);
                    break;
                } else if (count >= 2) {
                    System.out.println(year);
                    break;
                }

                melt();
                year++;
            }
        }

        void dfs(int x, int y) {
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                    if (map[nx][ny] == 0)
                        melt[x][y]++;

                    if (visited[nx][ny] == 0 && map[nx][ny] != 0)
                        dfs(nx, ny);
                }
            }
        }

        void melt() {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] -= melt[i][j];

                    if (map[i][j] < 0)
                        map[i][j] = 0;

                    visited[i][j] = 0;
                    melt[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solver solver = new Solver(r, c, map);
        solver.solve();
    }
}
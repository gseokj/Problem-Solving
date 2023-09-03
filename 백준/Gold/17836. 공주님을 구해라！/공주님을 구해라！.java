import java.io.*;
import java.util.*;

public class Main {
    static class Knight {
        int r;
        int c;
        int sword;
        int dis;

        public Knight(int r, int c, int sword, int dis) {
            this.r = r;
            this.c = c;
            this.sword = sword;
            this.dis = dis;
        }
    }

    static int N, M, Magic;
    static int[][] map;
    static boolean[][][] visited;  //검의상태를 추가적으루
    static int[][] walls;
    static Queue<Knight> queue;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Magic = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][Magic + 1];  // 검을 찾은경우에 똑같은 경로 다시 가야된다..
        walls = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        if (result == -1 || result > Magic) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        queue.offer(new Knight(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Knight knight = queue.poll();

            if (knight.r == N - 1 && knight.c == M - 1) {
                return knight.dis;
            }

            for (int d = 0; d < 4; d++) {
                int nr = knight.r + dr[d];
                int nc = knight.c + dc[d];

                if (!check(nr, nc) || visited[nr][nc][knight.sword]) {
                    continue;
                }

                visited[nr][nc][knight.sword] = true;

                // 검을 찾은 경우
                if (map[nr][nc] == 2 && knight.sword < Magic) {
                    queue.offer(new Knight(nr, nc, knight.sword + 1, knight.dis + 1));
                    visited[nr][nc][knight.sword + 1] = true;  // 검을 사용한 경우도 방문으로 표시
                }
                // 빈 공간인 경우
                else if (map[nr][nc] == 0) {
                    queue.offer(new Knight(nr, nc, knight.sword, knight.dis + 1));
                }
                // 벽을 부술 수 있는 경우
                else if (map[nr][nc] == 1 && knight.sword > 0 && knight.sword >= walls[nr][nc]) {
                    queue.offer(new Knight(nr, nc, knight.sword, knight.dis + 1));
                    walls[nr][nc] = knight.sword;
                }
            }
        }

        return -1;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
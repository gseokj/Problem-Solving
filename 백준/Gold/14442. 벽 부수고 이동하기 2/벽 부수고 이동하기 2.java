import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][][] dist;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
                for (int k = 0; k <= K; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0, 1});
        dist[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int k = current[2];
            int distance = current[3];

            if (r == N - 1 && c == M - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0 && dist[nr][nc][k] == -1) {
                        dist[nr][nc][k] = distance + 1;
                        queue.offer(new int[]{nr, nc, k, distance + 1});
                    } else if (map[nr][nc] == 1 && k < K && dist[nr][nc][k + 1] == -1) {
                        dist[nr][nc][k + 1] = distance + 1;
                        queue.offer(new int[]{nr, nc, k + 1, distance + 1});
                    }
                }
            }
        }

        return -1;
    }
}
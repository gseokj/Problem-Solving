import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int r, c, rupee, cnt;

        Node(int r, int c, int rupee, int cnt) {
            this.r = r;
            this.c = c;
            this.rupee = rupee;
            this.cnt = cnt;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.rupee, other.rupee);
        }
    }

    static int N;
    static int[][] map;
    static int[][] minRupee;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true) {
            cnt++;
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            map = new int[N][N];
            minRupee = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    minRupee[i][j] = Integer.MAX_VALUE;
                }
            }

            int result = dijkstra();
            System.out.println("Problem " + cnt + ": " + result);
        }
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0], 1));
        minRupee[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.r == N - 1 && current.c == N - 1) {
                return current.rupee;
            }

            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    int newRupee = current.rupee + map[nr][nc];
                    int newCnt = current.cnt + 1;

                    if (newRupee < minRupee[nr][nc] && newCnt <= N * N) {
                        minRupee[nr][nc] = newRupee;
                        pq.offer(new Node(nr, nc, newRupee, newCnt));
                    }
                }
            }
        }

        return -1; // 
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static class Position implements Comparable<Position> {
        int x;
        int y;
        int mirror;
        int dir;

        public Position(int x, int y, int mirror, int dir) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.dir = dir;
        }

        @Override
        public int compareTo(Position o) {
            return this.mirror - o.mirror;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        Position start = null;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '#')
                    start = new Position(i, j, 0, 0);
            }
        }
        PriorityQueue<Position> pq = new PriorityQueue<>();
        boolean[][][] visit = new boolean[4][N][N];
        for (int i = 0; i < 4; i++) {
            pq.add(new Position(start.x, start.y, 0, i));
            visit[i][start.x][start.y] = true;
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int ans = 0;
        gg: while (!pq.isEmpty()) {
            Position now = pq.poll();
            for (int i : new int[] { -1, 1, 0 }) {
                if (map[now.x][now.y] != '!' && i != 0)
                    continue;
                int dir = (now.dir + i + 4) % 4;
                int row = now.x + dx[dir];
                int col = now.y + dy[dir];
                int mirror = i == 0 ? now.mirror : now.mirror + 1;
                if (row < 0 || col < 0 || row >= N || col >= N || map[row][col] == '*')
                    continue;
                if (visit[dir][row][col])
                    continue;
                if (map[row][col] == '#') {
                    ans = mirror;
                    break gg;
                }
                visit[dir][row][col] = true;
                pq.add(new Position(row, col, mirror, dir));
            }
        }
        System.out.println(ans);
    }
}
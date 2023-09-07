import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char map[][];
    static int[][][] visited; 
    static int wall = -1;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static Queue<Person> que;

    static class Person {
        int r, c, d; 
        boolean[] keys;

        public Person(int r, int c, int d, boolean[] keys) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.keys = keys.clone();
        }
    }

    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M][64]; 

        int startR = 0, startC = 0;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);

                if (map[i][j] == '0') {
                    startR = i;
                    startC = j;
                }
            }
        }

        que = new LinkedList<>();
        boolean[] keys = new boolean[6];
        que.offer(new Person(startR, startC, 0, keys));

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        while (!que.isEmpty()) {
            Person person = que.poll();
            int r = person.r;
            int c = person.c;
            int d = person.d;
            boolean[] keys = person.keys;

            if (map[r][c] == '1') {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!check(nr, nc) || map[nr][nc] == '#' || visited[nr][nc][keyToInt(keys)] != 0) {
                    continue;
                }

                if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
                    boolean[] newKeys = keys.clone();
                    newKeys[map[nr][nc] - 'a'] = true;
                    visited[nr][nc][keyToInt(newKeys)] = 1;
                    que.offer(new Person(nr, nc, d + 1, newKeys));
                } else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
                    if (keys[map[nr][nc] - 'A']) {
                        visited[nr][nc][keyToInt(keys)] = 1;
                        que.offer(new Person(nr, nc, d + 1, keys));
                    }
                } else {
                    visited[nr][nc][keyToInt(keys)] = 1;
                    que.offer(new Person(nr, nc, d + 1, keys));
                }
            }
        }
        return -1;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    private static int keyToInt(boolean[] keys) {
        int result = 0;
        for (int i = 0; i < 6; i++) {
            if (keys[i]) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    static char[][] map;
    static int[][] flags;
    static int h, w;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

 

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();

        for (int k = 1; k <= K; k++) {
            System.out.println("Data Set " + k + ":");
            w = scanner.nextInt();
            h = scanner.nextInt();
            scanner.nextLine(); 

            map = new char[h][w];
            flags = new int[h][w];

            for (int i = 0; i < h; i++) {
                String row = scanner.nextLine();
                for (int j = 0; j < w; j++) {
                    flags[i][j] = 4;
                    map[i][j] = row.charAt(j);
                }
            }

            int x = 0, y = 0, res = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 'S') {
                        x = i;
                        y = j;
                    }
                }
            }

            bfs(x, y);

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 'H' && flags[i][j] <= 3)
                        res++;
                }
            }

            System.out.println(res + "\n");
        }

        
    }
    public static void bfs(int sx, int sy) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(sx);
        queue.add(sy);
        flags[sx][sy] = 0;

        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                    int level = flags[r][c];

                    switch (map[nr][nc]) {
                        case 'H':
                        case 'S':
                        case '.':
                            break;
                        case 'P':
                            level = 0;
                            break;
                        case 'G':
                            level++;
                            break;
                    }

                    if (flags[nr][nc] > level) {
                        flags[nr][nc] = level;
                        queue.add(nr);
                        queue.add(nc);
                    }
                }
            }
        }
    }
}
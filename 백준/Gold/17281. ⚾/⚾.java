import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] innings;
    static int[] order;
    static boolean[] visited;
    static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[9];
        visited = new boolean[9];
        maxScore = 0;

        permute(0);

        System.out.println(maxScore);
    }

    private static void permute(int idx) {
        if (idx == 9) {
            int score = playGame();
            maxScore = Math.max(maxScore, score);
            return;
        }

        if (idx == 3) {
            permute(idx + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[idx] = i;
                permute(idx + 1);
                visited[i] = false;
            }
        }
    }

    private static int playGame() {
        int score = 0;
        int currentPlayerIdx = 0;

        for (int i = 0; i < N; i++) {
            int[] base = new int[3];
            int outCount = 0;

            while (outCount < 3) {
                int currentPlayer = order[currentPlayerIdx];
                int result = innings[i][currentPlayer];

                if (result == 0) {
                    outCount++;
                } else if (result == 1) {
                    score += base[2];
                    base[2] = base[1];
                    base[1] = base[0];
                    base[0] = 1;
                } else if (result == 2) {
                    score += base[2] + base[1];
                    base[2] = base[0];
                    base[1] = 1;
                    base[0] = 0;
                } else if (result == 3) {
                    score += base[2] + base[1] + base[0];
                    base[2] = 1;
                    base[1] = base[0] = 0;
                } else { // result == 4
                    score += base[2] + base[1] + base[0] + 1;
                    base[2] = base[1] = base[0] = 0;
                }

                currentPlayerIdx = (currentPlayerIdx + 1) % 9;
            }
        }

        return score;
    }
}
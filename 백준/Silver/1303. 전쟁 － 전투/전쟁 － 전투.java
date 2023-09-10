import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int numRows, numCols, currentX, currentY;
    static char[][] battlefield;

    static boolean[][] visited;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int whiteSum, blackSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numRows = Integer.parseInt(st.nextToken());
        numCols = Integer.parseInt(st.nextToken());

        battlefield = new char[numCols][numRows];
        visited = new boolean[numCols][numRows];

        for (int i = 0; i < numCols; i++) {
            String row = br.readLine();
            for (int j = 0; j < numRows; j++) {
                battlefield[i][j] = row.charAt(j);
            }
        }

        int whiteResult = 0;
        int blackResult = 0;

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                if (!visited[i][j] && battlefield[i][j] == 'W') {
                    whiteSum = 1;
                    DFS_W(i, j);
                    whiteResult += (whiteSum * whiteSum);
                }
                if (!visited[i][j] && battlefield[i][j] == 'B') {
                    blackSum = 1;
                    DFS_B(i, j);
                    blackResult += (blackSum * blackSum);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(whiteResult).append(" ").append(blackResult);
        System.out.println(result);
    }

    static void DFS_W(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            currentX = dirX[i] + x;
            currentY = dirY[i] + y;

            if (isInRange() && !visited[currentX][currentY] && battlefield[currentX][currentY] == 'W') {
                whiteSum++;
                DFS_W(currentX, currentY);
            }
        }
    }

    static void DFS_B(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            currentX = dirX[i] + x;
            currentY = dirY[i] + y;

            if (isInRange() && !visited[currentX][currentY] && battlefield[currentX][currentY] == 'B') {
                blackSum++;
                DFS_B(currentX, currentY);
            }
        }
    }

    static boolean isInRange() {
        return (currentX >= 0 && currentY >= 0 && currentX < numCols && currentY < numRows);
    }
}

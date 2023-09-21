import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static List<Integer> list;
    static int m, n, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        count = 0;
        graph = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            int m2 = Integer.parseInt(st.nextToken()) - 1;
            for (int j = m1; j <= m2; j++)
                for (int l = n1; l <= n2; l++)
                    graph[j][l] = true;
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!graph[i][j]) {
                    count = 1;
                    graph[i][j] = true;
                    dfs(i, j);
                    list.add(count);
                }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i)).append(" ");
        System.out.print(sb);
    }

    static void dfs(int y, int x) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !graph[ny][nx]) {
                graph[ny][nx] = true;
                count++;
                dfs(ny, nx);
            }
        }
    }
}

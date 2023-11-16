import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int n, m, maxInfection = 0;
    static boolean[] visited;
    static int[] infectionCount;
    static ArrayList<Integer>[] graph;

    public static void dfs(int currentNode) {
        visited[currentNode] = true;

        for (int adjacentNode : graph[currentNode]) {
            if (!visited[adjacentNode]) { 
                infectionCount[adjacentNode]++; 
                dfs(adjacentNode); 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        infectionCount = new int[n];
        visited = new boolean[n];

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            graph[x].add(y);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n]; 
            dfs(i);
        }

        for (int i = 0; i < n; i++) {
            if (maxInfection < infectionCount[i]) {
                maxInfection = infectionCount[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (maxInfection == infectionCount[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
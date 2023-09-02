import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(br.readLine());
        for (int i = 0; i <= nodes; i++) edges.add(new ArrayList<>());
        for (int i = 0; i < nodes - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            Main.edges.get(node1).add(node2);
            Main.edges.get(node2).add(node1);
        }
        visited = new boolean[nodes + 1];
        parents = new int[nodes + 1];
        dfs(1);
        for (int i = 2; i < parents.length; i++) System.out.println(parents[i]);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int v : edges.get(node)) {
            if (!visited[v]) {
                dfs(v);
                parents[v] = node;
            }
        }
    }
}
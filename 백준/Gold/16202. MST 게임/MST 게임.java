import java.util.*;
import java.io.*;

class Main {
static class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    public Node(int s, int e, int w) {
        this.start = s;
        this.end = e;
        this.weight = w;
    }

    @Override
    public int compareTo(Node n1) {
        return this.weight - n1.weight;
    }
}
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i + 1));
        }

        boolean flag = false;
        for (int i = 0; i < k; i++) {
            if (flag) {
                System.out.print("0 ");
                continue;
            }
            int result = getMSTWeight(i, n, new PriorityQueue<>(pq));
            if (result == 0) flag = true;
            System.out.print(result + " ");
        }
    }

    public static int getMSTWeight(int k, int n, PriorityQueue<Node> pq) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int weight = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            if (k > 0) {
                k--;
                pq.poll();
                continue;
            }

            Node node = pq.poll();
            int sParent = find(node.start);
            int eParent = find(node.end);
            if (sParent != eParent) {
                union(sParent, eParent);
                weight += node.weight;
                cnt++;
            }
        }

        if (cnt == n - 1) return weight;
        else return 0;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        if (rank[a] > rank[b]) parent[b] = a;
        else {
            parent[a] = b;
            if (rank[a] == rank[b]) rank[b]++;
        }
    }
}
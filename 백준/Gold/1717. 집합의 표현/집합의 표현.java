import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        sb = new StringBuilder();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            if (s[0].equals("0")) union(a, b);
            else checkSets(a, b);
        }

        System.out.println(sb.toString());
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void checkSets(int a, int b) {
        a = find(a);
        b = find(b);
        sb.append(a == b ? "YES\n" : "NO\n");
    }
}
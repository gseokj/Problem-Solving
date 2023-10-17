import java.util.*;

import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int s;
        int e;
        int w;

        public Node(int s, int e, int w) {
            super();
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return o.w - this.w;
        }
    }

    static int V, E;
    static StringTokenizer st;
    static int Sungi, Hyebin;
    static PriorityQueue<Node> pq;
    static int[] p, r;

    public static void main(String[] args) throws Exception {
    //    System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Sungi = Integer.parseInt(st.nextToken());
        Hyebin = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        p = new int[V + 1];
        r = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(s,e,w));
            pq.add(new Node(e,s,w));
        }
        makeSet();
        int max = 0;
        while(!pq.isEmpty()) {
        	Node node = pq.poll();
        	if(union(node.s,node.e)) {
        		if(find(Hyebin)==find(Sungi)) {
        			max =Math.max(max,node.w);
        		}
        	}
        }
        System.out.println(max);
    }

    private static void makeSet() {
        for (int i = 0; i < V + 1; i++) {
            p[i] = i;
            r[i] = 1;
        }

    }

    private static int find(int x) {
        if (p[x] == x)
            return p[x];
        else
            return p[x] = find(p[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x==y) return false;
        if(r[x]>r[y]) {
            r[x]+=r[y];
            p[y] = x;
        }else {
            r[y]+=r[x];
            p[x] = y;
        }
        return true;
    }
}
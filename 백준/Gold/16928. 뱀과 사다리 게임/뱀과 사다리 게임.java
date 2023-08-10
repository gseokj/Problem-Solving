//package com.ssafy.ps;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] board;
    static int[] dist;
    static int n, m;

    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[101]; 
        dist = new int[101]; 

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        int minMoves = bfs();
        System.out.println(minMoves);
    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); 
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int d = 1; d <= 6; d++) {
                int next = cur + d;

                if (next <= 100) {
                    if (board[next] != 0) { 
                        next = board[next];
                    }

                    if (dist[next] == 0) { 
                        dist[next] = dist[cur] + 1;
                        queue.offer(next);
                    }
                }
            }
        }

        return dist[100];
    }
}

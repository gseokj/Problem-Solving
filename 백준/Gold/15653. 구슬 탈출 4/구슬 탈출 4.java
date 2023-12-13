import java.io.*;
import java.util.*;

public class Main {
    static Queue<Marble[]> que;
    static boolean[][][][] visited ;
    static char[][] map;
    static int dir = 0;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    final static char wall = '#';
    final static char goal = 'O';
    final static char vailed = '.';
    static int N, M;

    static class Marble {
        int r;
        int c;
        int count;

        public Marble(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Marble(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Marble{" +
                    "r=" + r +
                    ", c=" + c +
                    ", count=" + count +
                    '}';
        }
    }

    static Marble RED;
    static Marble BLUE;

    public static void main(String[] args) throws IOException {
   //     System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][N][M];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    RED = new Marble(i, j, 0);
                } else if (map[i][j] == 'B') {
                    BLUE = new Marble(i, j);
                }
            }
        }
        int res = bfs();
        System.out.println(res);


    }

    private static int bfs() {
        que = new ArrayDeque<>();
        que.offer(new Marble[]{RED, BLUE});
        visited[RED.r][RED.c][BLUE.r][BLUE.c] = true;
        while (!que.isEmpty()) {
            Marble[] marbles = que.poll();
            Marble red = marbles[0];
            Marble blue = marbles[1];
            for (int d = 0; d < 4; d++) {
                int diff_row = red.r - blue.r; //양수면 red 큰 blue 작
                int diff_col = red.c - blue.c;
                boolean isWallRed = false;
                boolean isWallBlue = false;
                boolean success = false;
                boolean fail = false;
                Marble currRed = new Marble(red.r, red.c, red.count);
                Marble currBlue = new Marble(blue.r, blue.c, blue.count);
                while (!isWallRed) {
                        Marble nextRed = new Marble(currRed.r + dr[d], currRed.c + dc[d], currRed.count);
                        if (map[nextRed.r][nextRed.c] == wall) {
                            isWallRed = true;
                            nextRed.r -= dr[d];
                            nextRed.c -= dc[d];

                        } else if (map[nextRed.r][nextRed.c] == goal) {
                            success = true;
                            isWallRed = true;
                        }
                        currRed.r = nextRed.r;
                        currRed.c = nextRed.c;
                }
                while (!isWallBlue) {
                        Marble nextBlue = new Marble(currBlue.r + dr[d], currBlue.c + dc[d], currBlue.count);
                        if (map[nextBlue.r][nextBlue.c] == wall) {
                            isWallBlue = true;
                            nextBlue.r -= dr[d];
                            nextBlue.c -= dc[d];

                        } else if (map[nextBlue.r][nextBlue.c] == goal) {
                            fail = true;
                            isWallBlue = true;
                        }

                        currBlue.r = nextBlue.r;
                        currBlue.c = nextBlue.c;


            }
                currRed.count++;
                if(currRed.r==currBlue.r && currRed.c==currBlue.c) adjustment(d, diff_col, currBlue, currRed, diff_row);
                if(fail){
                    continue;
                }else if(success){
                    return currRed.count;
                }else if(!visited[currRed.r][currRed.c][currBlue.r][currBlue.c]){

                    que.offer(new Marble[]{new Marble(currRed.r,currRed.c,currRed.count),new Marble(currBlue.r,currBlue.c)});
                    visited[currRed.r][currRed.c][currBlue.r][currBlue.c] = true;
                }

            }
        }

        return -1;
    }

    private static void adjustment(int d, int diff_col, Marble currBlue, Marble currRed, int diff_row) {
        if(d ==0){
            if(diff_col >0){
                currRed.r-=dr[d];
                currRed.c-=dc[d];
            }else {
                currBlue.r-=dr[d];
                currBlue.c-=dc[d];
            }
        }else if(d ==1){
            if(diff_row >0){
                currRed.r-=dr[d];
                currRed.c-=dc[d];
            }else{
                currBlue.r-=dr[d];
                currBlue.c-=dc[d];
            }
        }
        if(d ==2) {
            if (diff_col < 0) {
                currRed.r -= dr[d];
                currRed.c -= dc[d];
            } else {
                currBlue.r -= dr[d];
                currBlue.c -= dc[d];
            }
        }
        else if(d ==3){
            if(diff_row <0){
                currRed.r-=dr[d];
                currRed.c-=dc[d];
            }else {
                currBlue.r-=dr[d];
                currBlue.c-=dc[d];
            }
        }
    }

    private static boolean check(int r, int c) {
        return r>=0 && c>=0 && r<N && c<M;
    }

}
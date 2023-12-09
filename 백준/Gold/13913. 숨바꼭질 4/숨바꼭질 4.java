import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static boolean[] visited;
    static int[] dir = {1, -1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        visited = new boolean[100001];
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            sb.append((N-K)+"\n");
            for (int i = N; i > K-1; i--) {
                sb.append(i+" ");
            }
        }else {
            int[] path = bfs();
            int value = path.length - 1;
            String result = Arrays.toString(path).replace("[", "").replace("]", "").replace(",", "");
            sb.append(value+"\n");
            sb.append(result);
        }
        System.out.println(sb.toString());

    }

    private static int[] bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{N});
        visited[N]= true;
        while(!que.isEmpty()){
            int[] path = que.poll();
            int curr = path[path.length-1];
            if(curr == K) return path;
            for (int d = 0; d < 3; d++) {
                int next=0;
                if(d==0){
                    if(curr>K) continue;
                    next = curr+dir[d];
                }
                else if(d==1){
                    next = curr+dir[d];
                }
                else if(d==2){
                    if(curr>K) continue;
                    next = curr*dir[d];
                }
                if(!check(next) || visited[next]) continue;
                visited[next] = true;
                que.offer(add(path,next));
            }
        }

        return null;
    }

    private static boolean check(int n) {
        return n>=0 && n<K+2;
    }
    private static int[] add(int[] originArray, int val) {
        List<Integer> newList = new ArrayList<>();
        for (int element : originArray) {
            newList.add(element);
        }
        newList.add(val);
        return newList.stream().mapToInt(Integer::intValue).toArray();
    }
}
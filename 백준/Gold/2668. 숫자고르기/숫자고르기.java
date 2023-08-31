import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/* 코드의 전체 적인 해석
 * 1. DFS를 활용해서 해당 하는 인덱스 하나의 원소 타고 들어간다.
 * 2. 그 원소는 인덱스가 되고 그 인덱스의 원소를 찾는다.
 * 3. 처음의 인덱스와 마지막의 인덱스가 일치하면 결과 값이다.
 * 4. 예를들어 1 -> 3 -> 1 이라면 둘 다 결과값이다.
 * 5. 또한 5->5도 될 수 있다.
 */
public class Main {
    static int[] arr;
    static boolean[] visited, res;
    static int N,cnt;

    public static void main(String[] args) throws IOException {
        Scanner scann = new Scanner(System.in);
        N = scann.nextInt();
        arr = new int[N + 1];
        res = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = scann.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }
        System.out.println(cnt);
        
        
        for (int i = 1; i <= N; i++) {
            if (res[i]) System.out.println(i);
        }
    }

    private static void dfs(int s, int e) {
        visited[e] = true;
        int next = arr[e];
        if (!visited[next]) {
            dfs(s, next);
        } else if (s == next) {
            res[e] = true;
            cnt++;
        }
    }
}
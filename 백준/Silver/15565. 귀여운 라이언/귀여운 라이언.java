import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int cnt = (arr[0] == 1) ? 1 : 0;
        int res = Integer.MAX_VALUE;

        while (left <= right && right < N) {
            if (cnt < K) {
                right++;
                if (right < N && arr[right] == 1) {
                    cnt++;
                }
            } else if (cnt == K) {
                res = Math.min(res, right - left + 1);
                if (arr[left] == 1) {
                    cnt--;
                }
                left++;
            } else {
                if (arr[left] == 1) {
                    cnt--;
                }
                left++;
            }
        }
        
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}
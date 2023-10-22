import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int scenario = 0;
        StringTokenizer st;
        while (true) {
            scenario++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            String[] girl = new String[N];
            char[] earring = new char[N];
            for (int i = 0; i < N; i++) {
                girl[i] = br.readLine();
            }

            for (int i = 0; i < 2 * N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (earring[num - 1] == 'A' || earring[num - 1] == 'B') {
                    earring[num - 1] = st.nextToken().charAt(0);
                    earring[num - 1] = 'F';
                } else {
                    earring[num - 1] = st.nextToken().charAt(0);
                }
            }
            for (int i = 0; i < N; i++) {
                if (earring[i] != 'F') {
                    System.out.println(scenario + " " + girl[i]);
                }
            }
        }
    }
}
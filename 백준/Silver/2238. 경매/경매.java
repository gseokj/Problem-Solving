import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int U = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        String[][] p = new String[10001][];
        int[] num = new int[10001];
        int m = 10001;

        for (int i = 0; i < N; i++) {
            String[] auctionInfo = br.readLine().split(" ");
            String name = auctionInfo[0];
            int price = Integer.parseInt(auctionInfo[1]);
            if (p[price] == null) {
                p[price] = new String[]{name};
            } else {
                int length = p[price].length;
                String[] newArray = new String[length + 1];
                System.arraycopy(p[price], 0, newArray, 0, length);
                newArray[length] = name;
                p[price] = newArray;
            }
            num[price]++;
        }

        for (int i = 0; i < 10001; i++) {
            if (num[i] != 0) {
                m = Math.min(num[i], m);
            }
        }

        for (int i = 0; i < 10001; i++) {
            if (m == num[i]) {
                System.out.println(p[i][0] + " " + i);
                break;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nB = new ArrayList<>();
        ArrayList<Integer> mB = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int sN = 0;
        int sM = 0;
        long result = 0;
        int sum;

        for(int i = 0; i < n; i++){
            nB.add(Integer.parseInt(br.readLine()));
            sN += nB.get(i);
        }

        for(int i = 0; i < m; i++){
            mB.add(Integer.parseInt(br.readLine()));
            sM += mB.get(i);
        }

        sum = sN > sM ? sM : sN;
        sN = sum;
        sM = sum;

        for(int i = 0; sN > 0; i++){
            if(sN >= nB.get(i)){
                result += nB.get(i) * (i + 1);
                sN -= nB.get(i);
            } else{
                result += sN * (i + 1);
                sN = 0;
            }
        }

        for(int i = 0; sM > 0; i++){
            if(sM >= mB.get(i)){
                result += mB.get(i) * (i + 1);
                sM -= mB.get(i);
            } else{
                result += sM * (i + 1);
                sM = 0;
            }
        }
        System.out.println(sum + " " + result);
    }
}

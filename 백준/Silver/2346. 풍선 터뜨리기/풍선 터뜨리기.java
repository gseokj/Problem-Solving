import java.io.*;
import java.security.Signature;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int index = 0;

        LinkedList<int[]> list = new LinkedList<>();
        StringTokenizer input = new StringTokenizer(br.readLine());

        for (int x = 0; x < num; x++) {
            list.add(new int[]{x+1,Integer.parseInt(input.nextToken())});
        }

        while (list.size()!=1) {
            int move = list.get(index)[1];
            int size = list.size() - 1;

            sb.append(list.get(index)[0]).append(" ");

            list.remove(index);

            if (move > 0) {
                move--;
            }

            index = (index + move) % size;

            if (index < 0) {
                index += size;
            }

        }

        sb.append(list.get(0)[0]);

        System.out.println(sb);

    }

}
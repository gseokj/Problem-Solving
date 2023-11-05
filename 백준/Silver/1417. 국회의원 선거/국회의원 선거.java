import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int numberOfCandidates = Integer.parseInt(br.readLine());
        int dasomCandies = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> candies = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < numberOfCandidates - 1; i++) {
            candies.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        if (numberOfCandidates > 1) {
            while (!candies.isEmpty() && candies.peek() >= dasomCandies) {
                answer++;
                dasomCandies++;
                int temp = candies.poll();
                candies.add(temp - 1);
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
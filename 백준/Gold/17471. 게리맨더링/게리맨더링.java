import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, minDifference = 987654321, population[];
    static ArrayList<Integer>[] adjacency;
    static boolean isInGroupA[];

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        N = Integer.parseInt(reader.readLine());
        population = new int[N + 1];
        adjacency = new ArrayList[N + 1];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(tokenizer.nextToken());
            adjacency[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int size = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < size; j++) {
                adjacency[i].add(Integer.parseInt(tokenizer.nextToken()));
            }
        }

        isInGroupA = new boolean[N + 1];
        selectGroupA(1);

        System.out.println(minDifference == 987654321 ? -1 : minDifference);

    }

    private static void selectGroupA(int index) {
        if (index == N + 1) {
            if (isConnectable()) {
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (isInGroupA[i]) sumA += population[i];
                    else sumB += population[i];
                }

                minDifference = Math.min(minDifference, Math.abs(sumA - sumB));
            }

            return;
        }

        isInGroupA[index] = true;
        selectGroupA(index + 1);

        isInGroupA[index] = false;
        selectGroupA(index + 1);

    }

    private static boolean isConnectable() {
        boolean[] visited = new boolean[N + 1];

        int groupAStart = -1;
        for (int i = 1; i <= N; i++) {
            if (isInGroupA[i]) {
                groupAStart = i;
                break;
            }
        }

        int groupBStart = -1;
        for (int i = 1; i <= N; i++) {
            if (!isInGroupA[i]) {
                groupBStart = i;
                break;
            }
        }

        if (groupAStart == -1 || groupBStart == -1) return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(groupAStart);
        visited[groupAStart] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < adjacency[current].size(); i++) {
                if (visited[adjacency[current].get(i)]) continue;
                if (!isInGroupA[adjacency[current].get(i)]) continue;
                visited[adjacency[current].get(i)] = true;
                queue.add(adjacency[current].get(i));
            }
        }

        queue.add(groupBStart);
        visited[groupBStart] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < adjacency[current].size(); i++) {
                if (visited[adjacency[current].get(i)]) continue;
                if (isInGroupA[adjacency[current].get(i)]) continue;
                visited[adjacency[current].get(i)] = true;
                queue.add(adjacency[current].get(i));
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

}
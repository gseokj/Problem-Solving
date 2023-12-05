import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        int vertex;
        int cost;
        boolean isSafe;

        public Node() {}

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public Node(int vertex, int cost, boolean isSafe) {
            this.vertex = vertex;
            this.cost = cost;
            this.isSafe = isSafe;
        }
    }

    public static int numVertices, numEdges, safeVertex;
    public static int[] distance;
    public static ArrayList<Node>[] adjacencyList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numVertices = Integer.parseInt(st.nextToken());
        numEdges = Integer.parseInt(st.nextToken());
        safeVertex = Integer.parseInt(st.nextToken());

        distance = new int[numVertices + 1];
        adjacencyList = new ArrayList[numVertices + 1];

        for (int i = 1; i <= numVertices; i++) {
            adjacencyList[i] = new ArrayList<>();
            distance[i] = 987654321;
        }

        for (int i = 0; i < numEdges; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(new Node(end, cost));
            adjacencyList[end].add(new Node(start, cost));
        }

        distance[1] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        priorityQueue.offer(new Node(1, 0));

        int endDistance = 987654321;
        boolean success = false;

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int currentVertex = currentNode.vertex;
            int currentCost = currentNode.cost;
            boolean isSafe = currentNode.isSafe;

            if (currentVertex == numVertices) {
                if (currentCost > endDistance)
                    break;
                if (isSafe) {
                    success = true;
                    break;
                }
                endDistance = currentCost;
            }

            boolean nextIsSafe = isSafe;

            if (currentVertex == safeVertex) {
                nextIsSafe = true;
            }

            for (int i = 0; i < adjacencyList[currentVertex].size(); i++) {
                Node nextNode = adjacencyList[currentVertex].get(i);
                int nextVertex = nextNode.vertex;
                int nextCost = nextNode.cost;

                if (currentCost + nextCost > distance[nextVertex]) continue;

                distance[nextVertex] = currentCost + nextCost;
                priorityQueue.offer(new Node(nextVertex, currentCost + nextCost, nextIsSafe));
            }
        }

        if (success) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    private static int v;
    private static int e;
    private static int k;
    private static int[] distance;
    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        distance = new int[v+1];
        Arrays.fill(distance, INF);

        for(int i = 1; i < v+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        dijkstra(k);

        for(int i = 1; i < v+1; i++) {
            if(distance[i] == INF) {
                System.out.println("INF");
                continue;
            }

            System.out.println(distance[i]);
        }


    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;

        pq.add(new Node(start, distance[start]));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(distance[curr.end] != curr.weight) continue;

            for(Node nxt : graph[curr.end]){
                if(distance[nxt.end] > distance[curr.end] + nxt.weight) {
                    distance[nxt.end] = distance[curr.end] + nxt.weight;
                    pq.offer(new Node(nxt.end, distance[nxt.end]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

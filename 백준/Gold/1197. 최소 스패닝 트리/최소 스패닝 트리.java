
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    public int weight;
    public int v;

    public Edge(int weight, int v) {
        this.weight = weight;
        this.v = v;
    }
}
public class Main {
    static boolean[] check;
    static List<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        check = new boolean[v+1];
        graph = new ArrayList[v+1];

        for (int i = 0; i <= v; i ++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(stk.nextToken());
            int node2 = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            graph[node1].add(new Edge(weight, node2));
            graph[node2].add(new Edge(weight, node1));
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        check[1] = true;
        for (Edge nxt: graph[1]) {
            pq.offer(new int[] {nxt.weight, 1, nxt.v});
        }

        int cnt = 0; //현재 선택된 간선의 수
        int answer = 0;
        while (cnt < v - 1) {
            int[] edge = pq.poll();
            int weight = edge[0];
            int node1 = edge[1];
            int node2 = edge[2];

            if (check[node2]) continue;
            check[node2] = true;
            cnt += 1;
            answer += weight;

            for (Edge nxt: graph[node2]) {
                if (!check[nxt.v]) {
                    pq.offer(new int[] {nxt.weight, node2, nxt.v});
                }
            }
        }

        System.out.println(answer);
    }
}
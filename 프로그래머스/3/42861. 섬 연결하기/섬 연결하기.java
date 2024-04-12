import java.util.*;

class Edge {
    public int weight;
    public int node;
    
    public Edge(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }
}

class Solution {
    static boolean[] check;
    static List<Edge>[] graph;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        check = new boolean[n];
        graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < costs.length; i++) {
            graph[costs[i][0]].add(new Edge(costs[i][2], costs[i][1]));
            graph[costs[i][1]].add(new Edge(costs[i][2], costs[i][0]));
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        
        check[0] = true;
        for (Edge nxt : graph[0]) {
            pq.offer(new int[] {nxt.weight, 0, nxt.node});
        }
        
        int cnt = 0;
        while (cnt < n -1) {
            int[] nodeAndWeight = pq.poll();
            int weight = nodeAndWeight[0];
            int node1 = nodeAndWeight[1];
            int node2 = nodeAndWeight[2];
            
            if (check[node2]) continue;
            
            check[node2] = true;
            cnt += 1;
            answer += weight;
            
            for (Edge nxt: graph[node2]) {
                if (!check[nxt.node]) {
                    pq.offer(new int[] {nxt.weight, node2, nxt.node});
                }
            }
            
            
        }
        return answer;
    }
}
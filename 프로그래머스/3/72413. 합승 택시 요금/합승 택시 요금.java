import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        int[][] fare_graph = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(fare_graph[i], 0);
        }
        
        for (int[] fare : fares) {
            int node1 = fare[0];
            int node2 = fare[1];
            int cost = fare[2];
            
            fare_graph[node1][node2] = cost;
            fare_graph[node2][node1] = cost;
        }
        
        int[] common = dijkstra(s, fare_graph, n);
        int[] a_cost = dijkstra(a, fare_graph, n);
        int[] b_cost = dijkstra(b, fare_graph, n);
        
        for (int i = 1; i <= n; i++) {
            int costSum = common[i] + a_cost[i] + b_cost[i];
            answer = Math.min(answer, costSum);
        }
        return answer;
        
    }
    
    public int[] dijkstra(int start, int[][] fare_graph, int n) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.offer(new int[] {0, start});
        
        while (!pq.isEmpty()) {
            int[] costAndNode = pq.poll();
            int cost = costAndNode[0];
            int node = costAndNode[1];
            
            if (distance[node] != cost) continue;
            
            for (int i = 1; i <= n; i++) {
                if (fare_graph[node][i] != 0 && fare_graph[node][i] + cost < distance[i]) {
                    distance[i] = fare_graph[node][i] + cost;
                    pq.offer(new int[] {distance[i], i});
                }
            }
        }
        
        return distance;
    }
}
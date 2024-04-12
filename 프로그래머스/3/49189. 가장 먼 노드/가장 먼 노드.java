import java.util.*;

class Solution {
    static List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        Deque<int[]> deque = new ArrayDeque<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        for (Integer node : graph[1]) {
            deque.add(new int[] {1, node});
        }
        
        int maxDistance = 0;
        while(!deque.isEmpty()) {
            int[] dq = deque.poll();
    
            if (distance[dq[1]] != -1) continue;
            
            distance[dq[1]] = distance[dq[0]] + 1;
            maxDistance = Math.max(maxDistance, distance[dq[1]]);
            
            for (Integer node : graph[dq[1]]) {
                if (distance[node] == -1) 
                    deque.add(new int[] {dq[1], node});
            }
        }
     
        if (maxDistance > 0) {
            for (int i = 1; i <=n; i++) {
                if (distance[i] == maxDistance) 
                    answer += 1;
            }
        }
        
        return answer;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    private List<List<Integer>> roadGraph;
    private int[] distance;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answer = new ArrayList<>();
        roadGraph = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            roadGraph.add(row);
        }
        for(int[] road : roads) {
            roadGraph.get(road[0]).add(road[1]);
            roadGraph.get(road[1]).add(road[0]);
        }
        
        bfs(destination, n);
        
        for(int source : sources) {
            answer.add(distance[source]);
        }
        return answer.stream()
            .mapToInt(Integer::intValue).toArray();
    }
    
    public void bfs(int destination, int n) {
        boolean[] visited = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, -1);
        visited[destination] = true;
        distance[destination] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        
        while(!q.isEmpty()) {
            int current = q.poll();
            List<Integer> currentGraph = roadGraph.get(current);
            for(int i = 0; i < currentGraph.size(); i++) {
                int next = currentGraph.get(i);
                if(visited[next]) continue;
                
                q.offer(next);
                distance[next] = distance[current] + 1;
                visited[next] = true;
            }
        }
    }
}
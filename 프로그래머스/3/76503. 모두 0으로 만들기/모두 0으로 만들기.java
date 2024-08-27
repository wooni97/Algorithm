import java.util.*;

class Solution {
    static List<Integer>[] connected;
    static long answer;
    static long[] copy;
    static boolean[] visited;
    
    public long solution(int[] a, int[][] edges) {
        answer = 0;
        int length = a.length;
        
        visited = new boolean[length];
        copy = new long[length];
        connected = new ArrayList[length];
        
        int sum = 0;
        for(int i = 0; i < length; i++) {
            copy[i] = a[i];
            sum += a[i];
            connected[i] = new ArrayList<>();
        }
        
        if(sum != 0) return -1;
        
        for(int[] edge : edges) {
            connected[edge[0]].add(edge[1]);
            connected[edge[1]].add(edge[0]);
        }
        
        dfs(0);
        
        return answer;
    }
    
    long dfs(int node) {
        visited[node] = true;
        for(int i = 0; i < connected[node].size(); i++) {
            int neighbor = connected[node].get(i);
            if(visited[neighbor]) continue;
            
            copy[node] += dfs(neighbor);
        }
        
        answer += Math.abs(copy[node]);
        return copy[node];    
    }
}
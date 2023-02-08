import java.util.*;

class Solution {
    
    public int answer = 0;
    public boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(0,k,dungeons);
        
        return answer;
    }
    
    public void dfs(int stage, int k, int[][] dungeons){
        
        answer = Math.max(answer,stage);
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] == false && k >= dungeons[i][0]){
                visited[i] = true;
                dfs(stage+1,k-dungeons[i][1],dungeons);
                visited[i] = false;
            }
        }
    }
    
}
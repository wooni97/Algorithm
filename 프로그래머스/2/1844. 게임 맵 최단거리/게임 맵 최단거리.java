import java.util.*;

class Solution {
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        bfs(maps);
        
        int answer = maps[maps.length-1][maps[0].length -1];
        
        if (answer == 1) {
            answer = -1;
        }
        return answer;
    }
    
    public void bfs(int[][] maps) {
        int x = 0;
        int y = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int cx = current[0];
            int cy = current[1];
            
            for(int i=0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }
                
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[cx][cy] +1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        
    }
}
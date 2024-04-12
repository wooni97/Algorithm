import java.util.*;

class Solution {
    static boolean[][] check;
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        
        int n = land.length;
        check = new boolean[n][n];
        
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        check[0][0] = true;
        if (Math.abs(land[0][1] - land[0][0]) > height) {
            pq.offer(new int[] {Math.abs(land[0][1] - land[0][0]), 0, 1});
        } else {
            pq.offer(new int[] {0, 0, 1});
        }
        
        if (Math.abs(land[1][0] - land[0][0]) > height) {
            pq.offer(new int[] {Math.abs(land[1][0] - land[0][0]), 1, 0});
        } else {
            pq.offer(new int[] {0, 1, 0});
        }
        
        int cnt = 1;
        while (cnt != Math.pow(n, 2)) {
            
            int[] nxt = pq.poll();
            int cost = nxt[0];
            int x = nxt[1];
            int y = nxt[2];
            
            if (check[x][y]) continue;
            
            check[x][y] = true;
            cnt += 1;
            answer += cost;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (check[nx][ny]) continue;
                    
                    if (Math.abs(land[nx][ny] - land[x][y]) > height) {
                        pq.offer(new int[] {Math.abs(land[nx][ny] - land[x][y]), nx, ny});
                    } else {
                        pq.offer(new int[] {0, nx, ny});
                    }
                }
            }
        }
        return answer;
    }
}
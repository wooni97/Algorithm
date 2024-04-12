import java.util.*;

class Solution {
    private int[][] map;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        map = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(map[i], 0);
        }
        
        for(int[] result : results) {
            int win = result[0];
            int loose = result[1];
            
            map[win][loose] = 1;
        }
        
        for (int k = 1; k < n+1; k++) {
            for (int i = 0; i < n+1; i++) {
                for (int j = 0; j < n+1; j++) {
                    if (map[i][i] == 0 && map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        
        
        int[] rowSum = new int[n+1];
        int[] columnSum = new int[n+1];
 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    rowSum[i] += 1;
                    columnSum[j] += 1;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (rowSum[i] + columnSum[i] == n-1) answer += 1;
        }
        
        
        return answer;
    }
}
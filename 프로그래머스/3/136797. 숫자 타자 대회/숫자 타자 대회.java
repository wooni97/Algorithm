import java.util.*;
import java.io.*;

class Solution {
    private static final int INIT_LEFT_NUMBER = 4;
    private static final int INIT_RIGHT_NIUMBER = 6;
    private String nums;
    private int[][][] dp;
    private int[][] cost;
    
    public int solution(String numbers) {
        nums = numbers;
        dp = new int[nums.length()][10][10];
        cost = new int[10][10];
        
        initCost();
        
        for(int i = 0; i < nums.length(); i++){
            for(int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return getMinCost(0, INIT_LEFT_NUMBER, INIT_RIGHT_NIUMBER);
    }
    
    private int getMinCost(int index, int left, int right) {
        if(index == nums.length()) return 0;
        
        if(dp[index][left][right] != -1) return dp[index][left][right];
        
        int number = nums.charAt(index) - '0';
        int result = Integer.MAX_VALUE;
        
        if(number != right)
            result = Math.min(getMinCost(index + 1, number, right) + cost[left][number], result);
        
        if(number != left)
            result = Math.min(getMinCost(index + 1, left, number) + cost[right][number], result);
        
        return dp[index][left][right] = result;
    }
    private void initCost() {
        int r1, c1, r2, c2;
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(i == j) {
                    cost[i][j] = 1;
                    continue;
                }
                
                if(i == 0) {
                    r1 = 3;
                    c1 = 1;
                } else {
                    r1 = (i-1) / 3;
                    c1 = (i-1) % 3;
                }
                
                if(j == 0) {
                    r2 = 3;
                    c2 = 1;
                } else {
                    r2 = (j-1) / 3;
                    c2 = (j-1) % 3;
                }
                
                int dr = Math.abs(r1 - r2);
                int dc = Math.abs(c1 - c2);
                int min = Math.min(dr, dc);
                int max = Math.max(dr, dc);
                int diff = dr + dc;
                
                if(diff == 1) {
                    cost[i][j] = 2;
                } 
                else if (diff > 1) {
                    cost[i][j] = min*3 + (max - min)*2;
                }
            }
        }
    }
}
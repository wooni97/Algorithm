import java.util.*;
import java.io.*;

class Solution {
    private int[][] dp;
    private static int MAX = 1_000_000;
    private static int MAX_TEMP = 40;
    private static int MIN_TEMP = -10;
    private static int RANGE = MAX_TEMP - MIN_TEMP;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        if(temperature >= t1 && temperature <= t2) return 0;
        
        temperature -= MIN_TEMP;
        t1 -= MIN_TEMP;
        t2 -= MIN_TEMP;
        
        dp = new int[onboard.length][RANGE + 1];
        for(int i = 0; i < onboard.length; i++){
            Arrays.fill(dp[i], MAX);
        }
        
        dp[0][temperature] = 0;
        
        for(int i = 0; i < onboard.length -1; i++){
            for(int j = 0; j < RANGE + 1; j++){
                
                if(onboard[i] == 1 && (j < t1 || j > t2)) continue;
                
                // 1. 에어컨을 끄는 경우
                if(j < temperature && j < RANGE) 
                    dp[i+1][j+1] = Math.min(dp[i][j], dp[i+1][j+1]);
                if(j > temperature && j > 0)
                    dp[i+1][j-1] = Math.min(dp[i][j], dp[i+1][j-1]);
                if(j == temperature)
                    dp[i+1][j] = Math.min(dp[i][j], dp[i+1][j]);
                
                // 2. 에어컨을 키는 경우
                if(j < RANGE) 
                    dp[i+1][j+1] = Math.min(dp[i][j] + a, dp[i+1][j+1]);
                if(j > 0)
                    dp[i+1][j-1] = Math.min(dp[i][j] + a, dp[i+1][j-1]);
                
                dp[i+1][j] = Math.min(dp[i][j] + b, dp[i+1][j]);
            }
        }
        int answer = MAX;
        for(int i = 0; i < RANGE + 1; i++){
            if(onboard[onboard.length-1] == 1 && (i < t1 || i > t2)) continue;
            
            answer = Math.min(answer, dp[onboard.length-1][i]);
        }

        return answer;
    }
}
import java.util.*;
import java.io.*;

class Solution {
    private int n;
    private int[] perse1;
    private int[] perse2;
    private long[] dp1;
    private long[] dp2;
    
    public long solution(int[] sequence) {
        
        n = sequence.length;
        
        perse1 = new int[n];
        perse2 = new int[n];
        
        dp1 = new long[n];
        dp2 = new long[n];
        
        for(int i = 0; i < n; i++){
            if(i%2 == 1){
                perse1[i] = sequence[i];
                perse2[i] = sequence[i] * (-1);
                continue;
            }
            
            if(i%2 == 0){
                perse1[i] = sequence[i] * (-1);
                perse2[i] = sequence[i];
            }
        }
        
        dp1[0] = perse1[0];
        dp2[0] = perse2[0];
        
        long answer = Math.max(dp1[0], dp2[0]);
        
        for(int i = 1; i < n; i++){
            dp1[i] = Math.max(dp1[i-1] + perse1[i], perse1[i]);
            dp2[i] = Math.max(dp2[i-1] + perse2[i], perse2[i]);
            
            answer = Math.max(answer, dp1[i] >= dp2[i] ? dp1[i] : dp2[i]);
        }
        return answer;
    }
}
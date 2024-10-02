import java.io.*;

class Solution {
    int[] dp1;
    int[] dp2;
    
    public int solution(int n, int[] tops) {
        dp1 = new int[n+1];
        dp2 = new int[n+1];
        
        dp1[1] = 1;
        dp2[1] = tops[0] == 1 ? 3: 2;
        
        
        for(int i = 2; i < n + 1; i++) {
            if(tops[i-1] == 1) {
                dp1[i] = (dp1[i-1] + dp2[i-1]) % 10007;
                dp2[i] = (2 * dp1[i-1] + 3 * dp2[i-1]) % 10007;
                continue;
            }
            
            if(tops[i-1] == 0) {
                dp1[i] = (dp1[i-1] + dp2[i-1]) % 10007;
                dp2[i] = (dp1[i-1] + 2 * dp2[i-1]) % 10007;
            }
        }
        
        
        return (dp1[n] + dp2[n]) % 10007;
    }
}
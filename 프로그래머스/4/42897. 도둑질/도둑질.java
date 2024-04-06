import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        Arrays.fill(dp1, 0);
        Arrays.fill(dp2, 0);
        
        //첫번째 집을 터는 경우의 DP
        dp1[0] = money[0];
        dp1[1] = money[0];
        
        dp2[1] = money[1];
        
        for (int i = 2; i < n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], money[i] + dp1[i-2]);
        }
        
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i-1], money[i] + dp2[i-2]);
        }
        
        return Math.max(dp2[n-1], dp1[n-2]);
    }
}
import java.util.*;

class Solution {
    static int[] numbers;
    
    public int solution(int n) {
        int answer = 0;
        numbers = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            numbers[i] = i;
        }
        
        int end = 1;
        int sum = 1;
        for (int start = 1; start <= n; start++) {
            while (end <= n && sum < n) {
                end += 1;
                if (end != n+1) sum += end;
            }
            
            if (end == n + 1) break;
            
            if (sum == n) {
                answer += 1;
            }
            sum -= start;
        }
        return answer;
    }
}
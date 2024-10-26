import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int maxTime = Integer.MIN_VALUE;
        for(int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        
        long st = 0;
        long en = (long) maxTime * n;
        
        while(st <= en) {
            long people = 0 ;
            long mid = (st + en) / 2;
            
            for(int time : times) {
                people += mid / (long) time;
                
                if(people >= n)
                    break;
            }
            
            if(people < n) {
                st = mid + 1;
                continue;
            }
            
            answer = mid;
            en = mid - 1;
            
        }
        
        return answer;
    }
}
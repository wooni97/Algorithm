import java.util.*;
import java.io.*;

class Solution {
    private Deque<Character> stack;
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++){
            stack = new ArrayDeque<>();
            String ss = s[i];
            int cnt = 0;
            
            for(int j = 0; j < ss.length(); j++) {
                stack.push(ss.charAt(j));
                if(stack.size() >= 3 && isContained(stack)) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    cnt++;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty())
                sb.append(stack.pop());
            
            sb.reverse();
            // 거꾸로 되어 있음
            while(cnt-- > 0) {
                boolean flag = false;
                
                for(int k = sb.length() - 1; k >= 0; k--) {
                    if (sb.charAt(k) == '0') {
                        flag = true;
                        sb.insert(k+1, "110");
                        break;
                    }    
                }
                
                if(!flag) {
                    sb.insert(0, "110");
                }
            }
            
            answer[i] = sb.toString();
            
        }
        return answer;
    }
    
    public boolean isContained(Deque<Character> stack) {
        if (stack.size() < 3) return false;
        
        Iterator<Character> it = stack.iterator();
        char third = it.next();
        char second = it.next();
        char first = it.next();
        
        return first == '1' && second == '1' && third == '0';
    }
} 
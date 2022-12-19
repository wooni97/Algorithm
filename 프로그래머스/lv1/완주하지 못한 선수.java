
 import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //int[] answer = {};
        List<Integer> answer = new ArrayList<Integer>();
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = progresses.length -1 ; i >=0 ; i--){
            stack.push((100 - progresses[i]) / speeds[i] + (100 - progresses[i] % speeds[i] > 0 ? 1 : 0));
            
        }
        
        while(!stack.isEmpty()){
            int cnt = 1;
            int first = stack.pop();
            
            while(!stack.isEmpty() && stack.peek() <= first){
                cnt++;
                stack.pop();
            }
            
            answer.add(cnt);
            
            
        }
        /*
         
         
        int[] newAnswer = new int[answer.size()];
        for(int i = 0 ; i < newAnswer.length; i++){
            newAnswer[i] = answer.get(i);
        }
        return newAnswer;
        */
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
 
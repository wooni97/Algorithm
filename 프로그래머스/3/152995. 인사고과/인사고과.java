import java.util.*;
import java.io.*;

class Solution {
    List<Integer> sumScores;
    
    public int solution(int[][] scores) {
        int[] target = Arrays.copyOf(scores[0], scores[0].length);
        
        Arrays.sort(scores, (a, b) -> {
           if(a[0] == b[0])
               return a[1] - b[1];
            
            return b[0] - a[0];
        });
        
        sumScores = new ArrayList<>();
        sumScores.add(scores[0][0] + scores[0][1]);
        int maxColleagueScore = scores[0][1];
        for(int i = 1; i < scores.length; i++) {
            if(scores[i][1] >= maxColleagueScore) {
                maxColleagueScore = scores[i][1];
                sumScores.add(scores[i][0] + scores[i][1]);
                continue;
            }
            
            if(scores[i][0] == target[0] && scores[i][1] == target[1]) {
                return -1;
            }
                
        }
        
        Collections.sort(sumScores, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 내림차순 정렬을 위해 o2와 o1의 순서를 바꿈
            }
        });
        
        for(int i = 0; i < sumScores.size(); i++) {
            if(target[0] + target[1] == sumScores.get(i)) {
                return i+1;
            } 
        }
        
        return -1;
    }
}
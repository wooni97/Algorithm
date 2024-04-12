import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int gemsCnt = new HashSet<>(Arrays.asList(gems)).size();
        int length = 1000001;
        
        Map<String, Integer> gemsMap = new HashMap<>();
        int end = 0;
        
        gemsMap.put(gems[0], 1);
        for (int start = 0; start < gems.length; start++) {
            while (end < gems.length && gemsMap.size() < gemsCnt) {
                end += 1;
                if (end != gems.length) gemsMap.put(gems[end], gemsMap.getOrDefault(gems[end], 0 ) + 1);
            }
            
            if (end == gems.length) break;
            
            if (end - start + 1 < length) {
                length = end - start + 1;

                answer[0] = start + 1;
                answer[1] = end + 1;
            }
          
            
            gemsMap.put(gems[start], gemsMap.get(gems[start]) - 1);
            
            if (gemsMap.get(gems[start]) == 0)
                gemsMap.remove(gems[start]);
        }
        return answer;
    }
}
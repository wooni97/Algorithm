import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0 ) + 1);
        }
        
        for (Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue() + 1);
        }
        System.out.print(map);
        return answer -1 ;
    }
}
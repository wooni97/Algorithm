import java.util.*;

class Solution {
    
    
    public int solution(String numbers) {
        int answer = 0;
        public boolean[] visited = new boolean[numbers.length];
        public ArrayList<Integer> permutList = new ArrayList<Integer>();
        public String str = "";

        for(int i = 0; i < numbers.length; i++){
            permutaion(numbers, i, 0, str);

        }
        
        
    }
    
    static void permutaion(String[] numbers, int r, int depth, String str)

        str += str;

        if(depth == r){
            permutList.add(Integer.parseInt(str));
            str = "";
            return;
        }

        for(int i = 0; i < numbers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                permutaion(numbers, r, depth + 1, str);
                visited[i] = false;

            }
        }
}
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
	
	static HashSet<Integer> set = new HashSet<>();
	static char[] arr;
	static boolean[] visited;
	
    public int solution(String numbers) {
    	
    	arr = new char[numbers.length()];
    	visited = new boolean[numbers.length()];
    	
        int answer = 0;
        
        for(int i = 0; i < numbers.length(); i++) {
        	arr[i] = numbers.charAt(i);
        }
        
        for(int i = 0; i < numbers.length(); i++) {
        	permutations(arr, 0, i+1, "");
        }
        answer = set.size();
        return answer;
       
        
    }
    
    public void permutations(char[] arr, int depth, int level, String str) {
		
    	if(depth == level) {
    		int num = Integer.parseInt(str);
    		if(isPrime(num)) {
    			set.add(num);
    			str = "";
    		}
    		
    		return;
    	}
    	
    	for(int i = 0; i < arr.length; i++) {
    		if(visited[i]) continue;
    		visited[i] = true;
    		permutations(arr, depth + 1, level, str + arr[i]);
    		visited[i] = false;
    	}
	}
    
    public boolean isPrime(int num){
        if(num==0||num==1) return false;
        for(int i=2; i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
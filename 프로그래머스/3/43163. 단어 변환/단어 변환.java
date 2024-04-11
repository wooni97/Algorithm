import java.util.*;

class Solution {
    private int answer = 99999;
    private boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        if (!wordsList.contains(target)) return 0;
        
        visited = new boolean[words.length];
        Arrays.fill(visited, false);
        
        DFS(begin, target, wordsList, 0);
       
        return answer;
    }
    
    public void DFS(String begin, String target,List<String> wordsList, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        } 
        
        for (int i = 0; i < wordsList.size(); i++) {
            if (!visited[i] && compareDiffAlphabetCount(begin, wordsList.get(i)) == 1) {
                visited[i] = true;
                DFS(wordsList.get(i), target, wordsList, count + 1);
                visited[i] = false;
            }
        }
    }
    
    public int compareDiffAlphabetCount(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
        }
        
        return count;
    }
}
import java.util.*;

class Solution {
    List<List<Integer>> combinations;
    
    public int[] solution(int[][] dice) {
        combinations = new ArrayList<>();
        
        int diceCount = dice.length;
        createCombinations(diceCount / 2, 0, new boolean[diceCount], 0);
        
        List<Integer> winCounts = new ArrayList<>();
        for(int i = 0; i < combinations.size(); i++) {
            List<Integer> a = combinations.get(i);
            List<Integer> b = combinations.get(combinations.size() - i - 1);
            
            List<Integer> diceSumA = getDiceSum(a, dice);
            List<Integer> diceSumB = getDiceSum(b, dice);
            
            Collections.sort(diceSumB);
            
            int winCount = 0;
            for(int diceSum : diceSumA) {
                winCount += findLeftIndex(diceSumB, diceSum);
            }
            
            winCounts.add(winCount);
        }
        
        int index = 0;
        int maxWin = 0;
        for(int i = 0; i < winCounts.size(); i++) {
            if(winCounts.get(i) > maxWin) {
                maxWin = winCounts.get(i);
                index = i;
            }
        }
        
        int[] answer = new int[diceCount / 2];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = combinations.get(index).get(i) + 1;
        }
        
        return answer;
    }
    
    public List<Integer> getDiceSum(List<Integer> combination, int[][] dice) {
        List<Integer> diceSum = new ArrayList<>();
        
        int length = combination.size();
        backTracking(length, 0, combination, dice, diceSum, 0);
        
        return diceSum;
    }
    
    public void backTracking(int length, int depth, List<Integer> combination, 
                             int[][] dice, List<Integer> diceSum, int sum) {
        if(length == depth) {
            diceSum.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            sum += dice[combination.get(depth)][i];
            backTracking(length, depth+1, combination, dice, diceSum, sum);
            sum -= dice[combination.get(depth)][i];
        }
    }
    
    public int findLeftIndex(List<Integer> numList, int target) {
        int left = 0;
        int right = numList.size();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(numList.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    
    
    
    public void createCombinations(int length, int start, boolean[] visited, int depth) {
        if(depth == length) {
            List<Integer> combination = new ArrayList<>();
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) combination.add(i);
            }
            
            combinations.add(combination);
            return;
        }
        
        for(int i = start; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                createCombinations(length, i+1, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
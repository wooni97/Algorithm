import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] parts = operation.split(" ");
            
            String op = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if (op.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
            }
            
            if (op.equals("D")) {
                if (maxHeap.isEmpty()) continue;
                
                if (num == 1) {
                    int maxNumber = maxHeap.poll();
                    minHeap.remove(maxNumber);
                } 
                
                if (num == -1) {
                    int minNumber = minHeap.poll();
                    maxHeap.remove(minNumber);
                }
                
            }
        }
        
        if (maxHeap.isEmpty()) {
            return new int[] {0, 0};
        }
        
        return new int[] {maxHeap.peek(), minHeap.peek()};
    }
}
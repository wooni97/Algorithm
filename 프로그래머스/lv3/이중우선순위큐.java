import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
        	String[] token = operations[i].split(" ");
        	int value = Integer.parseInt(token[1]);
            
        	//System.out.println(token[0]);
        	if(token[0].equals("I")) {
        		
        		minHeap.offer(value);
        		maxHeap.offer(value);
        		
        	}else {
        		
        		if(value == 1) {
        			if(maxHeap.size() == 0) continue;
        			int maxValue = maxHeap.poll();
        			minHeap.remove(maxValue);
        		}else if(value == -1) {
        			if(maxHeap.size() == 0) continue;
        			int minValue = minHeap.poll();
        			maxHeap.remove(minValue);
        		}
        		
        	}
        }
        
        
        if(maxHeap.size() > 0) {
        	answer[0] = maxHeap.poll();
        	answer[1] = minHeap.poll();
        }
        
        return answer;
    }
}
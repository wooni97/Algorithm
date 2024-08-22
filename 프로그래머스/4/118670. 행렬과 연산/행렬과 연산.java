import java.util.*;

class Solution {
    private Deque<Integer> left;
    private Deque<Integer> right;
    private LinkedList<Deque<Integer>> center;
    private int rowSize;
    private int colSize;
    
    public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = {};
        
        rowSize = rc.length;
        colSize = rc[0].length;
        
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        center = new LinkedList<>();
        
        for(int i = 0; i < rowSize; i++) {
            left.offer(rc[i][0]);
            right.offer(rc[i][colSize-1]);
        }
        
        for(int i = 0; i < rowSize; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for(int j = 1; j < colSize - 1; j++) {
                dq.add(rc[i][j]);
            }
            center.add(dq);
        }
        
        for(String operation : operations) {
            if(operation.equals("Rotate")) {
                rotate();
                continue;
            }
            
            if(operation.equals("ShiftRow")) {
                shiftRow();
            }
        }
        
        return createToArray();
    }
    
    private void rotate() {
        if(colSize == 2) {
            right.addFirst(left.pollFirst());
            left.add(right.pollLast());
            return;
        }
        center.get(0).addFirst(left.pollFirst());
        right.addFirst(center.get(0).pollLast());
        center.get(center.size() - 1).add(right.pollLast());
        left.add(center.get(center.size() - 1).pollFirst());
    }
    
    private void shiftRow() {
        left.addFirst(left.pollLast());
        right.addFirst(right.pollLast());
        center.addFirst(center.pollLast());
    }
    
    private int[][] createToArray() {
        int[][] result = new int[rowSize][colSize];
        
        Iterator<Integer> iterator = left.iterator();
        Iterator<Integer> iterator2 = right.iterator();
        for(int i = 0; i < rowSize; i++) {
            result[i][0] = iterator.next();
            result[i][colSize-1] = iterator2.next();
        }
        
        for(int i = 0; i < rowSize; i++) {
            for(int j = 1; j < colSize - 1; j++) {
                result[i][j] = center.get(i).pollFirst();
            }
        }
        
        return result;
    }
}
import java.util.*;

class Solution {
    int n;
    Map<Integer, Node> nodes;
    List<List<Integer>> sequenceNumbers;
    
    public int[] solution(int[][] edges, int[] target) {
        init(edges, target);
        
        int turn = 0;
        while(!isTurnFinished(target)) {
            if(isImpossible(target))
                return new int[] {-1};
            turn++;
            
            Node current = nodes.get(1); // root
            while(!current.isLeaf()) {
                Node child = current.getConnectedChild();
                current.changeConnectedChild();
                current = child;
            }
            
            sequenceNumbers.get(current.getNodeNumber() - 1).add(turn);
        }
        
        int[] answer = new int[turn];
        for(int i = 0; i < n; i++) {
            List<Integer> sequence = sequenceNumbers.get(i);
            if(sequence.isEmpty()) continue;
            
            int numberCount = sequence.size();
            int targetNumber = target[i];
            
            int threeCount = (targetNumber - numberCount) / 2;
            int twoCount = (targetNumber - numberCount) % 2;
            
            int[] temp = new int[numberCount];
            
            for(int j = 0; j < threeCount; j++) {
                temp[j] = 3;
            }
            
            for(int j = threeCount; j < threeCount + twoCount; j++) {
                temp[j] = 2;
            }
            
            for(int j = threeCount + twoCount; j < numberCount; j++) {
                temp[j] = 1;
            }
            
            for(int j = 0; j < sequence.size(); j++) {
                answer[sequence.get(j) - 1] = temp[numberCount - j - 1];
            }
            
        }
        
        return answer;
        
    }
    
    public void init(int[][] edges, int[] target) {
        n = target.length;
        nodes = new HashMap<>();
        sequenceNumbers = new ArrayList<>();
        
        for(int[] edge: edges) {
            int parent = edge[0];
            int child = edge[1];
            
            if(!nodes.containsKey(parent)) {
                nodes.put(parent, new Node(parent));
            }
            
            if(!nodes.containsKey(child)) {
                nodes.put(child, new Node(child));
            }
            
            nodes.get(parent).addChild(nodes.get(child));
        }
        
        for(int nodeNumber : nodes.keySet()) {
            nodes.get(nodeNumber).setStart();
        }
        
        for(int i = 0; i < n; i++) {
            sequenceNumbers.add(new ArrayList<Integer>());
        }
    }
    
    public boolean isTurnFinished(int[] target) {
        for(int i = 0; i < n; i++) {
            if(!(sequenceNumbers.get(i).size() <= target[i] && target[i] <= sequenceNumbers.get(i).size() * 3))
                return false;
        }
        
        return true;
    }
    
    public boolean isImpossible(int[] target) {
        for(int i = 0; i < n; i++) {
            if(sequenceNumbers.get(i).size() > target[i]) return true;
        }
        
        return false;
    }
    
    class Node {
        int nodeNumber;
        List<Node> children = new ArrayList<>();
        int connectedChildIndex;
        boolean isLeaf = false;
        
        public Node(int nodeNumber) {
            this.nodeNumber = nodeNumber;
        }
        
        public int getNodeNumber() {
            return this.nodeNumber;
        }
        
        public void addChild(Node node) {
            children.add(node);
        }
        
        public void setStart() {
            if(children.size() == 0) {
                isLeaf = true;
                return;
            }
            Collections.sort(children, (o1, o2) -> o1.getNodeNumber() - o2.getNodeNumber());
            this.connectedChildIndex = 0;
        }
        
        public void changeConnectedChild() {
            if (children.size() == connectedChildIndex + 1) {
                this.connectedChildIndex = 0;
                return;
            }
            
            this.connectedChildIndex += 1;
        }
        
        public Node getConnectedChild() {
            return children.get(this.connectedChildIndex);
        }
        
        public boolean isLeaf() {
            return this.isLeaf;
        }
        
        
    }
}
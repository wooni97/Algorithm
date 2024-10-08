import java.util.*;

class Solution {
    int distance[][];
    List<Pair>[] adj;
    List<Pair>[] adjReverse;
    int[] trapIdx;
    
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        
        distance = new int[n+1][1024];
        adj = new List[n+1];
        adjReverse = new List[n+1];
        trapIdx = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 1024; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            adjReverse[i] = new ArrayList<>();
            trapIdx[i] = -1;
        }
        
        for(int i = 0; i < traps.length; i++) {
            trapIdx[traps[i]] = i;
        }
        
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj[u].add(new Pair(v, w));
            adjReverse[v].add(new Pair(u, w));
        }
        
        distance[start][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        pq.offer(new Tuple(0, start, 0));
        
        while(!pq.isEmpty()) {
            Tuple curr = pq.poll();
            
            if(curr.room == end) return curr.distance;
            if(curr.distance > distance[curr.room][curr.state]) continue;
            
            for(int i = 0; i < adj[curr.room].size(); i++) {
                Pair next = adj[curr.room].get(i);
                
                int rev = 0;
                if(trapIdx[curr.room] != -1 && bitmask(curr.state, curr.room)) rev ^= 1;
                if(trapIdx[next.room] != -1 && bitmask(curr.state, next.room)) rev ^= 1;
                
                if(rev != 0) continue;
                
                int nextState = curr.state;
                if(trapIdx[next.room] != -1) nextState ^= (1 << trapIdx[next.room]);
                if(distance[next.room][nextState] > next.weight + curr.distance) {
                    distance[next.room][nextState] = next.weight + curr.distance;
                    pq.add(new Tuple(distance[next.room][nextState], next.room, nextState));
                }
            }
            
            for(int i = 0; i < adjReverse[curr.room].size(); i++) {
                Pair next = adjReverse[curr.room].get(i);
                int rev = 0;
                if(trapIdx[curr.room] != -1 && bitmask(curr.state, curr.room)) rev ^= 1;
                if(trapIdx[next.room] != -1 && bitmask(curr.state, next.room)) rev ^= 1;
                
                if(rev != 1) continue;
                
                int nextState = curr.state;
                if(trapIdx[next.room] != -1) nextState ^= (1 << trapIdx[next.room]);
                if(distance[next.room][nextState] > next.weight + curr.distance) {
                    distance[next.room][nextState] = next.weight + curr.distance;
                    pq.add(new Tuple(distance[next.room][nextState], next.room, nextState));
                }   
            }
            
        }
        
        return -1;
        
    }
    
    private boolean bitmask(int state, int room) {
        return ((1 << trapIdx[room]) & state) != 0;
    }
    
    class Tuple implements Comparable<Tuple> {
        int distance;
        int room;
        int state;
        
        public Tuple(int distance, int room, int state) {
            this.distance = distance;
            this.room = room;
            this.state = state;
        }
        
        @Override
        public int compareTo(Tuple o) {
            return this.distance - o.distance;
        }
    }
    
    class Pair {
        int room;
        int weight;
        
        public Pair(int room, int weight) {
            this.weight = weight;
            this.room = room;
        }
    }
}
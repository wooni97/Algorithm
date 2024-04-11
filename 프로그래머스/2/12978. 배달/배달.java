import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[] distance = new int[N+1];
        
        distance[1] = 0; 
        for (int i = 2; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        List<List<int[]>> matrix = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            List<int[]> l = new ArrayList<>();
            matrix.add(l);
        }
        
        for (int[] connected : road) {
            int village1 = connected[0];
            int village2 = connected[1];
            int d = connected[2];
            
            matrix.get(village1).add(new int[] {village2, d});
            matrix.get(village2).add(new int[] {village1, d});
        }
     
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.offer(new int[] {0, 1});
        
        while(!pq.isEmpty()) {
            int[] distanceAndVillage = pq.poll();
            int dist = distanceAndVillage[0];
            int village = distanceAndVillage[1];
            
            if (distance[village] == dist) {
                List<int[]> connection = matrix.get(village);
                for (int[] connected : connection) {
                    if (dist + connected[1] < distance[connected[0]]) {
                        distance[connected[0]] = dist + connected[1];
                        pq.offer(new int[] {dist + connected[1], connected[0]});
                    }
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) answer += 1;
        }

        return answer;
    }
}
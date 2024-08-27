// import java.util.*;

// class Solution {
//     private List<List<Integer>> connected;
//     private long answer;
  
//     public long solution(int[] a, int[][] edges) {
//         answer = 0;
//         int length = a.length;
        
//         long[] copy = new long[length];
//         int temp = 0;
//         for(int i = 0; i < length; i++) {
//             copy[i] = a[i];
//             temp += a[i];
//         }
        
//         if(temp != 0) return -1;
        
//         connected = new ArrayList<List<Integer>>();
//         for(int i = 0; i < length; i++) {
//             connected.add(new LinkedList<Integer>());
//         }
        
//         for(int[] edge : edges) {
//             connected.get(edge[0]).add(edge[1]);
//             connected.get(edge[1]).add(edge[0]);
//         }
        
//         boolean[] visited = new boolean[length];
//         dfs(-1, 0, visited, copy);
        
//         if(copy[0] == 0) return answer;
//         return -1;
//     }
    
//     private long dfs(int parent, int current, boolean[] visited, long[] a) {
//         visited[current] = true;
//         for(int c : connected.get(current)) {
//             if(!visited[c]) {
//                 a[current] += dfs(current, c, visited, a);
//             }    
//         }
        
//         if(current != 0) {
//             answer += Math.abs(0 - a[current]);
//         }
        
//         return a[current];    
//     }
// }


import java.util.*;

class Solution {
    long answer = 0;
    long tmp[]; 
    int visit[];
    List<Integer>[] edgeList;
    
    public long solution(int[] a, int[][] edges) {
        
        int len = a.length;
        tmp = new long[len];
        visit = new int[len];
        long sum = 0;
        edgeList = new ArrayList[len];
        for(int i = 0; i < len; i++) {
			sum += a[i];
            tmp[i] = a[i];
            edgeList[i] = new ArrayList<Integer>();
	    }
        //불가능
        if(sum!=0)
            return -1;
        
        for(int i = 0; i < edges.length; i++) {
	    	edgeList[edges[i][0]].add(edges[i][1]);
	    	edgeList[edges[i][1]].add(edges[i][0]);
		}
        
        dfs(0);
        
        return answer;
    }
    
    long dfs(int node){
        visit[node] = 1;
        for(int i=0; i<edgeList[node].size(); i++){
            int next = edgeList[node].get(i);
            if(visit[next]==1)
                continue;
            tmp[node] += dfs(next);
            
        }
        long num = tmp[node];
        answer += Math.abs(num);
        return num;
    }
}
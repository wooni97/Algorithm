class Solution {
    int answer = 0;
    boolean[] checked;
    int[] info;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        checked = new boolean[(int) Math.pow(2, info.length)];
        dfs(0, edges, new boolean[info.length], 1, 0, 0);
        
        return answer;
        
    }
    
    private void dfs(int currentNode, int[][] edges, boolean[] visited, int state, int sheepCount, int wolfCount) {
        visited[currentNode] = true;
        checked[state] = true;
        
        if(info[currentNode] == 0) {
            sheepCount++;
            answer = Math.max(sheepCount, answer);
        } else if(info[currentNode] == 1) {
            wolfCount++;
        }
        
        if(wolfCount >= sheepCount) return;
        
        for(int[] edge : edges) {
            if(visited[edge[0]] && !visited[edge[1]] && !checked[state | (1 <<edge[1])]) {
                boolean[] newVisited = visited.clone();
                dfs(edge[1], edges, newVisited, state | (1 <<edge[1]), sheepCount, wolfCount);
            }
        }
    }
}
class Solution {
    public int solution(int[][] clockHands) {
        int answer = 0;
        
        int n = clockHands.length;
        
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(getUnsolvedCount(clockHands) != 0) {
            int count = 0;
            int x = -1;
            int y = -1;
            
            for(int i = 0 ; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int temp = 0;
                    if(clockHands[i][j] != 0) temp++;
                    
                    for(int k = 0; k < 4; k++) {
                        if(i + dx[k] < 0 || i + dx[k] >= n || j + dy[k] < 0 || j + dy[k] >= n) continue;
                        
                        if(clockHands[i + dx[k]][j + dy[k]] != 0) temp++;
                    }
                    
                    if(temp > count) {
                        count = temp;
                        x = i;
                        y = j;
                    }
                }
            }
            if(x == -1 || y == -1) continue;
            
            clockHands[x][y] = (clockHands[x][y] + 1) % 4;
            for(int k = 0; k < 4; k++) {
                if(x + dx[k] < 0 || x + dx[k] >= n || y + dy[k] < 0 || y + dy[k] >= n) continue;
                        
                clockHands[x + dx[k]][y + dy[k]] = (clockHands[x + dx[k]][y + dy[k]] + 1) % 4;
            }
            
            answer++;
        }
        
        return answer;
    }
    
    private int getUnsolvedCount(int[][] clockHands) {
        int count = 0;
        for(int i = 0 ; i < clockHands.length; i++) {
            for(int j = 0; j < clockHands[0].length; j++) {
                if(clockHands[i][j] != 0) count ++;
            }
        }
        
        return count;
    }
}


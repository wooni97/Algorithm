class Solution {
    int[][] prefixSum;
    int n;
    int m;
    
    public int solution(int[][] board, int[][] skill) {
        n = board.length;
        m = board[0].length;
        
        prefixSum = new int[n][m];
        
        for(int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if(type == 1) {
                prefixSum[r1][c1] -= degree;
                
                if(c2 + 1 < m) prefixSum[r1][c2 + 1] += degree;
                
                if(r2 + 1 < n) prefixSum[r2 + 1][c1] += degree;
                
                if((r2 + 1 < n) && (c2 + 1 < m)) prefixSum[r2 + 1][c2 + 1] -= degree;
            }
            
            if(type == 2) {
                prefixSum[r1][c1] += degree;
                
                if(c2 + 1 < m) prefixSum[r1][c2 + 1] -= degree;
                
                if(r2 + 1 < n) prefixSum[r2 + 1][c1] -= degree;
                
                if((r2 + 1 < n) && (c2 + 1 < m)) prefixSum[r2 + 1][c2 + 1] += degree;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                prefixSum[i][j] += prefixSum[i][j-1];
            }
        }
        
        for(int j = 0; j < m; j++) {
            for(int i = 1; i < n; i++) {
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] + prefixSum[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}
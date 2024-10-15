class Solution {
    private final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌
    private int n;
    
    public int solution(int[][] clockHands) {
        
        int min = Integer.MAX_VALUE;
        n = clockHands.length;
        
        // Greedy
        for(int i = 0; i < (1 << (2*n)); i++) { // 첫 행 모든 경우의 수
            int[][] copy = deepCopy(clockHands);
            int cnt = 0;
            int temp = i;
            
            // 첫 행 조작
            for(int col = 0; col < n; col++) { // 오른쪽 부터 0~3 으로 돌려보기
                int rotateCnt = temp % 4;
                temp /= 4;
                cnt += rotateCnt;
                rotate(copy, 0, col, rotateCnt);
            }
            
            // 나머지 행 조작
            for(int row = 1; row < n; row++) {
                for(int col = 0; col < n; col++) {
                    int rotateCnt = (4 - copy[row-1][col]) % 4; // 바로 윗행 값을 0으로 만드는 회전수
                    cnt += rotateCnt;
                    rotate(copy, row, col, rotateCnt);
                }
            }
            
            // 마지막 행이 모두 0인지 확인
            boolean flag = true;
            for(int col = 0; col < n; col++) {
                if(copy[n-1][col] != 0)  {
                    flag = false;
                    break;
                }
            }
            if(flag) min = Math.min(min, cnt);
        }

        return min;
    }
    
    private void rotate(int[][] arr, int row, int col, int rotateCnt) {
        arr[row][col] = (arr[row][col] + rotateCnt) % 4; // 현재 좌표 돌림
        for(int[] d : dir) {
            int r = row + d[0];
            int c = col + d[1];
            if( 0 <= r && r < n && 0 <= c && c < n) {
                arr[r][c] = (arr[r][c] + rotateCnt) % 4; // 4방 좌표 돌림
            }
        }
    }
    
    private int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, n);
        }
        return copy;
    }
}
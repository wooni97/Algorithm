class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    private static int RED_START = 1;
    private static int BLUE_START = 2;
    private static int RED_DESTINATION = 3;
    private static int BLUE_DESTINATION = 4;
    private static int WALL = 5;
    
    private int answer = Integer.MAX_VALUE;
    private boolean[][][] visited;
    private boolean isRedArrived, isBlueArrived;
    
    public static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maze) {
        visited = new boolean[maze.length][maze[0].length][2];
        
        Point redStartPoint = null;
        Point blueStartPoint = null;
        
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == RED_START) redStartPoint = new Point(i, j);
                if(maze[i][j] == BLUE_START) blueStartPoint = new Point(i, j);
            }
        }
        
        visited[redStartPoint.x][redStartPoint.y][0] = true;
        visited[blueStartPoint.x][blueStartPoint.y][1] = true;
        
        int result = backTracking(redStartPoint, blueStartPoint, 0, maze);
        
        if(result < Integer.MAX_VALUE) return result;
        return 0;
    }
    
    public int backTracking(Point currentRed, Point currentBlue, int turnCount, int[][] map) {
        if (isRedArrived && isBlueArrived) {
            System.out.println(turnCount);
            return turnCount;
        }
            
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                Point nextRed = isRedArrived ? currentRed : getNext(currentRed, i);
                Point nextBlue = isBlueArrived? currentBlue : getNext(currentBlue, j);
                
                if(!canMove(currentRed, nextRed, currentBlue, nextBlue, map)) continue;
                
                visited[nextRed.x][nextRed.y][0] = true;
                visited[nextBlue.x][nextBlue.y][1] = true;
                
                if(map[nextRed.x][nextRed.y] == RED_DESTINATION) isRedArrived = true;
                if(map[nextBlue.x][nextBlue.y] == BLUE_DESTINATION) isBlueArrived = true;
                
                answer = Math.min(answer, backTracking(nextRed, nextBlue, turnCount + 1, map));
                
                visited[nextRed.x][nextRed.y][0] = false;
                visited[nextBlue.x][nextBlue.y][1] = false;
                
                isRedArrived = false;
                isBlueArrived = false;
            }
        }
        
        return answer;
    }
    
    public Point getNext(Point current, int dir) {
        return new Point(current.x + dx[dir], current.y + dy[dir]);
    }
    
    public boolean canMove(Point currentRed, Point nextRed, 
                           Point currentBlue, Point nextBlue, int[][] map) {
        // 동시에 같은 칸으로 이동 불가
        if((nextRed.x == nextBlue.x) && (nextRed.y == nextBlue.y)) return false;
        
        // map 범위 내 체크
        if(nextRed.x < 0 || nextRed.x >= map.length || nextBlue.x < 0 || nextBlue.x >= map.length ||
          nextRed.y < 0 || nextRed.y >= map[0].length || nextBlue.y < 0 || nextBlue.y >= map[0].length) return false;
        
        // 벽으로 이동 불가
        if(map[nextRed.x][nextRed.y] == WALL || map[nextBlue.x][nextBlue.y] == WALL) return false;
        
        // 도착한 상태가 아닌데 방문한 적 있으면 이동 불가
        if((!isRedArrived && visited[nextRed.x][nextRed.y][0]) || (!isBlueArrived && visited[nextBlue.x][nextBlue.y][1])) return false;
        
        // 수레끼리 자리를 바꾸며 이동 불가
        if((nextRed.x == currentBlue.x && nextRed.y == currentBlue.y) && 
           (nextBlue.x == currentRed.x && nextBlue.y == currentRed.y)) return false;
        
        return true;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] maze;
    static int[][] wallBreakCount;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        wallBreakCount = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            Arrays.fill(wallBreakCount[i], INF);
            for(int j = 0; j < m; j++) {
                maze[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        wallBreakCount[0][0] = 0;

        PriorityQueue<Room> q = new PriorityQueue<>();
        q.add(new Room(0, 0, 0));

        while(!q.isEmpty()) {
            Room room = q.poll();

            if(wallBreakCount[room.x][room.y] != room.breakCount)
                continue;

            for(int i = 0; i < 4; i++) {
                int nextX = room.x + dx[i];
                int nextY = room.y + dy[i];

                if(!inRange(nextX, nextY)) continue;

                if(maze[nextX][nextY] == 1 && (room.breakCount + 1 < wallBreakCount[nextX][nextY])) {
                    q.add(new Room(room.breakCount + 1, nextX, nextY));
                    wallBreakCount[nextX][nextY] = room.breakCount + 1;
                    
                }

                if(maze[nextX][nextY] == 0 && (room.breakCount < wallBreakCount[nextX][nextY])) {
                    q.add(new Room(room.breakCount, nextX, nextY));
                    wallBreakCount[nextX][nextY] = room.breakCount;
                    
                }

            }

        }

        System.out.println(wallBreakCount[n-1][m-1]);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Room implements Comparable<Room>{
        int breakCount;
        int x;
        int y;

        public Room(int breakCount, int x, int y) {
            this.breakCount = breakCount;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Room o) {
            return this.breakCount - o.breakCount;
        }
    }
}

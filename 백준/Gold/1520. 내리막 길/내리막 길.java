
import java.io.*;
import java.util.*;

public class Main {
    private static int m;
    private static int n;
    private static int[][] graph;
    private static int[][] dp;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m+1][n+1];
        dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int idx = 1;
            while(st.hasMoreTokens()){
                graph[i][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(BFS(1, 1));

    }

    private static int BFS(int x, int y) {
        if(x == m && y == n)
            return 1;

        if (dp[x][y] != -1)
            return dp[x][y];
        
        dp[x][y] = 0;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= 0 || nx > m || ny <= 0 || ny > n) continue;

            if(graph[x][y] <= graph[nx][ny]) continue;

            dp[x][y] += BFS(nx, ny);
        }

        return dp[x][y];
    }
}

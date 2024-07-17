
import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int[][] graph;
    private static int[][] dp;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        createDP();
        System.out.println(answer * answer);
    }

    private static void createDP() {
        initializeDP();

        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < m; j++) {
                if(graph[i][j] == 0) continue;

                dp[i][j] = getSmallest(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1;
                answer = Math.max(answer, dp[i][j]);
            }
        }
    }

    private static int getSmallest(int a, int b, int c) {
        int smallest = a;
        if (b < smallest) {
            smallest = b;
        }
        if (c < smallest) {
            smallest = c;
        }
        return smallest;
    }

    private static void initializeDP() {
        for(int j = 0; j < m; j++) {
            if(graph[0][j] == 1) answer = 1;
            dp[0][j] = graph[0][j];
        }


        for(int i = 0; i < n; i++) {
            if (graph[i][0] == 1) answer = 1;
            dp[i][0] = graph[i][0];
        }

        for(int i = 0; i < n-1; i++) {
            if (graph[i][0] == 1) answer = 1;
            dp[i][m - 1] = graph[i][m - 1];
        }
    }
}

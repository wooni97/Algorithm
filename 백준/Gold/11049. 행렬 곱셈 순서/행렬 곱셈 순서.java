import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer[]> rc = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            rc.add(new Integer[]{r, c});

            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][n-1] = recursive(0, n-1);
        System.out.println(dp[0][n-1]);
    }

    private static int recursive(int i, int j) {
        if(i == j) return 0;
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        for(int idx = i; idx < j; idx++) {
            int result = recursive(i, idx) + recursive(idx + 1, j) + (rc.get(i)[0] * rc.get(idx)[1] * rc.get(j)[1]);
            dp[i][j] = Math.min(dp[i][j], result);
        }
        
        return dp[i][j];
    }
}

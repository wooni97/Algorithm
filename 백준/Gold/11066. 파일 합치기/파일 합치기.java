import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] pages = new int[n+1];
            int[] sum = new int[n+1];
            int[][] dp = new int[n+1][n+1];
            for(int i = 1; i <= n; i ++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                pages[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + pages[i];
            }

            sb.append(getLeastPrice(1, n, pages, dp, sum)).append("\n");
        }

        System.out.println(sb);
    }

    private static int getLeastPrice(int start, int end, int[] pages, int[][] dp, int[] sum) {
        if(start == end) return 0;
        if(dp[start][end] != Integer.MAX_VALUE) return dp[start][end];

        for(int i = start; i < end; i++) {
            int result1 = getLeastPrice(start, i, pages, dp, sum);
            int result2 = getLeastPrice(i+1, end, pages, dp, sum);

            dp[start][end] = Math.min(dp[start][end], result1 + result2 + sum[end] - sum[start - 1]);
        }

        return dp[start][end];
    }
}

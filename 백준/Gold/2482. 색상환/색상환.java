
import java.io.*;

public class Main {
    private static final int MOD = 1_000_000_003;
    private static int n;
    private static int k;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        dp = new int[n+1][k+1];

        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= k; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
            }
        }

        dp[n][k] = (dp[n-1][k] + dp[n-3][k-1]) % MOD;

        System.out.println(dp[n][k]);
    }
}

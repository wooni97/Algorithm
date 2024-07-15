
import java.io.*;
import java.util.*;

public class Main {
    private static int MAX_VALUE = 100_001;
    private static int n;
    private static int k;
    private static boolean[] coins = new boolean[MAX_VALUE];
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k+1];
        Arrays.fill(dp, MAX_VALUE);

        for(int i = 0; i < n; i++){
            int coin = Integer.parseInt(br.readLine());
            coins[coin] = true;
        }

        if(!coins[k]){
            createDp();
            printAnswer();
        } else if(coins[k]){
            System.out.println(1);
        }

    }

    private static void createDp(){
        for(int i = 1; i <= k; i++){
            if(coins[i]){
                dp[i] = 1;
                continue;
            }

            for(int j = 1; j <= i/2; j++){
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }
    }

    private static void printAnswer(){
        if(dp[k] < MAX_VALUE){
            System.out.println(dp[k]);
            return;
        }

        System.out.println(-1);
    }
}

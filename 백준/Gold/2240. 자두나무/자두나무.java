
import java.util.*;
import java.io.*;

public class Main {
    private static int t;
    private static int w;
    private static int[] treeNumbers;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        treeNumbers = new int[t+1];
        dp = new int[t+1][w+1];

        int treeNumber = 0;
        for(int i = 1; i < t+1; i++){
            treeNumber = Integer.parseInt(br.readLine());
            treeNumbers[i] = treeNumber;
        }

        // dp 초기화
        for(int i = 0; i < w+1; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i < t+1; i++){
            for(int j = 0; j < w+1; j++){
                if(j == 0 && treeNumbers[i] == 1){
                    dp[i][j] = dp[i-1][j] + 1;
                    continue;
                }

                if(j == 0 && treeNumbers[i] == 2){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }

                if(j % 2 == 1 && treeNumbers[i] == 1){
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                    continue;
                }

                if(j % 2 == 1 && treeNumbers[i] == 2){
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + 1;
                    continue;
                }

                if(j % 2 == 0 && treeNumbers[i] == 1){
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + 1;
                    continue;
                }

                if(j % 2 == 0 && treeNumbers[i] == 2){
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                    continue;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < w+1; i++){
            answer = Math.max(answer, dp[t][i]);
        }

        System.out.println(answer);


    }
}

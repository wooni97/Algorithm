import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] nums;
    private static boolean[][] dp;
    private static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        dp = new boolean[n+1][n+1];
        nums[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;
        while(st.hasMoreTokens()){
            nums[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        createDp();

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (isPalindrome(start, end) == true) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void createDp() {
        for(int i = 1; i < n + 1; i++){
            dp[i][i] = true;
            if(nums[i] == nums[i-1]) dp[i-1][i] = true;
        }

        for(int j = 2; j < n; j++){
            for(int i = 1; i < n-j+1; i++){
                if(nums[i] == nums[i+j] && dp[i+1][i+j-1])
                    dp[i][i+j] = true;
            }
        }
    }

    private static boolean isPalindrome(int start, int end){
        return dp[start][end];
    }
}

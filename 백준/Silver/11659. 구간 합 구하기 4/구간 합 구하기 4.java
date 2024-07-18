
import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int[] nums;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n+1];
        dp = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        createDP();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[end] - dp[start-1]);
            if(i < m-1) sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void createDP() {
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
    }
}

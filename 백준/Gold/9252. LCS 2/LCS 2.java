import java.io.*;

public class Main {
    static String inputString1;
    static String inputString2;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputString1 = " " + br.readLine();
        inputString2 = " " + br.readLine();

        dp = new int[inputString1.length() + 1][inputString2.length() + 1];

        for(int i = 0; i < inputString1.length(); i++) {
            for(int j = 0; j < inputString2.length(); j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if(inputString1.charAt(i) == inputString2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[inputString1.length() - 1][inputString2.length()- 1]).append("\n");

        if(dp[inputString1.length() - 1][inputString2.length() -1] != 0) {
            sb.append(backTracking(inputString1.length() - 1, inputString2.length()- 1));
        }

        System.out.println(sb);
    }

    private static String backTracking(int i, int j) {
        if(i == 0 || j == 0) return "";
        if(inputString1.charAt(i) == inputString2.charAt(j))
            return backTracking(i-1, j-1)  + inputString1.charAt(i);

        if(dp[i-1][j] > dp[i][j-1])
            return backTracking(i-1, j);
        return backTracking(i, j-1);
    }
}

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);
        System.out.println(getLcs(s1, s2, dp));
    }

    private static String getLcs(String s1, String s2, int[][] dp) {
        StringBuilder lcs = new StringBuilder();

        int i = s1.length();
        int j = s2.length();
        while(lcs.length() < dp[s1.length()][s2.length()]) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i-1));
                i--;
                j--;
                continue;
            }

            if(dp[i-1][j]  >= dp[i][j-1]) {
                i--;
                continue;
            }

            j--;

        }

        return lcs.toString();
    }
}

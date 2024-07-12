
import java.io.*;

public class Main {
    private static final int MOD = 1000000;
    private static String code;
    private static long[] dp;
    private static int n; //암호 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        code = '0' + br.readLine();

        n = code.length();
        dp = new long[n];

        createDp();

        if(dp[n-1] != 0) System.out.println(dp[n-1]);
    }

    private static int combineChars(char char1, char char2){
        int digit1 = char1 - '0';
        int digit2 = char2 - '0';
        return digit1 * 10 + digit2;
    }

    private static void createDp() {
        if(code.charAt(1) == '0') {
            wrongCode();
            return;
        }

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 1; i < n; i++){
            int combinedNumber = combineChars(code.charAt(i-1), code.charAt(i));
            if(code.charAt(i) == '0'){
                if(combinedNumber >= 10 && combinedNumber <= 26){
                    dp[i] = dp[i-2] % MOD;
                    continue;
                }

                wrongCode();
                return;
            }

            if(code.charAt(i) != '0'){
                if(combinedNumber >= 10 && combinedNumber <= 26){
                    dp[i] = (dp[i-2] + dp[i-1]) % MOD;
                    continue;
                }

                dp[i] = dp[i-1] % MOD;
            }
        }
    }

    private static void wrongCode(){
        System.out.print('0');
    }
}

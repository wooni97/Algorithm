import java.io.*;

public class Main {
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] dp1 = new int[n+1]; // dp1[n] : n번째 자리가 1
        int[] dp2 = new int[n+1]; // dp2[n] : n번째 자리가 0

        dp1[1] = 1;
        dp2[1] = 0;
        
        if(n == 1) {
            System.out.println(1);
            return;
        }

        if(n == 2) {
            System.out.println(2);
            return;
        }

        if(n == 3) {
            System.out.println(3);
            return;
        }

        dp1[2] = 1;
        dp2[2] = 1;
        dp1[3] = 2;
        dp2[3] = 1;

        for(int i = 4; i < n + 1; i++) {
            dp1[i] = (dp1[i-1] + dp2[i-1]) % 15746;
            dp2[i] = (dp1[i-2] + dp2[i-2]) % 15746;
        }

        System.out.println((dp1[n] + dp2[n]) % 15746);
    }
}
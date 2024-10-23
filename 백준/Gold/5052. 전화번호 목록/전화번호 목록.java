
import java.io.*;
import java.util.*;

public class Main {
    static final int MX = 10 * 10_000 + 5;
    static final int ROOT = 1;
    static int unused;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] nxt = new int[MX][10];
            boolean[] check = new boolean[MX];
            unused = 2;

            for(int i = 0; i < MX; i++) {
                Arrays.fill(nxt[i], -1);
            }

            boolean flag = true;
            while(n-- > 0) {
                if(!insertAndCheck(br.readLine(), nxt, check)) {
                    flag = false;
                }
            }

            if(!flag) {
                sb.append("NO").append("\n");
                continue;
            }

            sb.append("YES").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean insertAndCheck(String s, int[][] nxt, boolean[] check) {
        int cur = ROOT;
        for(int i = 0; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            if(nxt[cur][num] == -1)
                nxt[cur][num] = unused++;

            cur = nxt[cur][num];

            if(check[cur]) {
                return false;
            }
        }

        for(int i = 0; i < 10; i++) {
            if(nxt[cur][i] != -1) {
                return false; // 더 긴 번호가 이미 존재함
            }
        }

        check[cur] = true;
        return true;
    }
}

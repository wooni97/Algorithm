import java.io.*;
import java.util.*;

public class Main {
    static final int ROOT = 1;
    static int unused = 2;
    static final int MX = 500 * 10_000 + 5;
    static int[][] nxt = new int[MX][26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < MX; i++) {
            Arrays.fill(nxt[i], -1);
        }

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while(n--> 0) {
            insert(br.readLine());
        }

        int answer = 0;
        while(m-- > 0) {
            if(findPrefix(br.readLine()))
                answer ++;
        }

        System.out.println(answer);
    }

    private static void insert(String s) {
        int cur = ROOT;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(nxt[cur][charToInt(c)] == -1)
                nxt[cur][charToInt(c)] = unused++;

            cur = nxt[cur][charToInt(c)];
        }
    }

    private static boolean findPrefix(String s) {
        int cur = ROOT;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(nxt[cur][charToInt(c)] == -1)
                return false;

            cur = nxt[cur][charToInt(c)];
        }

        return true;
    }

    private static int charToInt(char c) {
        return c - 'a';
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static final int ROOT = 1;
    static final int MX = 500 * 10_000 + 5;
    static int[][] nxt = new int[MX][26];
    static int unused = 2;
    static boolean[] check = new boolean[MX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < MX; i++) {
            Arrays.fill(nxt[i], -1);
        }

        while(n-- > 0) {
            insert(br.readLine());
        }

        int answer = 0;
        while(m -- > 0) {
            if(find(br.readLine()))
                answer++;
        }

        System.out.println(answer);
    }

    private static void insert(String s) {
        int cur = ROOT;
        for(int i = 0; i < s.length(); i++) {
            if(nxt[cur][charToInt(s.charAt(i))] == -1)
                nxt[cur][charToInt(s.charAt(i))] = unused++;
            cur = nxt[cur][charToInt(s.charAt(i))];
        }

        check[cur] = true;
    }

    private static boolean find(String s) {
        int cur = ROOT;
        for(int i = 0; i < s.length(); i++) {
            if(nxt[cur][charToInt(s.charAt(i))] == -1)
                return false;
            cur = nxt[cur][charToInt(s.charAt(i))];
        }

        return check[cur];
    }

    private static int charToInt(char c) {
        return c - 'a';
    }
}

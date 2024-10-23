import java.io.*;
import java.util.*;

public class Main {
    static final int ROOT = 1;
    static final int MX = 300_000 * 8 + 5;
    static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int unused = 2;
    static int[][] nxt = new int[MX][26];
    static boolean[] check = new boolean[MX];
    static boolean[][] visited;
    static Set<String> resultSet;
    static StringBuilder sb;
    static  BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < MX; i++) {
            Arrays.fill(nxt[i], -1);
        }

        int w = Integer.parseInt(br.readLine());
        while(w-- > 0) {
            insert(br.readLine());
        }

        br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int b = Integer.parseInt(br.readLine());
        while(b-- > 0) {
            Character[][] boggle = makeBoggle();
            visited = new boolean[4][4];
            resultSet = new HashSet<>();
            sb = new StringBuilder();

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    visited[i][j] = true;
                    sb.append(boggle[i][j]);
                    dfs(boggle, i, j, ROOT, sb);
                    visited[i][j] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

            int score = 0;
            int maxLength = 0;
            String maxLengthWord = "";
            for(String s : resultSet) {
                int length = s.length();
                score += getScore(length);

                if(length > maxLength ||
                        (length == maxLength && s.compareTo(maxLengthWord) < 0)) {
                    maxLengthWord = s;
                    maxLength = length;
                }
            }

            bw.write(score + " " + maxLengthWord + " " + resultSet.size() + "\n");
            if(b > 0)
                br.readLine();
        }

        bw.flush();
    }

    private static int getScore(int length) {
        if(length == 1 || length == 2)
            return 0;

        if(length == 3 || length == 4)
            return 1;

        if(length == 5)
            return 2;

        if(length == 6)
            return 3;

        if(length == 7)
            return 5;

        if(length == 8)
            return 11;

        return 1;
    }
    private static void dfs(Character[][] boggle, int i, int j, int idx, StringBuilder words) {
        Character c = boggle[i][j];

        if(nxt[idx][charToInt(c)] == -1)
            return;

        idx = nxt[idx][charToInt(c)];
        if(check[idx])
            resultSet.add(words.toString());

        for(int k = 0; k < 8; k++) {
            int nxtX = i + dx[k];
            int nxtY = j + dy[k];

            if(nxtX < 0 || nxtX >= 4 || nxtY < 0 || nxtY >= 4)
                continue;

            if(visited[nxtX][nxtY])
                continue;

            visited[nxtX][nxtY] = true;
            sb.append(boggle[nxtX][nxtY]);
            dfs(boggle, nxtX, nxtY, idx, sb);
            visited[nxtX][nxtY] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static Character[][] makeBoggle() throws IOException {
        Character[][] boggle = new Character[4][4];
        for(int i = 0; i < 4; i++) {
            String s = br.readLine();
            for(int j = 0; j < 4; j++) {
                boggle[i][j] = s.charAt(j);
            }
        }

        return boggle;
    }

    private static void insert(String s) {
        int curr = ROOT;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if(nxt[curr][charToInt(c)] == -1)
                nxt[curr][charToInt(c)] = unused++;

            curr = nxt[curr][charToInt(c)];
        }

        check[curr] = true;
    }

    private static int charToInt(Character c) {
        return c - 'A';
    }
}

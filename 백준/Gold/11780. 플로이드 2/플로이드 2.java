import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] nxt;
    static int MAX = 9900001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        nxt = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j<= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = MAX;
            }
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            map[s][e] = Math.min(map[s][e], w);
            nxt[s][e] = e;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <=n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == MAX) System.out.print("0");
                else System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.print('\n');
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 0 || map[i][j] == MAX){
                    System.out.println("0");
                    continue;
                }
                
                List<Integer> path = new ArrayList<>();
                int start = i;
                while (start != j) {
                    path.add(start);
                    start = nxt[start][j];
                }
                path.add(j);
                System.out.print(path.size() + " ");
                for (Integer p : path) {
                    System.out.print(p + " ");
                }
                System.out.println("");
            }
        }
    }
}
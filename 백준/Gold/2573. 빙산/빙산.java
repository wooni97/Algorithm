
import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};
    private static int n;
    private static int m;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        int yearCount = 0;

        while(true) {
            int iceBurgCount = dfs();
            if(iceBurgCount >= 2) break;
            if(iceBurgCount == 0) {
                flag = false;
                break;
            }

            yearCount++;
            graph = meltIceBurg();
        }

        if(flag) System.out.println(yearCount);
        if(!flag) System.out.println(0);
    }

    private static int[][] meltIceBurg() {
        int[][] newGraph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) continue;

                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int surroundX = i + dx[k];
                    int surroundY = j + dy[k];

                    if (surroundX < 0 || surroundX >= n || surroundY < 0 || surroundY >= m) continue;

                    if (graph[surroundX][surroundY] == 0) count++;


                    newGraph[i][j] = graph[i][j] - count > 0 ? graph[i][j] - count : 0;
                }
            }
        }
        return newGraph;
    }

    private static int dfs() {
        boolean[][] visited = new boolean[n][m];

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (graph[i][j] == 0) continue;
                if (visited[i][j]) continue;

                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});

                while(!stack.isEmpty()) {
                    int[] current = stack.pop();
                    int currentX = current[0];
                    int currentY = current[1];
                    for (int k = 0; k < 4; k++) {
                        int nextX = currentX + dx[k];
                        int nextY = currentY + dy[k];

                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                        if (visited[nextX][nextY]) continue;
                        if (graph[nextX][nextY] == 0) continue;

                        visited[nextX][nextY] = true;
                        stack.push(new int[]{nextX, nextY});
                    }
                }

                result++;
            }
        }

        return result;
    }
}

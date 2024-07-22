import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] graph;
    private static int maxPrecipitation = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMaxPrecipitation();

        int answer = 0;
        for(int precipitation = 0; precipitation < maxPrecipitation; precipitation++) {
            answer = Math.max(answer, countArea(precipitation));
        }

        System.out.println(answer);

    }

    private static int countArea(int precipitation) {
        int areaCount = 0;
        boolean[][] visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (graph[i][j] <= precipitation || visited[i][j])
                    continue;

                BFS(i, j, visited, precipitation);
                areaCount++;
            }
        }

        return areaCount;
    }

    private static void BFS(int x, int y, boolean[][] visited, int precipitation) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();

        visited[x][y] = true;
        queue.add(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currentX = curr[0];
            int currentY = curr[1];

            for(int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
                    continue;

                if(graph[nextX][nextY] <= precipitation || visited[nextX][nextY])
                    continue;

                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY});
            }
        }
    }

    private static void findMaxPrecipitation() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                maxPrecipitation = Math.max(maxPrecipitation, graph[i][j]);
            }
        }
    }
}

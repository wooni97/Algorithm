import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 단지 수
        int communityCount = 0;
        List<Integer> houseCountPerCommunity = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0 || visited[i][j])
                    continue;

                communityCount++;
                bfs(i, j, visited, map, houseCountPerCommunity, n);
            }
        }

        Collections.sort(houseCountPerCommunity);

        System.out.println(communityCount);
        for(Integer count : houseCountPerCommunity) {
            System.out.println(count);
        }
    }

    private static void bfs(int x, int y, boolean[][] visited, int[][] map, List<Integer> houseCountPerCommunity, int n) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        visited[x][y] = true;
        int houseCount = 1;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];

            for(int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
                    continue;

                if(map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    houseCount++;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        houseCountPerCommunity.add(houseCount);
    }
}

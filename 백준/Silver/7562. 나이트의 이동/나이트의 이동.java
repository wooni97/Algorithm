
import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int testCaseCount;
    private static int boardSize;
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        testCaseCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(testCaseCount-- > 0) {
            getInput();
            initBoard();
            bfs(startX, startY);

            sb.append(graph[endX][endY]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void getInput() throws IOException {
        boardSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
    }

    private static void initBoard() {
        graph = new int[boardSize][boardSize];

        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        graph[startX][startY] = 0;
    }

    private static void bfs(int startX, int startY) {
        int[] dx = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY, 0});

        while(!queue.isEmpty()) {
            int[] currentInfo = queue.poll();
            int currentX = currentInfo[0];
            int currentY = currentInfo[1];
            int currentCount = currentInfo[2];

            for(int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                int nextCount = currentCount + 1;

                if(nextX < 0 || nextX >= boardSize || nextY < 0 || nextY >= boardSize) continue;

                if(nextCount < graph[nextX][nextY]) {
                    graph[nextX][nextY] = nextCount;
                    queue.add(new int[]{nextX, nextY, nextCount});
                }
            }
        }
    }

}

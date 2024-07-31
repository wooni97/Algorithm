
import java.io.*;
import java.util.*;

public class Main {
    private static final int WHITE = 0;
    private static final int BLUE = 1;
    private static int[][] graph;
    private static int whitePaperCount;
    private static int bluePaperCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        whitePaperCount = 0;
        bluePaperCount = 0;

        recursive(0, 0, n);

        System.out.println(whitePaperCount);
        System.out.println(bluePaperCount);
    }

    private static void recursive(int startX, int startY, int size) {
        int initColor = graph[startX][startY] == WHITE ? WHITE : BLUE;

        for(int i = startX; i < startX + size; i++) {
            for(int j = startY; j < startY + size; j++) {
                if (graph[i][j] == initColor) continue;

                recursive(startX, startY, size / 2);
                recursive(startX + size / 2, startY, size / 2);
                recursive(startX, startY + size / 2, size / 2);
                recursive(startX + size / 2, startY + size / 2, size / 2);

                return;
            }
        }

        if(initColor == WHITE) whitePaperCount++;
        if(initColor == BLUE) bluePaperCount++;
    }
}

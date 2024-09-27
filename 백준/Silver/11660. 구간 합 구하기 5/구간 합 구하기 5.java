import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n+1][n+1];

        int idx = 1;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                matrix[idx][j] = Integer.parseInt(st.nextToken()) +
                        matrix[idx-1][j] + matrix[idx][j-1] - matrix[idx-1][j-1];
            }

            idx++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int subTractX1 = x1 -1;
            int subTractY1 = y2;
            int subTractX2 = x2;
            int stubTractY2 = y1 -1;

            int answer = matrix[x2][y2]
                    - matrix[subTractX1][subTractY1]
                    - matrix[subTractX2][stubTractY2]
                    + matrix[Math.min(subTractX1, subTractX2)][Math.min(subTractY1, stubTractY2)];

            sb.append(answer + "\n");
        }

        System.out.println(sb);

    }
}

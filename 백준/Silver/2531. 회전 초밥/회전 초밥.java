import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int d;
    private static int k;
    private static int c;
    private static int[] sushi;
    private static int[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[n];
        visited = new int[3001];

        for(int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int result = Integer.MIN_VALUE;
        int typeCount = 1;
        visited[c] = 1;
        int end = 0;
        for(int start = 0; start < n; start++) {
            while(end - start < k) {
                int temp = -1;
                if (end >= n) temp = end - n;
                if (end < n) temp = end;

                if(visited[sushi[temp]] == 0) typeCount++;
                visited[sushi[temp]] += 1;

                end++;
            }
            result = Math.max(result, typeCount);
            if(result == k + 1) break;

            visited[sushi[start]] -= 1;
            if (visited[sushi[start]] == 0) typeCount--;
        }

        System.out.println(result);
    }
}

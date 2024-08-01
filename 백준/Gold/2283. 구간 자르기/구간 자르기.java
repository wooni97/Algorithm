
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 1_000_000;
    private static int n;
    private static int k;
    private static int[] lines = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines[start]++;
            lines[end]--;
        }

        for(int i = 1; i < MAX + 1; i++) {
            lines[i] += lines[i-1];
        }

        int start;
        int end = 0;
        int total = 0;
        boolean flag = false;
        for(start = 0; start < MAX; start++) {
            while(end < MAX + 1 && total <= k) {
                if(total == k) {
                    flag = true;
                    break;
                }

                total += lines[end];
                end++;
            }

            if(flag) break;
            total -= lines[start];
        }

        if(flag) {
            System.out.println(start + " " + end);
        } else {
            System.out.println(0 + " " + 0);
        }
    }
}

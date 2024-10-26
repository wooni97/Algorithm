import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] trees = new int[n];
        stringTokenizer = new StringTokenizer(br.readLine());

        int maxTreeHeight = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(stringTokenizer.nextToken());
            maxTreeHeight = Math.max(maxTreeHeight, trees[i]);
        }

        long st = 0;
        long end = maxTreeHeight;
        long answer = 0;

        while(st <= end) {
            long treeTotalHeight = 0;
            long mid = (st + end) / 2;

            for(int tree : trees) {
                treeTotalHeight += tree - mid > 0 ? tree - mid : 0;
            }

            if(treeTotalHeight < m) {
                end = mid - 1;
                continue;
            }

            answer = mid;
            st = mid + 1;
        }

        System.out.println(answer);
    }
}

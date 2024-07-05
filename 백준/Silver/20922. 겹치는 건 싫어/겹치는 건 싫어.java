
import java.util.*;
import java.io.*;

public class Main {
    private static final int MAXIMUM_RANGE = 100000;
    private static int n;
    private static int k;
    private static int[] nums;
    private static int[] count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        int index = 0;
        while(st.hasMoreTokens()) {
            nums[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        count = new int[MAXIMUM_RANGE + 1];

        int length = 0;
        int end = 0;
        for(int start = 0; start < n; start++) {
            while(end < n) {
                if(count[nums[end]] < k) {
                    count[nums[end]] += 1;

                    end++;
                    length = Math.max(length, end - start);
                    continue;
                }

                if(count[nums[end]] >= k ) break;
            }

            count[nums[start]] -= 1;
        }

        System.out.println(length);


    }
}

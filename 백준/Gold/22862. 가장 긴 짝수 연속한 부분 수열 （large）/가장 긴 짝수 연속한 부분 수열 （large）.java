
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] erased = new boolean[n];
        int end = 0;
        int result = 0;
        int cnt = 0;

        for(int start = 0; start < n; start++) {
            while(end < n) {
                if(nums[end] % 2 == 1 && cnt < k) {
                    erased[end] = true;
                    cnt++;
                    end++;
                    continue;
                }

                if(nums[end] % 2 == 0) {
                    end++;
                    continue;
                }

                break;
            }

            result = Math.max(result, end - start - cnt);

            if(erased[start]) {
                erased[start] = false;
                cnt -= 1;
            }
        }

        System.out.println(result);

    }
}

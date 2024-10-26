
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[] length = new int[n];

        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++) {
            length[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, length[i]);
        }

        long st = 1;
        long en = (long) maxLength;

        while(st < en) {
            int count = 0;
            long mid = (st + en + 1) / 2;

            for(int i = 0; i < k; i++) {
                count += length[i] / mid;
            }

            if(count < n) {
                en = mid - 1;
                continue;
            }


            st = mid;

        }

        System.out.println(st);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] liquid = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int start = 0, end = n -1;
        int result = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        while(start < end) {
            int temp = liquid[start] + liquid[end];

            if(Math.abs(temp) < result) {
                result = Math.abs(temp);
                index1 = start;
                index2 = end;
            }

            if(result == 0)
                break;

            if(temp < 0) {
                start++;
                continue;
            }

            if(temp > 0) {
                end--;
            }
        }

        System.out.println(liquid[index1] + " " + liquid[index2]);

    }
}

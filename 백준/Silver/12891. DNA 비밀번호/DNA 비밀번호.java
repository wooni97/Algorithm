
import java.util.*;
import java.io.*;

public class Main {
    static int p;
    static int s;
    static char[] chars;
    static int[] minCounts = new int[4];
    static int[] currentCounts = new int[4];
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        chars = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            minCounts[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < p; i++) {
            if(chars[i] == 'A') currentCounts[0]++;
            if(chars[i] == 'C') currentCounts[1]++;
            if(chars[i] == 'G') currentCounts[2]++;
            if(chars[i] == 'T') currentCounts[3]++;
        }

        if(checkCounting())
            answer++;

        for(int right = p; right < s; right++) {
            int left = right - p;
            if(chars[left] == 'A') currentCounts[0]--;
            if(chars[left] == 'C') currentCounts[1]--;
            if(chars[left] == 'G') currentCounts[2]--;
            if(chars[left] == 'T') currentCounts[3]--;

            if(chars[right] == 'A') currentCounts[0]++;
            if(chars[right] == 'C') currentCounts[1]++;
            if(chars[right] == 'G') currentCounts[2]++;
            if(chars[right] == 'T') currentCounts[3]++;

            if(checkCounting()) {
                answer++;
            }

        }
        System.out.println(answer);

    }

    private static boolean checkCounting() {
        for(int i = 0; i < 4; i++) {
            if(currentCounts[i] < minCounts[i])
                return false;
        }

        return true;
    }
}

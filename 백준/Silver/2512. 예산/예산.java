import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int[] cities;
        int totalBudget;

        n = Integer.parseInt(br.readLine());
        cities = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxBudget = Integer.MIN_VALUE;
        int citiesBudgetSum = 0;
        for(int i = 0; i < n; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
            citiesBudgetSum += cities[i];
            maxBudget = Math.max(maxBudget, cities[i]);
        }

        totalBudget = Integer.parseInt(br.readLine());

        if(citiesBudgetSum <= totalBudget) {
            System.out.println(maxBudget);
            return;
        }

        System.out.println(parametricSearch(totalBudget, n, cities));
    }

    private static int parametricSearch(int totalBudget, int n, int[] cities) {
        int start = 1;
        int end = totalBudget;

        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                if(cities[i] <= mid) {
                    sum += cities[i];
                    max = Math.max(max, cities[i]);
                    continue;
                }

                if(cities[i] > mid) {
                    sum += mid;
                    max = Math.max(max, mid);
                }
            }

            if(sum > totalBudget) {
                end = mid - 1;
                continue;
            }

            result = max;
            start = mid + 1;
        }

        return result;
    }
}

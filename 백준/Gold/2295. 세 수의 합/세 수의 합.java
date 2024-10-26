
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        List<Integer> twoSums = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                twoSums.add(numbers[i] + numbers[j]);
            }
        }
        Collections.sort(twoSums);

        for(int i = n-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(Collections.binarySearch(twoSums, numbers[i] - numbers[j]) >= 0) {
                    System.out.println(numbers[i]);
                    return;
                }
            }
        }
    }
}

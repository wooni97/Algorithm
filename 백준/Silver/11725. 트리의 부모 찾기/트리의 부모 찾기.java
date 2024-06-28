
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] parent = new int[n+1];
        Map<Integer, List<Integer>> connected = new HashMap<>();

        for(int i = 0; i <= n; i++) {
            connected.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);

            connected.get(node1).add(node2);
            connected.get(node2).add(node1);
        }

        parent[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int node : connected.get(curr)) {
                if(parent[curr] == node) continue;
                queue.offer(node);
                parent[node] = curr;
            }
        }

        for(int i = 2; i < n+1 ; i++) {
            System.out.println(parent[i]);
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n+1];
        List<Integer>[] adj = new List[n+1];

        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        while(m -- > 0) {
            st = new StringTokenizer(br.readLine());

            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            adj[front].add(back);
            indegree[back] += 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append(" ");

            for(int i = 0; i < adj[curr].size(); i++) {
                int nxt = adj[curr].get(i);

                indegree[nxt] -= 1;

                if(indegree[nxt] == 0)
                    queue.add(nxt);
            }
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}

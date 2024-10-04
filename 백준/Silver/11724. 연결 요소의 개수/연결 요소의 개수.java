import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;

            dfs(i, visited);
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void dfs(int node, boolean[] visited) {
        visited[node] = true;

        for(Integer next : graph[node]) {
            if(visited[next]) continue;
            dfs(next, visited);
        }
    }
}

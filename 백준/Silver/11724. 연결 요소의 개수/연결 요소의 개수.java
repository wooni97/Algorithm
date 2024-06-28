
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] graph = new int[n+1][n+1];


        for(int i = 0; i < m; i++){
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        System.out.println(solution(n, graph));
    }

    public static int solution(int n, int[][] graph){
        boolean[] visited = new boolean[n+1];
        int answer = 0;

        for(int i = 1; i < n+1; i++) {
            if(!visited[i]){
                operator(i, n, visited, graph);
                answer += 1;
            }
        }

        return answer;
    }

    public static boolean[] operator(int i, int n, boolean[] visited, int[][] graph){
        visited[i] = true;

        for(int j = 1; j < n + 1; j++){
            if(graph[i][j] == 1 && !visited[j]){
                visited = operator(j, n, visited, graph);
            }
        }

        return visited;
    }


}

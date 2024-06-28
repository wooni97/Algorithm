

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        // 정점의 개수
        int n = Integer.parseInt(line[0]);
        // 간선의 개수
        int m = Integer.parseInt(line[1]);
        // 탐색을 시작할 정점 번호
        int v = Integer.parseInt(line[2]);

        // 그래프를 인접 리스트로 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // 인접 리스트 정렬 (정점 번호가 작은 것을 먼저 방문하기 위해)
        for (List<Integer> neighbors : graph) {
            Collections.sort(neighbors);
        }

        // DFS 수행
        boolean[] dfsVisited = new boolean[n + 1];
        List<Integer> dfsPath = new ArrayList<>();
        dfs(v, dfsVisited, graph, dfsPath);

        // BFS 수행
        boolean[] bfsVisited = new boolean[n + 1];
        List<Integer> bfsPath = new ArrayList<>();
        bfs(v, bfsVisited, graph, bfsPath);

        // 결과 출력
        printPath(dfsPath);
        printPath(bfsPath);
    }

    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph, List<Integer> path) {
        visited[node] = true;
        path.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph, path);
            }
        }
    }

    public static void bfs(int startNode, boolean[] visited, List<List<Integer>> graph, List<Integer> path) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            path.add(node);

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void printPath(List<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
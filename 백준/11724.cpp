#include <iostream>
#include <vector>

using namespace std;
void operator_dfs(int i, vector<bool>& visited, vector<vector<int>>& graph) {
    visited[i] = true;
    
    for (int node : graph[i]) {
        if(!visited[node]) {
            operator_dfs(node, visited, graph);
        }
    }
}

int solution(int n, vector<vector<int>>& graph) {
    vector<bool> visited(n+1, false);
    int answer = 0;

    for (int i = 1; i <= n; i++) {
        if(!visited[i]) {
            operator_dfs(i, visited, graph);
            answer++;
        }
    }

    return answer;
}
int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<int>> graph(n+1);

    for (int i = 0; i < m; i++) {
        int node1, node2;
        cin >> node1, node2;

        graph[node1].push_back(node2);
        graph[node2].push_back(node1);
    }

    cout << solution(n, graph) << endl;

    return 0;
}
#include <string>
#include <vector>

using namespace std;

void operator(int i, int n, vector<int> visited, vector<vector<int>> computers){
    visited[i] = 1;
    for(int j = 0; j < n; j++){
        if(i != j && visited[j] == 0 && computers[i][j] == 1){
            operator(j, n, visited, computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<int> visited(n);
    for(int i = 0; i < n; i++){
        if(visited[i] == 0){
            operator(i, n, visited, computers);
            answer++;
        }
    }
    return answer;
}
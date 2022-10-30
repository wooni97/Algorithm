#include <string>
#include <vector>

using namespace std;
int answer = 0;

void DFS(int depth, int sum, vector<int> numbers, int target){
    if(depth == numbers.size()){
        if(target == sum){
            answer++;
        }
    }
    else{
        DFS(depth + 1, sum + numbers[depth], numbers, target);
        DFS(depth + 1, sum - numbers[depth], numbers, target);
    }
    
}

int solution(vector<int> numbers, int target) {
    DFS(0,0,numbers, target);
    return answer;
}
/*
무향 그래프(undirected graph)가 입력으로 주어졌을 때, 연결 성분(connected component)의 개수를 세는 프로그램을 작성하시오.

연결 성분은 다음과 같이 정의된다. 주어진 그래프가 연결되어 있다면, 즉 어떤 두 노드를 고르더라도 이 둘을 잇는 경로가 있다면, 그래프 전체가 1개의 연결 성분이다. 그렇지 않다면, 둘 이상의 연결 성분들로 이루어져 있다.

예를 들어, 다음 그림의 그래프는 3개의 연결 성분으로 이루어져 있다. 노드로 이루어진 세 집합 {1, 2, 3, 4}, {5, 6}, {7}은 각각 연결 성분이다. (같은 집합에 속하는 노드는 연결되어 있다). 노드 7도 하나의 연결 성분임에 유의하라. 



입력 

표준 입력으로 입력을 받는다. 첫 줄에는 노드의 개수 N과 에지의 개수 M이 주어진다. N은 1 이상 1,000 이하, M은 0 이상 500,000 이하이다.

다음 M 줄에는 각 줄마다 그래프의 각각의 에지 (u, v)를 나타내는 두 정수 u와 v가 주어진다. 모든 노드는 1 이상 N 이하인 정수로 표현된다. 

출력

표준 출력으로 출력한다. 한 줄에 입력받은 그래프의 연결 성분의 수에 해당하는 정수를 출력한다. 

예제 입력 1

6 0 

예제 출력 1

6

예제 입력 2

7 5

1 2 

1 4 

1 3

4 3

6 5 

예제 출력 2

3
*/
#include<iostream>

using namespace std;

bool graph[1001][1001];
bool check[1001];

int N;
int M;


void DFS(int num)
{
	check[num] = true;

	for (int i = 1; i <= N; i++)
	{
		if (graph[num][i] == true  && check[i] == false) {
			DFS(i);
		}
	}


}

int main()
{
	int count = 0;
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int n;
		int m;

		cin >> n >> m;

		graph[n][m] = true;
		graph[m][n] = true;
	}

	for (int i = 1; i <= N; i++) {
		if (check[i] == false) {
			count++;
			DFS(i);
		}
	}

	cout << count << endl;
}

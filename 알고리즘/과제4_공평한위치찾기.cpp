/*
무향 그래프 G=(V, E)가 주어져 있고, 서로 다른 두 노드 a와 b에 각각 한 명씩 사람이 있다. 이 사람들은 공평한 위치인 노드 c에서 만나려고 한다. c의 조건은 다음과 같다: a에서 c까지 최단 경로 (G가 가중 그래프가 아님에 유의하시오)의 길이와 b에서 c까지 최단 경로의 길이의 차이가 가장 작은 노드이다. 

다음 그래프를 보자. 노드 1부터 9까지 총 9개의 노드가 있고, 9개의 에지 (1, 2), (1, 3), (2, 4), (2, 6), (4, 5), (5, 7), (5, 8), (6, 8), (8, 9)가 있는 그래프에서, 각각 1번 노드와 9번 노드에 있는 두 사람이 서로 만나려면, 두 노드 모두에서 같은 거리 2인 1-2-6, 9-8-6 노드 6이 공평한 위치가 된다. (그래프를 종이에 그려보면서 이해해보자)  

또, 다음 그래프를 생각해보자. 노드 1부터 6까지 총 6개의 노드가 있고, 7개의 에지 (1, 2), (1, 3), (2, 3), (2, 4), (2, 5), (3, 4), (5, 6)가 있는 그래프에서, 각각 1번 노드와 6번 노드에 있는 두 사람이 서로 만나려면, 두 노드에서부터 거리 차가 1인 노드 2 (1-2, 6-5-2), 노드 4 (1-2-4, 6-5-2-4), 노드 5 (1-2-5, 6-5) 셋이 공평한 노드가 될 수 있다. 이 경우에는 우리는 노드를 표현하는 숫자가 가장 작은 노드 2를 답으로 고르자. 

그래프와 두 사람의 위치가 주어졌을 때, 위에서 설명한 조건에 맞게 공평한 위치를 출력하는 프로그램을 작성하시오. 



입력 

표준 입력으로 입력을 받는다. 첫 줄에는 네 정수 N M A B가 주어지는데, N은 그래프의 노드 개수로 2 이상 100 이하이다. M은 그래프의 에지 개수로 0 이상 N(N-1)/2 이하이다. A와 B는 각각 두 사람의 위치를 나타내는 서로 다른 정수로, 1 이상 N 이하이다. 다음 M 줄에는 에지 각각의 정보를 나타내는 두 정수 X Y가 주어지는데, 이는 두 노드 X와 Y가 에지 (X, Y)로 이어져 있다는 뜻이다. X Y는 모두 1 이상 N 이하이며, 에지가 나열되는 순서는 모든 에지가 한번씩 꼭 나온다는 것만 빼고는 특별한 규칙이 없다. X가 Y보다 클 수도 있다. 



출력 

표준 출력으로 정수 하나를 출력한다. 이 정수는 공평한 위치에 해당하는 노드 C의 번호이다. 만약, 공평한 노드를 구할 수 없다면 대신 0을 출력한다. 



힌트 1. 어떻게 이 문제를 풀 수 있을까? 운이 좋다면, 과제 3에 사용한 코드를 일부 재활용할 수 있다. 

힌트 2. 언제 답이 0이 될 것인가? 

힌트 3. 예제를 직접 종이에 그려보면서 생각해보자. 반드시 

예제 입력 1

9 9 1 9 

1 2

1 3

2 4

2 6

4 5

5 7

5 8

6 8

8 9

예제 출력 1 

6

예제 입력 2

6 7 1 6

1 2

1 3

2 3

2 4

2 5

3 4 

5 6

예제 출력 2

2

예제 출력 3

6 4 1 6

1 2

1 3

4 6

5 6

예제 출력 3

0


*/
#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdbool>
#include <queue>
using namespace std;


vector<int> a[101];

int n, m;
int x, y;

int dist[101];
int dist2[101];

bool check[101];
bool check2[101];

int shortest_dijkstra(int k, int j) {

	for (int i = 0; i < 101; i++) { //�迭 �ʱ�ȭ(���� �� ���� �Ÿ���)
		dist[i] = 999;
		dist2[i] = 999;
	}
	
	dist[k] = 0;
	queue<int> q;
	check[k] = true;
	q.push(k);

	while (!q.empty()) {
		int t = q.front();
		q.pop();
		for (int i = 0; i < a[t].size(); i++) {
			int b = a[t][i];
			if (dist[b] > dist[t] + 1) 
				dist[b] = dist[t] + 1;
			if (check[b] == false) {
				check[b] = true; 
				q.push(b);
			}
		}
	}

	dist2[j] = 0;
	queue<int> q2;
	check2[j] = true;
	q2.push(j);

	while (!q2.empty()) {
		int t2 = q2.front();
		q2.pop();
		for (int i = 0; i < a[t2].size(); i++) {
			int b2 = a[t2][i];
			if (dist2[b2] > dist2[t2] + 1) 
				dist2[b2] = dist2[t2] + 1;
			if (check2[b2] == false) {
				check2[b2] = true; 
				q2.push(b2);
			}
		}
	}

	int cnt = 999;
	int node = 0;
	for (int i = 1; i < n + 1; i++)
	{
		if (dist[i] != 999 && dist2[i] != 999) {
			int temp = abs(dist[i] - dist2[i]);
			if (temp < cnt) {
				cnt = temp;
				node = i;
			}
		}
		else
			node = 0;
	}

	return node;

}


int main()
{
	cin >> n >> m >> x >> y;

	for (int i = 0; i < m; i++) { 
		int u, v;
		cin >> u >> v;
		a[u].push_back(v); a[v].push_back(u);
	}


	for (int i = 0; i < n; i++) {
		sort(a[i].begin(), a[i].end());
		a[i].erase(unique(a[i].begin(), a[i].end()), a[i].end());
	}



	int result = shortest_dijkstra(x, y);
	cout << result << endl;



	return 0;
}


/*
N x M 크기의 네모칸들이 있다. 각 칸에는 0개 이상 100개 이하의 동전이 있다.

이제 가장 왼쪽 위 네모칸에서, 가장 오른쪽 아래 네모칸으로 이동하려고 한다. 이동할 때는 바로 오른쪽 옆 네모칸, 또는 바로 아래 네모칸으로만 이동할 수 있다.

예를 들어 아래와 같이 4 x 5 크기 네모칸을 생각해보자. 숫자는 각 칸에 있는 동전의 개수이다.


0 4 0 2 0

1 2 0 0 1

1 0 3 0 0

2 1 2 4 2

가장 왼쪽 위에 있는 0개의 동전이 있는 칸에서, 가장 오른쪽 아래에 있는 2번 동전이 있는 칸으로 위 규칙을 지키면서 이동하려 한다. 예를 들어, 0 - 4 - 2 - 0 - 3 - 2 - 4 - 2로 이동하면 총 17개의 동전을 얻을 수 있다.

이 과정에서 얻을 수 있는 동전의 총 합 중 가장 작은 값을 구하는 프로그램을 작성하시오. 위의 예에서는 5가 가장 작은 값이다.

입력

입력은 다음과 같이 이루어진다. 첫 줄에는 두 자연수 N, M이 주어지며, 이는 네모칸의 크기를 나타낸다. N, M 모두 1 이상 1,000 이하이다.

다음 N 줄에는 한 줄에 총 M개의 0 이상 100 이하의 정수가 주어지는데, 이는 해당하는 줄의 각 칸에 있는 동전의 개수를 의미한다.


출력

단 하나의 정수를 출력하며, 이는 입력받은 네모칸을 주어진 조건대로 이동했을 때 얻을 수 있는 동전의 개수의 총합 최소값이다.


입력 예제

4 5

0 4 0 2 0

1 2 0 0 1

1 0 3 0 0

2 1 2 4 2

출력 예제

5

*/
#include<iostream>
#include<vector>
#include<string.h>
#include<algorithm>
using namespace std;

int main()
{
	

	int n, m;

	cin >> n >> m;

	
	int** arr = new int* [m];
	for (int i = 0; i < m; ++i) {
		arr[i] = new int[n];
		memset(arr[i], 0, sizeof(int)*n );
	}

	int** D = new int* [m];
	for (int i = 0; i < m; ++i) {
		D[i] = new int[n];
		memset(D[i], 0, sizeof(int) * n);
	}

	// nXm �迭 �Է�
	for (int i = 0; i < n; i++){
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
		}
	}

	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			D[i][j] = 0;
		}
	}

	
	D[0][0] = arr[0][0];


	
	for (int i = 1; i < m; i++) {
		D[0][i] = D[0][i - 1] + arr[0][i];
	}
	
	for (int i = 1; i < n; i++) {
		D[i][0] = D[i - 1][0] + arr[i][0];
	}


	
	for (int i = 1; i < n; i++) {
		for (int j = 1; j < m; j++) {
			D[i][j] = min(D[i - 1][j], D[i][j - 1]) + arr[i][j];
		}
	}

	cout << D[n-1][m-1];



	for (int i = 0; i < m; ++i) {
		delete[] arr[i];
		delete[] D[i];
	}
	delete[] arr;
	delete D;
}
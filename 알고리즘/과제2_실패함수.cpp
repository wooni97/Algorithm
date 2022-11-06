/*
주의: 과제 1과 같이 .c/.cpp/.java 파일 하나만 제출하시오. 여러분의 파일은 아래에 설명하는 failure 함수와 main 함수가 있어야 하며, 그 외 필요한 함수를 만들어 사용할 수 있다. 

실패함수를 구하는 함수 int failure(int n, char* P, int *F)를 만드시오. n은 문자열 P의 길이이며, 구한 실패 함수를 배열 F에 저장한다. 즉, F[0], ..., F[n-1]까지에 실패함수를 저장한다. 



입력 

표준 입력으로 입력을 받는다. 입력은 한 줄로, 영어 소문자로 된 최대 길이가 100인 문자열이 주어진다. 입력된 문자열의 길이가 0인 경우는 없다. 

출력 

표준 출력으로 출력한다. 출력은 한 줄로, 입력받은 문자열의 길이와 같은 수의 숫자를 사이에 공백을 두고 출력한다. 입력받은 문자열의 길이가 n이라고 하면, 출력은 차례로 F[0] F[1] ..., F[n-1], 즉 실패함수의 값을 차례대로 출력한 것이다. 



예제 입력 1  

ababaa

예제 출력 1

0 0 1 2 3 1

예제 입력 2

aababaa

예제 출력 2

0 1 0 1 0 1 2
*/
#include<iostream>
using namespace std;

void failure(int n, char* P, int* F)
{
	
	int i = 1;
	int j = 0;

	F[0] = 0;

	while (i < n)
	{
		if (P[j] == P[i]) {
			F[i] = j+1;
			i++;
			j++;
			
		}
		else if (j>0) {
			if (P[0] == P[i]) {
				F[i] = 1;
			}
			else {
				F[i] = 0;
			}
			i++;
			j = 0;
		}
		else {
			F[i] = 0;
			i++;
			
		}
	}

	

}

int main()
{
	
	char P[100];
	

	cin >> P;

	int n = int(strlen(P));

	
	int* F = new int[n];

	failure(n, P, F);

	for (int i = 0; i < n; i++) {
		cout << F[i] << " ";
	}
}

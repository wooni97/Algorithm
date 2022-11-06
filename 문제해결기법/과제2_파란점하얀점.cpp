/*
과제 2: 파란 점 하얀 점

2차원 좌표평면 (0, 0) 부터 (N, N) 안에 M개의 하얀 점이 있다. 점의 X, Y 좌표는 0 이상 N 이하인 정수임에 유의하라. 이 점 중 일부의 점을 파란 색으로 바꾸어 칠하려고 한다. 파란 점들을 이은 다각형을 만들었을 때, 이 다각형의 바깥에 하얀 점이 없게 하려고 하고, 또한 가장 적은 개수의 하얀 점을 파란 색으로 바꾸어 칠하려고 한다. 또한, 셋 이상의 점이 한 직선 위에 있는 경우는 없다. 

좌표 평면의 크기 N, 하얀 점의 수 M이 주어졌을 때, 위 조건을 만족하는 파란 점의 개수를 출력하는 프로그램을 작성하시오. 



입력 

표준 입력으로 입력을 받는다. 첫 줄에는 좌표 평면의 크기 N, 하얀 점의 수 M이 주어진다. N은 unsigned int로 표현 가능한 범위 이내인 정수이며, M은 10만 이하이다. 다음 N 줄에는 차례대로 하얀 점의 좌표를 나타내는 두 정수  X Y가 주어지는데, X, Y는 0 이상 N 이하인 정수이다. 단, 프로그램 구현 과정에서 unsigned int로 표현 가능하지 않은 값이 나올 수 있지만, long long이나 int64 등 64비트 정수 이내에서 처리할 수 있다는데 유의하시오.  



출력 

표준 출력으로 출력한다. 한 줄에 하나의 정수를 출력하는데, 파란 점의 개수를 나타낸다.  



예제 입력 1

100 6

1 1 

2 3 

1 5

5 5

4 3

5 1

예제 출력 1

4 

예제 입력 2

100 4

3 3 

6 3

1 1 

4 1

예제 출력 2

4 


*/



#include <iostream>
#include <cstdio>
#include <algorithm>
#include <stack>
#define MAX 100000

typedef long long ll;
using namespace std;

struct point {
	int x, y;
	int p, q;
};
point p[MAX];
ll ccw(const point& a, const point& b, const point& c) {
	return 1LL * (a.x * b.y + b.x * c.y + c.x * a.y - b.x * a.y - c.x * b.y - a.x * c.y);
}



bool compare(const point &a, const point &b)
{
	if (1ll * a.q * b.p != 1ll * a.p * b.q)
		return 1ll * a.q * b.p < 1ll * a.p * b.q;
	if (a.y != b.y){
		return a.y < b.y;
	}
	else{
		return a.x < b.x;
	}

}

bool compare2(const point& a, const point& b)
{
	if (1LL * a.x * b.y != 1LL * a.x * b.y)
		return 1LL * a.x * b.y < 1LL * a.x * b.y;

}
point first, second;

point nextToTop(stack<point>& s)
{


	second = s.top();
	s.pop();
	first = s.top();
	return first, second;
}

int main()
{
	
	unsigned int size;
	int n;
	
	cin >> size >> n;
	

	for (int i = 0; i < n; i++) {
		
		cin >> p[i].x >> p[i].y;
	}

	sort(p, p + n, compare);

	for (int i = 1; i < n; i++) {
		p[i].p = p[i].x - p[0].x;
		p[i].q = p[i].y - p[0].y;
	}



	sort(p + 1, p + n, compare);

	stack<point> s;

	s.push(p[0]);
	s.push(p[1]);

	

	for (int i = 2; i < n; i++) {
		while (s.size() >= 2) {
			
			nextToTop(s);

			if (ccw(first, second, p[i]) > 0) {
				s.push(second);
				break;
			}
		}
		s.push(p[i]);
	}

	cout << s.size();

}

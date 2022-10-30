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
/*
주의 1:  이 과제는 반드시 C/C++/Java 중 하나로 구현하시오. 퀵정렬, 버블정렬의 Python 코드가 강의자료에 이미 있기 때문임.

주의 2: 필요없는 출력을 절대로 하지 마시오. 여러분의 코드는 자동으로 채점될 것이기 때문에 에 필요없는 값을 출력할 경우 맞는 답을 출력하더라도 0점으로 채점될 수 있고, 이 경우 이의 신청은 받아들여지지 않습니다. 

주의 3: 제출할 파일은 C/C++/Java 소스 파일 하나만 제출하시오. 즉, foobar.c / foobar.cpp / foobar.java와 같은 식으로 제출하시오. 보고서 필요없습니다. 

 

퀵 정렬과 버블 정렬을 섞어서 정렬하는 함수 mixedSort(int n, int *A)를 구현하시오. 이 함수가 하는 일은 배열 A에 저장된 n개의 정수를 정렬하는데, 다음 규칙을 이용하여 재귀적으로 구현한다. 

- 만약 n이 10 이하이면, 버블 정렬로 정렬한다. 

- 그 이외의 경우는 재귀적으로 퀵 정렬로 정렬한다. 

퀵 정렬로 정렬하는 과정에서 정렬할 수의 범위가 10개 이하가 되면 버블 정렬로 정렬함에 유의하시오. 예를 들어, mixedSort(12, {11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12})가 호출되면 12개의 원소를 정렬하므로 퀵 정렬을 수행하며, 퀵 정렬을 어떻게 구현하는가에 따라 달라질 수 있지만, 맨 처음 원소가 기준이 된다면 다음 단계에서는 mixedSort(10, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})과 mixedSort(1, {12})가 호출되어, 최종 결과는 1 2 3 4 5 6 7 8 9 10 11 12가 될 것이다. 

여러분은 mixedSort() 이외에도, 정렬할 값들을 읽은 뒤 mixedSort()를 호출하고, 그 결과를 출력하는 프로그램을 짜야 한다.  

입력 

표준 입력으로 입력을 받는다. (이 말이 무슨 말인지 모르겠다면, scanf 또는 cin을 이용한다고 생각하면 된다.) 첫 줄에는 정렬할 수의 개수 n이 주어지고, 그 다음 줄에는 n개의 정수가 사이에 하나 이상의 공백을 두고 주어진다. 같은 정수가 두 번 이상 나올 수 있다.



출력 

표준 출력으로 출력한다. 한 줄에 입력받은 정수 n개를 오름차순으로 정렬한 결과를 숫자 사이에 공백을 하나 두고 출력한다. 



예제 입력 

12

11 1 2 3 4 5 6 7 8 9 10 12

예제 출력

1 2 3 4 5 6 7 8 9 10 11 12
*/
#include <iostream>
using namespace std;


void mixedSort(int n, int* arr, int start, int end)
{
	if (n > 10) {//QuickSort


		if (start >= end)
			return;

		int pivot = arr[start];
		int left = start;
		int right = end;

		while (left <= right) {
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left <= right) {
				swap(arr[left], arr[right]);
				left++;
				right--;
			}
		}

		
		mixedSort(right - start + 1, arr, start, right);
		mixedSort(end - left +1 , arr, left , end );
		
	}
	else {//BubbleSort
		
		for (int k = start; k < end + 1 ; k++)
		{
			for (int j = start; j < end  ; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					swap(arr[j], arr[j + 1]);
				}
				
			}

			
		}
		return;
		
		
		

	}
}


int main()
{
	int n;

	cin >> n;

	int* arr = new int[n];

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	mixedSort(n, arr, 0, n - 1);

	for (int i = 0; i < n; i++) {
		cout << arr[i] << " ";
	}

	cout << endl;

	delete[] arr;
}

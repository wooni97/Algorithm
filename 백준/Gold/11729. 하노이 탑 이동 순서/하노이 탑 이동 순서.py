
# 1. 함수의 정의
# func(a, b, n)
# 원판 n개를 a번 기둥에서 b번 기둥으로 옮기는 방법을 출력하는 함수

# 2. base condition
# n = 1 일 때 a에서 b로 옮기도록 한다.

# 3. 재귀식
# n -1 개의 원판을 기둥 a 에서 기둥 6-a-b로 옮긴다. func(a, 6-a-b, n-1)
# n번 원판을 기둥 a에서 기둥 b로 옮긴다. print(a,b)
# n -1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다. func(6-a-b, b, n-1)

import sys
input = sys.stdin.readline

N = int(input())

def func(a, b, n):
    if n == 1:
        print(a, b)
        return
    func(a, 6-a-b, n-1)
    print(a, b)
    func(6-a-b, b, n-1)


print(2**N - 1)
func(1, 3, N)
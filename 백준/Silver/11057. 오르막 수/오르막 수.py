import sys

input = sys.stdin.readline

n = int(input())


"""
1.테이블 정의하기
2.점화식 찾기
3.초기값 정의하기
"""

DP = [[1] * 10 for _ in range(1000)]

answer = 0

for i in range(n):
    for j in range(10):
        if i == 0 or j == 0:
            continue
        DP[i][j] = DP[i-1][j] + DP[i][j-1]

print(sum(DP[n-1]) % 10007)
import sys
input = sys.stdin.readline

"""
1.테이블 정의하기
2.점화식 찾기
3.초기값 정의하기
"""
dp = [0] * 1000001
dp[1] = 1
dp[2] = 2
dp[3] = 4


for i in range(4, len(dp)):
    dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009



cases = []
for i in range(int(input())):
    cases.append(int(input()))

for case in cases:
    print(dp[case])
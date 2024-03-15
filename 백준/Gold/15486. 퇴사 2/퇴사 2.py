
import sys
input = sys.stdin.readline

n = int(input())
DP = [0] * n
T, P = [], []

for _ in range(n):
    time, profit = map(int, input().split())
    T.append(time)
    P.append(profit)

if T[n-1] + n-1 <= n:
    DP[n-1] = P[n-1]

for i in range(n-2, -1, -1):
    if T[i] + i < n:
        DP[i] = max(DP[i+1], DP[T[i] + i] + P[i])
        continue
    if T[i] + i == n:
        DP[i] = max(DP[i+1], P[i])
        continue
    DP[i] = DP[i+1]

print(DP[0])


import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
DP = [i for i in arr]

for i in range(1, n):
    for j in range(i):
        if arr[i] > arr[j]:
            DP[i] = max(DP[i], arr[i] + DP[j])

print(max(DP))

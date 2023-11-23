import sys

INF = sys.maxsize
N, S = map(int, input().split())
arr = list(map(int, input().split()))



end = 0
MIN = INF
total = arr[0]

for start in range(N) :
    while end < N and total < S :
        end += 1
        if end != N:
            total += arr[end]
    if end == N :
        break

    MIN = min(MIN, end - start + 1)
    total -= arr[start]

if MIN == INF : MIN = 0
print(MIN)
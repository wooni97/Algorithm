import sys
import bisect

input = sys.stdin.readline

t = int(input())
n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

Asum, Bsum = [], []
for i in range(n):
    start = A[i]
    Asum.append(start)
    for j in range(i+1, n):
        start += A[j]
        Asum.append(start)

for i in range(m):
    start = B[i]
    Bsum.append(start)
    for j in range(i+1, m):
        start += B[j]
        Bsum.append(start)

Asum.sort()
Bsum.sort()

answer = 0
for a in Asum:
    l = bisect.bisect_left(Bsum, t - a)
    r = bisect.bisect_right(Bsum, t - a)

    answer += r-l

print(answer)
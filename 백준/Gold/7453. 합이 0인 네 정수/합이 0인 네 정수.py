import sys
from bisect import bisect_left, bisect_right

input = sys.stdin.readline

n = int(input())
A, B, C, D = [], [], [], []

for _ in range(n):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

AB = []
CD = []
for i in range(n):
    for j in range(n):
       AB.append(A[i] + B[j])
       CD.append(C[i] + D[j])

AB.sort()
CD.sort()

answer = 0
start, end = 0, n**2 - 1

while start < len(AB) and end >= 0:
    if AB[start] + CD[end] > 0:
        end -= 1
    elif AB[start] + CD[end] < 0:
        start += 1
    elif AB[start] + CD[end] == 0:
        new_start = bisect_right(AB, AB[start])
        new_end = bisect_left(CD, CD[end]) - 1

        answer += (new_start - start) * (end - new_end)
        start = new_start
        end = new_end
print(answer)
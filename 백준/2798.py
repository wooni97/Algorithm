
import sys
from itertools import combinations

n,m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

combi = list(combinations(arr,3))

min = 1000000

for c in combi :
    if sum(c) <= m and m - sum(c) >= 0 and m - sum(c) < min:
        min = m - sum(c)

print(m - min)


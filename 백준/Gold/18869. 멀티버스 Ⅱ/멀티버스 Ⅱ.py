from bisect import bisect_left
import sys
input = sys.stdin.readline

m, n = map(int, input().split())
universes = []

for _ in range(m) :
    universe = list(map(int, input().split()))
    sorted_universe = sorted(universe)
    idx = []
    for planet in universe :
        idx.append(bisect_left(sorted_universe, planet) + 1)
    universes.append(idx)

ans = 0
for i in range(m-1) :
    for j in range(i+1, m) :
        if universes[i] == universes[j] : ans += 1

print(ans)
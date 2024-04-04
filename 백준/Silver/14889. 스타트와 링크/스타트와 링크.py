import sys
from itertools import combinations
input = sys.stdin.readline


def combination(arr, n):
    result = []
    if n == 0:
        return [[]]

    for i in range(len(arr)):
        elem = arr[i]
        for rest in combination(arr[i + 1:], n - 1):
            result.append([elem] + rest)
    return result

answer = sys.maxsize
n = int(input())
players = [i for i in range(n)]
s = [list(map(int, input().split())) for _ in range(n)]

for start in combinations(players, n //2):
    link = set(players) - set(start)

    start_power, link_power = 0, 0
    for pair in combinations(start, 2):
        start_power += s[pair[0]][pair[1]]
        start_power += s[pair[1]][pair[0]]

    for pair in combinations(link, 2):
        link_power += s[pair[0]][pair[1]]
        link_power += s[pair[1]][pair[0]]

    answer = min(answer, abs(start_power - link_power))

print(answer)

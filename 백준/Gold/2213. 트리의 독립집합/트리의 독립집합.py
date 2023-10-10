import sys

n = int(sys.stdin.readline())
weight = [0] + list(map(int, sys.stdin.readline().split()))
lines = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, sys.stdin.readline().split())
    lines[a].append(b)
    lines[b].append(a)
visited = [0] * (n + 1)
dp = [[0, 0] for _ in range(n + 1)]
num = [[[], []] for _ in range(n + 1)]


def dfs(start):
    visited[start] = 1
    dp[start][0] = weight[start]
    num[start][0].append(start)
    for i in lines[start]:
        if not visited[i]:
            dfs(i)
            dp[start][0] += dp[i][1]
            for j in num[i][1]:
                num[start][0].append(j)
            if dp[i][0] <= dp[i][1]:
                dp[start][1] += dp[i][1]
                for j in num[i][1]:
                    num[start][1].append(j)
            else:
                dp[start][1] += dp[i][0]
                for j in num[i][0]:
                    num[start][1].append(j)


dfs(1)
if dp[1][0] >= dp[1][1]:
    i = 0
else:
    i = 1
print(dp[1][i])
tmp = num[1][i]
tmp.sort()
print(*tmp)
import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
INF = sys.maxsize
graph = [[INF]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

for _ in range(m):
    start, end, weight = map(int, input().split())
    graph[start][end] = min(graph[start][end], weight)


for k in range(1,n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


for a in range(1, n+1) :
    for b in range(1, n+1):
        if graph[a][b] == INF :
            print(0, end = " ")
        else:
            print(graph[a][b], end=" ")
    print()
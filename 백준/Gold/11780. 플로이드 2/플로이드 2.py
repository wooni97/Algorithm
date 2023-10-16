import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
INF = sys.maxsize
graph = [[INF]*(n+1) for _ in range(n+1)]
nxt = [[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    start, end, weight = map(int, input().split())
    graph[start][end] = min(graph[start][end], weight)
    nxt[start][end] = end

for k in range(1,n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i == j :
                graph[i][j] = 0
            else:
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]
                    nxt[i][j] = nxt[i][k]
           #graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


for a in range(1, n+1) :
    for b in range(1, n+1):
        if graph[a][b] == INF :
            print(0, end = " ")
        else:
            print(graph[a][b], end=" ")
    print()

for c in range(1, n+1):
    for d in range(1, n+1):
        if graph[c][d] == INF or graph[c][d] == 0 :
            print(0)
        else:
            route = []
            flag = True
            route.append(c)
            temp = c
            while flag:
               temp = nxt[temp][d]
               if temp == d:
                   flag = False
               route.append(temp)

            print(len(route), end = " ")
            for r in route:
                print(r, end = " ")
            print()
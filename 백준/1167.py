N = int(input())

adj = [[] for _ in range(N+1)]
visited = [-1] * (N+1)
visited[1] = 0
for _ in range(N):
    info = list(map(int, input().split()))
    node1 = info[0]
    for i in range(1, len(info), 2) :
        if info[i] != -1 :
            node2 = info[i]
            distance = info[i+1]

            adj[node1].append((node2, distance))

max_distance = 0

def DFS(start, curr_dis) :
    for nxt, nxt_dis in adj[start] :
        if visited[nxt] == -1 :
            visited[nxt] = curr_dis + nxt_dis
            DFS(nxt, curr_dis+nxt_dis)

DFS(1, 0)
start = visited.index(max(visited))

visited = [-1] * (N+1)
visited[start] = 0
DFS(start,0)
print(max(visited))
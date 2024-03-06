import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, ' '.join(input().split()))) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
"""
1. 출발점 0,0 큐에 넣는다.
2. 상하좌우 살펴보며 갈 수 있는 곳(==1) 큐에 넣는다. 
3. 이동하면서 +1
"""
q = deque()
q.append((0, 0))
visited[0][0] = 1

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
while q:
    curr_x, curr_y = q.popleft()

    for i in range(4):
        next_x = curr_x + dx[i]
        next_y = curr_y + dy[i]

        if 0 <= next_x < n and 0 <= next_y < m:
            if visited[next_x][next_y] == 1 or graph[next_x][next_y] != 1:
                continue
            q.append((next_x, next_y))
            visited[next_x][next_y] = 1
            graph[next_x][next_y] = graph[curr_x][curr_y] + 1

print(graph[n-1][m-1])
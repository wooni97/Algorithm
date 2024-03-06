
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

paper = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

"""
1.시작하는 칸을 큐에 넣고 방문했다는 표시를 남김
2.큐에서 원소를 꺼내어 그 칸에 상하좌우로 인접한 칸에 대해 3번을 진행
3.해당 칸을 이전에 방문했다면 아무것도 하지 않고, 처음으로 방문했다면 방문했다는 표시를 남기고 해당 칸을 큐에 삽입
4.큐가 빌 때 까지 2번을 반복
5.모든 칸이 큐에 1번씩 들어가므로 시간복잡도는 칸이 n개 일때 O(n)
"""

q = deque()
count = 0
size = []

def BFS(queue, paper, visited, n, m):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    size = 0
    while queue:
        cur_x, cur_y = queue.popleft()

        size += 1
        for i in range(4):
            next_x = cur_x + dx[i]
            next_y = cur_y + dy[i]

            if 0 <= next_x < n and 0 <= next_y < m:
                if visited[next_x][next_y] == 1:
                    continue
                if paper[next_x][next_y] == 0:
                    continue

                queue.append((next_x, next_y))
                visited[next_x][next_y] = 1
    return size
for i in range(n):
    for j in range(m):
        if paper[i][j] == 1 and visited[i][j] == 0:
            q.append((i, j))
            visited[i][j] = 1
            size.append(BFS(q, paper, visited, n, m))
            count += 1

print(count)
if len(size) > 0:
    print(max(size))
else :
    print(0)
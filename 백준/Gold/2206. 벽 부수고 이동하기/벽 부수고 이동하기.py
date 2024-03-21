from collections import deque


def DFS(x, y, break_cnt, n, m, map, visited):
    q = deque([(x, y, break_cnt)])
    visited[x][y][0] = 1

    while q:
        x, y, break_cnt = q.popleft()

        if x == n - 1 and y == m - 1:
            return visited[x][y][break_cnt]

        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if not (0 <= nx < n and 0 <= ny < m):
                continue

            if map[nx][ny] == 1 and break_cnt == 0:
                visited[nx][ny][1] = visited[x][y][0] + 1
                q.append((nx, ny, 1))
            if map[nx][ny] == 0 and visited[nx][ny][break_cnt] == 0:
                visited[nx][ny][break_cnt] = visited[x][y][break_cnt] + 1
                q.append((nx, ny, break_cnt))
    return -1


n, m = map(int, input().split())
map = [list(map(int, input())) for _ in range(n)]
visited = [[[0, 0] for _ in range(m)] for _ in range(n)]

print(DFS(0, 0, 0, n, m, map, visited))
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 7)


def DFS(x, y, garden, visited):
    visited[x][y] = True
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(4):
        next_x = x + dx[i]
        next_y = y + dy[i]

        if not (0 <= next_x < m and 0 <= next_y < n):
            continue
        if visited[next_x][next_y]:
            continue
        if garden[next_x][next_y] != 1:
            continue
        DFS(next_x, next_y, garden, visited)
    return

def driver(m, n, garden, visited):
    result = 0
    for i in range(m):
        for j in range(n):
            if garden[i][j] == 1 and not visited[i][j]:
                DFS(i, j, garden, visited)
                result += 1
    return result

t = int(input())
answer = []
for _ in range(t):
    m, n, k = map(int, input().split())
    garden = [[0] * n for _ in range(m)]
    visited = [[False] * n for _ in range(m)]

    for _ in range(k):
        x, y = map(int, input().split())
        garden[x][y] = 1

    answer.append(driver(m, n, garden, visited))

for a in answer:
    print(a)
import sys
from collections import deque

input = sys.stdin.readline

f, s, g, u, d = map(int, input().split())
visited = [0] * (f+1)

flag = False
def DFS(start):
    global flag
    q = deque([start])
    visited[start] = 1
    while q:
        current = q.popleft()
        if current == g:
            flag = True
            return

        for next in (current + u, current - d):
            if 0 < next <= f and visited[next] == 0:
                visited[next] = visited[current] + 1
                q.append(next)

DFS(s)
if flag:
    print(visited[g] - 1)
else:
    print("use the stairs")
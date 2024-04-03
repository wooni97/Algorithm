import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(input().rstrip()) for _ in range(n)]

rx, ry, bx, by = 0, 0, 0, 0
for i in range(1, n-1):
    for j in range(1, m-1):
        if board[i][j] == 'R':
            rx, ry = i, j
        elif board[i][j] == 'B':
            bx, by = i, j

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

q = deque([(rx, ry, bx, by, 0)])
visited = [(rx, ry, bx, by)]

def DFS():
    while q:
        rx, ry, bx, by, depth = q.popleft()
        #print(rx, ry, bx, by, depth)
        if depth >= 10:
            continue

        for i in range(4):
            red_flag = False
            blue_flag = False

            r_cnt, b_cnt = 0, 0

            nrx, nry = rx, ry
            nbx, nby = bx, by

            while True:
                nrx += dx[i]
                nry += dy[i]
                r_cnt += 1

                if board[nrx][nry] == '#':
                    nrx -= dx[i]
                    nry -= dy[i]
                    r_cnt -= 1
                    break
                if board[nrx][nry] == 'O':
                    red_flag = True
                    break

            while True:
                nbx += dx[i]
                nby += dy[i]
                b_cnt += 1

                if board[nbx][nby] == '#':
                    nbx -= dx[i]
                    nby -= dy[i]
                    b_cnt -= 1
                    break
                if board[nbx][nby] == 'O':
                    blue_flag = True
                    break

            if blue_flag:
                continue
            if red_flag:
                return depth + 1

            if nrx == nbx and nry == nby:
                if r_cnt > b_cnt:
                    nrx -= dx[i]
                    nry -= dy[i]
                elif r_cnt < b_cnt:
                    nbx -= dx[i]
                    nby -= dy[i]
            if (nrx, nry, nbx, nby) not in visited:
                visited.append((nrx, nry, nbx, nby))
                q.append((nrx, nry, nbx, nby, depth + 1))

    return -1

print(DFS())
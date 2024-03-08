import sys
from collections import deque

input = sys.stdin.readline
r, c = map(int, input().split())

map = graph = [list(map(str, ' '.join(input().split()))) for _ in range(r)]
human_visited = [[0] * c for _ in range(r)]
fire_visited = [[0] * c for _ in range(r)]

jihoon_queue = deque()
fire_queue = deque()
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

for i in range(r):
    for j in range(c):
        if map[i][j] == 'J':
            jihoon_queue.append((i, j))

        if map[i][j] == 'F':
            fire_queue.append((i, j))


def fireBFS():
    while fire_queue:
        fire_current_x, fire_current_y = fire_queue.popleft()

        for i in range(4):
            fire_next_x = fire_current_x + dx[i]
            fire_next_y = fire_current_y + dy[i]

            if not (0 <= fire_next_x < r and 0 <= fire_next_y < c):
                continue

            if map[fire_next_x][fire_next_y] == '#':
                continue

            if fire_visited[fire_next_x][fire_next_y] != 0:
                continue

            fire_visited[fire_next_x][fire_next_y] = fire_visited[fire_current_x][fire_current_y] + 1
            fire_queue.append((fire_next_x, fire_next_y))


def humanBFS():
    while jihoon_queue:
        jihoon_current_x, jihoon_current_y = jihoon_queue.popleft()

        for i in range(4):
            jihoon_next_x = jihoon_current_x + dx[i]
            jihoon_next_y = jihoon_current_y + dy[i]

            if not (0 <= jihoon_next_x < r and 0 <= jihoon_next_y < c):
                print(human_visited[jihoon_current_x][jihoon_current_y] + 1)
                return

            if map[jihoon_next_x][jihoon_next_y] != '.':
                continue

            if fire_visited[jihoon_next_x][jihoon_next_y] != 0 and fire_visited[jihoon_next_x][jihoon_next_y] <= human_visited[jihoon_current_x][jihoon_current_y] + 1:
                continue

            if human_visited[jihoon_next_x][jihoon_next_y] != 0:
                continue


            human_visited[jihoon_next_x][jihoon_next_y] = human_visited[jihoon_current_x][jihoon_current_y] + 1
            jihoon_queue.append((jihoon_next_x, jihoon_next_y))

    print("IMPOSSIBLE")


fireBFS()
humanBFS()

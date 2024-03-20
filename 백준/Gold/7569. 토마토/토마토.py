import sys
from collections import deque

input = sys.stdin.readline
m, n, h = map(int, input().split())

boxes = {}
for i in range(1, h + 1):
    boxes[i] = []

for i in range(h, 0, -1):
    for _ in range(n):
        boxes[i].append(list(map(int, input().split())))

# 익은 토마토
ripe_tomato = 0
# 익지 않은 토마토
unripe_tomato = 0

q = deque()
for k in range(1, h + 1):
    box = boxes[k]
    for i in range(n):
        for j in range(m):
            if box[i][j] == 1:
                q.append((k, i, j))
                ripe_tomato += 1
                continue
            if box[i][j] == 0:
                unripe_tomato += 1

total_tomatoes = ripe_tomato + unripe_tomato

if total_tomatoes == ripe_tomato:
    print(0)
else:
    dx = [1, -1, 0, 0]
    dy = [0, 0, -1, 1]

    cnt = 0
    while q:
        box_index, x, y = q.popleft()

        box = boxes[box_index]
        # 상 하 좌 우
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]

            if not (0 <= next_x < n and 0 <= next_y < m):
                continue
            if box[next_x][next_y] == -1:
                continue
            if box[next_x][next_y] == 0:
                box[next_x][next_y] = box[x][y] + 1
                q.append((box_index, next_x, next_y))
                cnt += 1
                continue
            if box[x][y] + 1 < box[next_x][next_y]:
                box[next_x][next_y] = box[x][y] + 1
                q.append((box_index, next_x, next_y))

        # 위 아래
        up = box_index - 1
        down = box_index + 1

        if up >= 1:
            up_box = boxes[up]
            if up_box[x][y] == 0:
                up_box[x][y] = box[x][y] + 1
                q.append((up, x, y))
                cnt += 1
            elif box[x][y] + 1 < up_box[x][y]:
                up_box[x][y] = box[x][y] + 1
                q.append((up, x, y))
        if down <= h:
            down_box = boxes[down]
            if down_box[x][y] == 0:
                down_box[x][y] = box[x][y] + 1
                q.append((down, x, y))
                cnt += 1
            elif box[x][y] + 1 < down_box[x][y]:
                down_box[x][y] = box[x][y] + 1
                q.append((down, x, y))

    if total_tomatoes != ripe_tomato + cnt:
        print(-1)
    else:
        flatten_values = [element for sublist in boxes.values() for subsublist in sublist for element in subsublist]

        # 최댓값 찾기
        max_value = max(flatten_values)
        print(max_value - 1)

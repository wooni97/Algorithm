import sys
from collections import deque

input = sys.stdin.readline

m, n = map(int, input().split())


box = [list(map(int, input().split())) for _ in range(n)]

total_tomato_count = 0
ripe_tomato_count = 0
not_ripe_tomato_count = 0
empty_count = 0
total_block_count = n * m

q = deque()
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            q.append((i, j))
            ripe_tomato_count += 1
            continue

        if box[i][j] == 0:
            not_ripe_tomato_count += 1
            continue

        empty_count += 1

total_tomato_count = ripe_tomato_count + not_ripe_tomato_count

if total_block_count - empty_count == ripe_tomato_count:
    print(0)
else:
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    days = 0
    while q:
        curr_x, curr_y = q.popleft()

        if box[curr_x][curr_y] != 1:
            ripe_tomato_count += 1

        for i in range(4):
            next_x = curr_x + dx[i]
            next_y = curr_y + dy[i]

            if 0 <= next_x < n and 0 <= next_y < m:
                if box[next_x][next_y] != 0:
                    continue
                box[next_x][next_y] = box[curr_x][curr_y] + 1
                q.append((next_x, next_y))
                days = max(days, box[next_x][next_y])

    if ripe_tomato_count != total_tomato_count:
        print(-1)
    else:
        print(days-1)

from collections import deque
import sys

def is_corner(current_direction, next_direction):
    if current_direction in [(0, 1), (0, -1)]:
        return next_direction in [(1, 0), (-1, 0)]
    elif current_direction in [(1, 0), (-1, 0)]:
        return next_direction in [(0, 1), (0, -1)]
    

def solution(board):
    def bfs(start) :
        INF = sys.maxsize

        STRAIGHT_ROAD_FEE = 100
        CORNER_ROAD_FEE = 600  # 코너 비용 + 직선 비용

        n = len(board)

        visited = [[INF] * n for _ in range(n)]
        visited[0][0] = 0    

        #상, 하, 우, 좌
        d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        queue = deque([start])
        
        while queue:
            x, y, direction, cost = queue.popleft()


            for next_d in d:
                dx, dy = next_d
                xx, yy = x + dx, y + dy

                if 0 <= xx < n and 0 <= yy < n and board[xx][yy] != 1:
                    if is_corner(direction, next_d):
                        next_cost = cost + CORNER_ROAD_FEE
                    else:
                        next_cost = cost + STRAIGHT_ROAD_FEE

                    if next_cost <= visited[xx][yy] :
                        visited[xx][yy] = next_cost
                        queue.append((xx, yy, next_d, next_cost))

        return visited[-1][-1]
    return min([bfs((0, 0, (0, 1), 0)), bfs((0, 0, (1, 0), 0))])
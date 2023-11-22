from collections import deque


def solution(board):
    answer = int(1e9)
    n = len(board)
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    q = deque()
    # x,y,direction,cost
    q.append((0, 0, -1, 0))
    visited = {(0, 0, 0): 0, (0, 0, 1): 0, (0, 0, 2): 0, (0, 0, 3): 0}
    while q:
        x, y, direction, cost = q.popleft()

        for d in range(4):
            px = x + dx[d]
            py = y + dy[d]
            if 0 <= px and px < n and 0 <= py and py < n and not board[px][py]:
                if (direction - d) % 2 == 0 or direction == -1:
                    new_cost = cost + 100
                else:
                    new_cost = cost + 600

                if px == n - 1 and py == n - 1:
                    answer = min(answer, new_cost)
                elif visited.get((px, py, d)) is None or visited.get((px, py, d)) > new_cost:
                    visited[(px, py, d)] = new_cost
                    q.append((px, py, d, new_cost))

    return answer
# from collections import deque
# import sys

# def is_corner(current_direction, next_direction):
#     if current_direction in [(0, 1), (0, -1)]:
#         return next_direction in [(1, 0), (-1, 0)]
#     elif current_direction in [(1, 0), (-1, 0)]:
#         return next_direction in [(0, 1), (0, -1)]
    

# def solution(board):
#     INF = sys.maxsize
#     STRAIGHT_ROAD_FEE = 100
#     CORNER_ROAD_FEE = 600  # 코너 비용 + 직선 비용
#     n = len(board)
    
#     visited = [[INF] * n for _ in range(n)]
#     visited[0][0] = 0    

#     d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    
#     queue = deque()
    
#     if board[0][1] != 1 :
#         queue.append((0, 1, (0, 1)))  # 출발 지점 설정
#         visited[0][1] = STRAIGHT_ROAD_FEE
        
#     if board[1][0] != 1 :
#         queue.append((1, 0, (1, 0)))
#         visited[1][0] = STRAIGHT_ROAD_FEE
    

#     while queue:
#         x, y, direction = queue.popleft()
    
#         for next_d in d:
#             dx, dy = next_d
#             xx, yy = x + dx, y + dy
            
#             if 0 <= xx < n and 0 <= yy < n and board[xx][yy] == 0:
#                 if is_corner(direction, next_d):
#                     cost = visited[x][y] + CORNER_ROAD_FEE
#                 else:
#                     cost = visited[x][y] + STRAIGHT_ROAD_FEE
                
#                 if cost <= visited[xx][yy]:
#                     visited[xx][yy] = cost
#                     queue.append((xx, yy, next_d))

#     return visited[-1][-1]

from collections import deque

def solution(board):
    def bfs(start):
        direc = {0:[-1, 0], 1:[0, 1], 2:[1, 0], 3:[0, -1]} # 북,동,남,서 순서
        length = len(board)
        visited = [[987654321]*length for _ in range(length)]
        visited[0][0] = 0

        q = deque([start]) # x, y, cost, dir
        while q:
            x, y, cost, d = q.popleft()
            for i in range(4): # 북,동,남,서 순서
                nx = x + direc[i][0]
                ny = y + direc[i][1]

                # board 안에 있고, 벽이 아닌지 확인
                if 0 <= nx < length and 0 <= ny < length and board[nx][ny] == 0:
                    
                    # 비용계산
                    if i == d : ncost = cost + 100
                    else : ncost =  cost + 600
                    # 최소 비용이면 갱신 후 endeque!
                    if ncost < visited[nx][ny]:
                        visited[nx][ny] = ncost
                        q.append([nx, ny, ncost, i])
                        
        return visited[-1][-1]
    
    return min([bfs((0, 0, 0, 1)), bfs((0, 0, 0, 2))])
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
    
#     #상, 하, 우, 좌
#     d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    
#     queue = deque()
    
#     if board[0][1] != 1 :
#         queue.append((0, 1, (0, 1), 100))  
#         visited[0][1] = STRAIGHT_ROAD_FEE
        
#     if board[1][0] != 1 :
#         queue.append((1, 0, (1, 0), 100))
#         visited[1][0] = STRAIGHT_ROAD_FEE
    

#     while queue:
#         x, y, direction, cost = queue.popleft()
        
            
#         for next_d in d:
#             dx, dy = next_d
#             xx, yy = x + dx, y + dy
            
#             if 0 <= xx < n and 0 <= yy < n and board[xx][yy] != 1:
#                 if is_corner(direction, next_d):
#                     next_cost = cost + CORNER_ROAD_FEE
#                 else:
#                     next_cost = cost + STRAIGHT_ROAD_FEE
                
#                 if next_cost <= visited[xx][yy] :
#                     visited[xx][yy] = next_cost
#                     queue.append((xx, yy, next_d, next_cost))
    
#     return visited[-1][-1]

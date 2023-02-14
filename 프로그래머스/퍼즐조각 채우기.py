import copy


def solution(game_board, table):
    n = len(game_board)
    answer = 0
    # game_board의 빈칸 좌표를 구해서 0,0좌표를 기준으로 옮기기
    blank = []
    for i in range(n):
        for j in range(n):
            if game_board[i][j] == 0:
                blank.append(dfs(game_board, i, j, [0, 0], n, 0))

    for k in range(4):
        table = rotate(table)
        copy_table = copy.deepcopy(table)
        for i in range(n):
            for j in range(n):
                if copy_table[i][j] == 1:
                    block = dfs(copy_table, i, j, [0, 0], n, 1)
                    if block in blank:
                        blank.remove(block)
                        answer += len(block)
                        table = copy.deepcopy(copy_table)
                    else:
                        copy_table = copy.deepcopy(table)
    return answer


# position은 기준이 되는 좌표 -> 0,0으로 옮기기 위한 기준이 되는 좌표
def dfs(board, x, y, position, n, num):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    result = [position]

    board[x][y] = 2  # 방문처리

    for i in range(4):
        px = x + dx[i]
        py = y + dy[i]

        if 0 <= px and px < n and 0 <= py and py < n:
            if board[px][py] == num:
                result += dfs(board, px, py, [position[0] + dx[i], position[1] + dy[i]], n, num)

    return result

# 회전
def rotate(table):
    n = len(table)
    rotated = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            rotated[j][n - i - 1] = table[i][j]

    return rotated
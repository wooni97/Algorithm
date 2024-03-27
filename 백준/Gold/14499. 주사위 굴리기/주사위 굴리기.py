import sys

input = sys.stdin.readline

EAST = 1
WEST = 2
NORTH = 3
SOUTH = 4

# 입력
n, m, x, y, k = map(int, input().split())
map_data = [list(map(int, input().split())) for _ in range(n)]
orders = list(map(int, input().split()))

# 주사위 초기화
dice = {1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0}

def can_move(x, y):
    if 0 <= x < n and 0 <= y < m:
        return True

    return False

def move_east(dice, x, y, map_data):
    dice_idx1 = dice[1]
    dice_idx3 = dice[3]
    dice_idx4 = dice[4]
    dice_idx6 = dice[6]

    dice[1] = dice_idx4
    dice[4] = dice_idx6
    dice[3] = dice_idx1
    dice[6] = dice_idx3

    if map_data[x][y] == 0:
        map_data[x][y] = dice[6]
    elif map_data[x][y] != 0:
        dice[6] = map_data[x][y]
        map_data[x][y] = 0

def move_west(dice, x, y, map_data):
    dice_idx1 = dice[1]
    dice_idx3 = dice[3]
    dice_idx4 = dice[4]
    dice_idx6 = dice[6]

    dice[1] = dice_idx3
    dice[4] = dice_idx1
    dice[3] = dice_idx6
    dice[6] = dice_idx4

    if map_data[x][y] == 0:
        map_data[x][y] = dice[6]
    elif map_data[x][y] != 0:
        dice[6] = map_data[x][y]
        map_data[x][y] = 0

def move_north(dice, x, y, map_data):
    dice_idx1 = dice[1]
    dice_idx2 = dice[2]
    dice_idx5 = dice[5]
    dice_idx6 = dice[6]

    dice[1] = dice_idx5
    dice[2] = dice_idx1
    dice[5] = dice_idx6
    dice[6] = dice_idx2

    if map_data[x][y] == 0:
        map_data[x][y] = dice[6]
    elif map_data[x][y] != 0:
        dice[6] = map_data[x][y]
        map_data[x][y] = 0

def move_south(dice, x, y, map_data):
    dice_idx1 = dice[1]
    dice_idx2 = dice[2]
    dice_idx5 = dice[5]
    dice_idx6 = dice[6]

    dice[1] = dice_idx2
    dice[2] = dice_idx6
    dice[5] = dice_idx1
    dice[6] = dice_idx5

    if map_data[x][y] == 0:
        map_data[x][y] = dice[6]
    elif map_data[x][y] != 0:
        dice[6] = map_data[x][y]
        map_data[x][y] = 0

def print_top(dice):
    print(dice[1])

for order in orders:
    if order == EAST and can_move(x, y+1):
        y += 1
        move_east(dice, x, y, map_data)
        print_top(dice)
        continue

    if order == WEST and can_move(x, y-1):
        y -= 1
        move_west(dice, x, y, map_data)
        print_top(dice)
        continue

    if order == NORTH and can_move(x-1, y):
        x -= 1
        move_north(dice, x, y, map_data)
        print_top(dice)
        continue

    if order == SOUTH and can_move(x+1, y):
        x += 1
        move_south(dice, x, y, map_data)
        print_top(dice)
        continue

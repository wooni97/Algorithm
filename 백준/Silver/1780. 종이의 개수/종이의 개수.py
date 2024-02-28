import sys
input = sys.stdin.readline

n = int(input())
map = [list(map(int, input().split())) for _ in range(n)]

ans = [0, 0, 0]

def func(r, c, n):
    global map
    global ans
    number = map[r][c]

    for i in range(r, r+n):
        for j in range(c, c+n):

            if number != map[i][j]:
                for a in range(3):
                    for b in range(3):
                        func(r + (n//3) * a, c + (n//3) * b, n//3)
                return

    if number == -1:
        ans[0] += 1
    elif number == 0:
        ans[1] += 1
    elif number == 1:
        ans[2] += 1

func(0, 0, n)
for answer in ans:
    print(answer)

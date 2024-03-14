import sys

input = sys.stdin.readline
n = int(input())
eggs = [list(map(int, input().split())) for _ in range(n)]

"""
계란을 치는 과정
1. 가장 왼쪽의 계란을 든다.
2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다.
   단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
   이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다.
   단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
"""
answer = 0


def func(c):
    global answer
    if c == n:
        count = 0
        for egg in eggs:
            if egg[0] <= 0:
                count += 1
        answer = max(answer, count)
        return

    if eggs[c][0] <= 0:  # 계란이 깨진 상태라면
        func(c + 1)
        return

    check = True # 손에 든 계란 외 나머지 계란이 다 깨져있는지 확인하는 변수
    for i in range(n):
        if i == c:
            continue

        if eggs[i][0] > 0:
            check = False
            dur1, weight1 = eggs[c]
            dur2, weight2 = eggs[i]

            after_dur1 = dur1 - weight2
            after_dur2 = dur2 - weight1

            eggs[c][0] = after_dur1
            eggs[i][0] = after_dur2

            func(c + 1)

            eggs[c][0] = dur1
            eggs[i][0] = dur2

    if check:
        answer = max(answer, n - 1)
        return
    


func(0)
print(answer)

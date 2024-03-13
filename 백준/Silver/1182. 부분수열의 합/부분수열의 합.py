import sys

input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))
isused = [False] * n

answer = 0

def func(c, total):
    global answer
    if c == n:
        if total == s:
            answer += 1
        return

    func(c+1, total)
    func(c+1, total + arr[c])

func(0, 0)
if s == 0 :
    answer -=1
print(answer)
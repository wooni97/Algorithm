import sys

input = sys.stdin.readline

n = int(input())
answer = 0
isused1 = [False] * n
isused2 = [False] * ((n-1) * 2 + 1)
isused3 = [False] * ((n-1) * 2 + 1)

# c번째 행에 말을 배치할 예정
def func(c):
    global answer
    if c == n:
        answer += 1
        return

    for i in range(n):
        if not isused1[i] and not isused2[i+c] and not isused3[i-c+n-1]:
            isused1[i] = True
            isused2[i+c] = True
            isused3[i-c+n-1] = True

            func(c+1)

            isused1[i] = False
            isused2[i + c] = False
            isused3[i - c + n - 1] = False
func(0)
print(answer)
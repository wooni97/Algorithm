import sys
input = sys.stdin.readline
answer = sys.maxsize

n, s = map(int, input().split())
arr = list(map(int, input().split()))

st, en = 0, 0
sum = arr[st]

while en < n and st <= en:
    if sum < s:
        en += 1
        if en != n:
            sum += arr[en]
    elif sum >= s:
        answer = min(answer, en - st + 1)
        sum -= arr[st]
        st += 1
        
if answer == sys.maxsize:
    answer = 0
print(answer)
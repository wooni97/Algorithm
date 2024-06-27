import sys

input = sys.stdin.readline

N, K = map(int, input().split())
nums = list(map(int, input().split()))

end = 0
result = 0
cnt = 0 # 지운 횟수 count
erased = [False] * N

for start in range(N):
    while end < N:
        if nums[end] % 2 == 1 and cnt < K:
            erased[end] = True
            cnt += 1
            end += 1
            continue
        if nums[end] % 2 == 0:
            end += 1
            continue

        break

    result = max(result, end - start - cnt)

    if erased[start]:
        erased[start] = False
        cnt -= 1

print(result)
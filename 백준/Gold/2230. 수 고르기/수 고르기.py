import sys

input = sys.stdin.readline
answer = sys.maxsize

n, m = map(int, input().split())
nums = []
for _ in range(n):
    nums.append(int(input()))

nums.sort()

en = 0
for i in range(n):
    while(en < n and nums[en] - nums[i] < m):
        en += 1
    if en == n:
        break
    answer = min(answer, nums[en] - nums[i])
print(answer)
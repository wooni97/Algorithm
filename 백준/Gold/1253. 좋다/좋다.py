import sys
import bisect
from itertools import combinations

input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
nums.sort()
answer = 0

for i in range(n):
    goal = nums[i]
    start = 0
    end = n-1

    while start < end:
        if nums[start] + nums[end] == goal:
            if start == i:
                start += 1
            elif end == i:
                end -= 1
            else:
                answer += 1
                break
        elif nums[start] + nums[end] > goal:
            end -= 1
        elif nums[start] + nums[end] < goal:
            start += 1

print(answer)
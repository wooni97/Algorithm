import sys

input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
visited = [False] * 100001

result = 0
end = 0
for start in range(n):
    while end < n:
        if not visited[nums[end]]:
            visited[nums[end]] = True
            end += 1
            result += (end - start)
        elif visited[nums[end]]:
            break
    visited[nums[start]] = False

print(result)
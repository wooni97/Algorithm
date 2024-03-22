
import sys
input = sys.stdin.readline

MAX = 3000000001
diff = MAX

n = int(input())
nums = list(map(int, input().split()))

nums.sort()

def search():
    global diff

    result = []
    for i in range(n):
        start = i + 1
        end = n - 1
        while start < end:
            mix = nums[i] + nums[start] + nums[end]
            if abs(mix) < diff:
                diff = abs(mix)
                result = [nums[i], nums[start], nums[end]]
                
            if mix == 0:
                return [nums[i], nums[start], nums[end]]
            elif mix < 0:
                start += 1
            elif mix > 0:
                end -= 1


    return result

answer = search()
for a in answer:
    print(a, end=" ")
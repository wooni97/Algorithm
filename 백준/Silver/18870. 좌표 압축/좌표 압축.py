import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

temp = set(arr)
order_list = list(temp)
order_list.sort()

def binary_search(target, arr) :

    start = 0
    end = len(arr) - 1

    while start < end :
        mid = (start + end) // 2

        if arr[mid] >= target : end = mid
        else : start = mid + 1

    return start
ans = []

for number in arr :
    ans.append(binary_search(number, order_list))

print(' '.join(str(a) for a in ans))


import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

M = int(input())
numbers = list(map(int, input().split()))

arr.sort()

def binary_search(target, arr):
    start = 0
    end = N-1

    while start <= end :
        mid = (start + end) // 2

        if arr[mid] == target :
            return True
        elif arr[mid] < target :
            start = mid + 1
        elif arr[mid] > target :
            end = mid - 1
    return False
for number in numbers :
    if binary_search(number, arr):
        print(1)
    else :
        print(0)
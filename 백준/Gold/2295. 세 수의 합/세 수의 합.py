import sys
input = sys.stdin.readline

N = int(input())
arr = []

for _ in range(N) :
    arr.append(int(input()))
arr.sort()

two = []
for i in range(N) :
    for j in range(i, N) :
        two.append(arr[i] + arr[j])
two.sort()

def binary_searh(target, arr) :
    start = 0
    end = len(arr)- 1

    while(start < end) :
        mid = (start + end) // 2

        if arr[mid] == target :
            return True
        elif arr[mid] > target :
            end = mid - 1
        elif arr[mid] < target :
            start = mid + 1
    return False

def find():
    for i in range(N-1, -1, -1) :
        for j in range(0 , i) :
            if binary_searh(arr[i] - arr[j], two) :
                print(arr[i])
                return
find()

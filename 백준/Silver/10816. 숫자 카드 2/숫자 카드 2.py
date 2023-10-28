import sys

input = sys.stdin.readline

N = int(input())
cards = list(map(int, input().split()))

M = int(input())
numbers = list(map(int, input().split()))

cards.sort()


def left_index(target, arr):
    start = 0
    end = N

    while (start < end):
        mid = (start + end) // 2

        if arr[mid] >= target:
            end = mid
        else:
            start = mid + 1
    return start


def right_index(target, arr):
    start = 0
    end = N

    while (start < end):
        mid = (start + end) // 2

        if arr[mid] > target:
            end = mid
        else:
            start = mid + 1
    return start


ans = []
for number in numbers:
    ans.append(right_index(number, cards) - left_index(number, cards))

print(' '.join(str(answer) for answer in ans))
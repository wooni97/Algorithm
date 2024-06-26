import sys
import math

input = sys.stdin.readline
n = int(input())

arr = [True for i in range(n + 1)]
prime_num = []

# 에라토스테네스의 체 알고리즘
for i in range(2, int(math.sqrt(n)) + 1):  # 2부터 n 제곱근까지의 모든 수
    if arr[i] == True:
        j = 2
        while i * j <= n:
            arr[i * j] = False
            j += 1

for i in range(2, n + 1):
    if arr[i]:
        prime_num.append(i)

cnt = 0
en = 0
total = 0  # 초기 total을 0으로 설정

for st in range(len(prime_num)):
    while en < len(prime_num) and total < n:
        total += prime_num[en]
        en += 1
    if total == n:
        cnt += 1
    total -= prime_num[st]

print(cnt)

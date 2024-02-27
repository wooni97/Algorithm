import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

n, r, c = map(int, input().split())

def func(n, r, c):
    if n == 0:
        return 0

    if 0 <= r < 2 ** (n-1) and 0 <= c < 2 ** (n-1) :
        return func(n-1, r, c)
    if 0 <= r < 2 ** (n-1) and 2 ** (n-1) <= c < 2 ** n:
        return (2 ** (n-1)) * (2 ** (n-1)) + func(n-1, r, c - (2 **(n-1)))
    if 2 ** (n-1) <= r < 2 ** n and 0 <= c < 2 ** (n-1) :
        return 2 * ((2 ** (n-1)) * (2 ** (n-1))) + func(n-1, r - (2 ** (n-1)), c)
    if 2 ** (n-1) <= r < 2 ** n and 2 ** (n-1) <= c < 2 ** n:
        return 3 * ((2 ** (n-1)) * (2 ** (n-1))) + func(n-1, r - (2 ** (n-1)), c - (2 ** (n-1)))

print(func(n,r,c))
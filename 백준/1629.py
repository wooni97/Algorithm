import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

def func(a,b,c):
    if b == 1:
        return a % c
    val = func(a, b//2, c)
    val = val * val % c
    if b % 2 == 0 :
        return val
    return val * a % c
A, B, C = map(int, input().split())
print(func(A, B, C))

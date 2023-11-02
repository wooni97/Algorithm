n = int(input())
D = [0] * (n + 1)

D[1] = 1
if n > 1:
    D[2] = 3
if n > 2:
    D[3] = 5
    for i in range(4, n + 1):
        D[i] = (D[i - 1] + D[i - 2] * 2) % 10007

print(D[n])

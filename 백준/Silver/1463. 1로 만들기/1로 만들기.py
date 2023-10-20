N = int(input())

D = [0 for _ in range(N+1)]

for i in range(2, N+1) :
    D[i] = D[i-1] + 1
    if i % 3 == 0 :
        D[i] = min(D[i], D[i//3] + 1)
    if i % 2 == 0 :
        D[i] = min(D[i], D[i//2] + 1)


print(D[N])
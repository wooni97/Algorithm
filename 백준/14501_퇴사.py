N = int(input())

DP = [0] * N
T, C = [], []
for i in range(N) :
    t,c = map(int, input().split())
    T.append(t)
    C.append(c)

if T[N-1] + N-1 <= N :
    DP[N-1]  = C[N-1]

#뒤에서 부터 접근
for i in range(N-2, -1, -1) :
    if T[i] + i < N :
        DP[i] = max(DP[i + 1], DP[T[i] + i] + C[i])
    elif T[i] + i == N:
        DP[i] = max(DP[i+1],C[i])
    else :
        DP[i] = DP[i+1]

print(DP[0])
n = int(input())
stairs = [0] * (n+1)
for i in range(1, n+1) :
    stairs[i] = int(input())

D = [[0,0,0] for _ in range(n+1)]

if n == 1:
    print(stairs[1])
else:
    D[1][1] = stairs[1]
    D[2][1] = stairs[2]
    D[2][2] = stairs[1] + stairs[2]

    if n ==2  :
        print(max(D[n][1], D[n][2]))
    else :
        for i in range(3, n+1):
            D[i][1] = max(D[i-2][2], D[i-2][1]) + stairs[i]
            D[i][2] = D[i-1][1] + stairs[i]

        print(max(D[n][1], D[n][2]))

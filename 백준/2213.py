

N = int(input())

weight = [0]
weight += list((map(int, input().split())))

dp = [[0,0] for _ in range(N+1)]
dp_list = [[[],[]] for _ in range(N+1)]
visited = [False] * (N+1)
adj = [[] for _ in range(N+1)]

for _ in range(N-1) :
    node1, node2 = map(int, input().split())
    adj[node1].append(node2)
    adj[node2].append(node1)

def DFS(root):
    visited[root] = True
    dp[root][0] = weight[root]
    dp_list[root][0].append(root)

    for connected in adj[root] :
        if visited[connected] == True : continue
        DFS(connected)
        dp[root][0] += dp[connected][1]
        for num in dp_list[connected][1] :
            dp_list[root][0].append(num)

        if dp[connected][0] <= dp[connected][1] :
            dp[root][1] += dp[connected][1]
            for num in dp_list[connected][1]:
                dp_list[root][1].append(num)
        else :
            dp[root][1] += dp[connected][0]
            for num in dp_list[connected][0]:
                dp_list[root][1].append(num)


DFS(1)
if dp[1][0] <= dp[1][1] :
    print(dp[1][1])
    dp_list[1][1].sort()
    print(' '.join(map(str, dp_list[1][1])))
else :
    print(dp[1][0])
    dp_list[1][0].sort()
    print(' '.join(map(str, dp_list[1][0])))
N = int(input())

adj = [[] for _ in range(N+1)]
parent = [0] * (N+1)

for _ in range(N - 1) :
    node1, node2 = map(int, input().split())
    adj[node1].append(node2)
    adj[node2].append(node1)

parent[1] = 0

queue = [1]

while queue :
    curr = queue.pop(0)
    for node in adj[curr] :
        if node == parent[curr] : continue
        queue.append(node)
        parent[node] = curr

for i in range(2, N+1) :
    print(parent[i])
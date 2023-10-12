from queue import PriorityQueue
import sys
input = sys.stdin.readline
INF = sys.maxsize

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
distance = [INF] * (n+1)
queue = PriorityQueue()
pre = [0] * (n+1)

for _ in range(m) :
    node1, node2, weight = map(int, input().split())
    graph[node1].append((node2, weight))

start, end = map(int, input().split())

distance[start] = 0
queue.put((distance[start], start))

while not queue.empty():
    weight, node = queue.get()
    if distance[node] == weight:
        for nxt, dis in graph[node]:
            if distance[nxt] > distance[node] + dis:
                distance[nxt] = distance[node] + dis
                queue.put((distance[nxt], nxt))
                pre[nxt] = node

print(distance[end])

ans = [end]
now = end
while now != start:
    now = pre[now]
    ans.append(now)
ans.reverse()

print(len(ans))
print(' '.join(map(str,ans)))
import sys
from queue import PriorityQueue
INF = sys.maxsize
input = sys.stdin.readline
n, e = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(e):
    node1, node2, dis = map(int, input().split())
    graph[node1].append((node2,dis))
    graph[node2].append((node1,dis))

nec1, nec2 = map(int, input().split())

def min_distance(start, end):
    queue = PriorityQueue()
    distance = [INF] * (n+1)

    distance[start] = 0
    queue.put((distance[start], start))

    while not queue.empty():
        dis, node = queue.get()
        if distance[node] == dis:
            for nxt, nxt_dis in graph[node]:
                if distance[nxt] > distance[node] + nxt_dis:
                    distance[nxt] = distance[node] + nxt_dis
                    queue.put((distance[nxt], nxt))
    return distance[end]

result1 = min_distance(1, nec1) + min_distance(nec1, nec2) + min_distance(nec2, n)
result2 = min_distance(1, nec2) + min_distance(nec2, nec1) + min_distance(nec1, n)

result = min(result1, result2)
print(result if result < INF else -1)
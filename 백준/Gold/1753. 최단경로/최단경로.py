from queue import PriorityQueue
import sys
import heapq
INF = sys.maxsize
v, e = map(int, sys.stdin.readline().split())
start = int(sys.stdin.readline())
graph = [[] for _ in range(v+1)]
distance = [INF] * (v+1)
queue = PriorityQueue()
heap = []
for _ in range(e):
    node1, node2, weight = map(int, sys.stdin.readline().split())
    graph[node1].append((node2, weight))
#print(graph)

distance[start] = 0
heapq.heappush(heap,(distance[start], start))
#queue.put((distance[start], start))

while heap:
    weight, node = heapq.heappop(heap)
    if distance[node] < weight: continue
    for nxt, dis in graph[node]:
        if distance[nxt] > distance[node] + dis:
            distance[nxt] = distance[node] + dis
            heapq.heappush(heap,(distance[nxt], nxt))

for i in range(1, len(distance)) :
    if distance[i] == INF:
        print("INF")
    else :
        print(distance[i])
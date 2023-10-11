from queue import PriorityQueue
import sys
input = sys.stdin.readline
v, e = map(int, input().split())
start = int(input())
graph = [[] for _ in range(v+1)]
distance = [float('inf')] * (v+1)
queue = PriorityQueue()

for _ in range(e):
    node1, node2, weight = map(int, input().split())
    graph[node1].append((node2, weight))
#print(graph)

distance[start] = 0
queue.put((distance[start], start))

while not queue.empty():
    weight, node = queue.get()
    if distance[node] == weight:
        for nxt, dis in graph[node]:
            if distance[nxt] > distance[node] + dis:
                distance[nxt] = distance[node] + dis
                queue.put((distance[nxt], nxt))

for i in range(1, len(distance)) :
    if distance[i] < float('inf') :
        print(distance[i])
    else:
        print("INF")
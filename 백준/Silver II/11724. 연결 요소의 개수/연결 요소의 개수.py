
import sys
sys.setrecursionlimit(10**6)

def operator(i, visited, graph):
    visited[i] = True

    for node in graph[i]:
        if visited[node] == False:
            visited = operator(node, visited, graph)
    return visited

def solution(n, graph):
    visited = [False] * (n+1)
    answer = 0

    for i in range(1, n+1):
        if visited[i] == False:
            operator(i, visited, graph)
            answer += 1

    return answer

n, m = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+1)]

for i in range(m):
    node1, node2 = map(int, sys.stdin.readline().split())
    graph[node1].append(node2)
    graph[node2].append(node1)


print(solution(n, graph))


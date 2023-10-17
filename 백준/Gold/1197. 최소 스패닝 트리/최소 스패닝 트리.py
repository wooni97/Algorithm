import sys

input = lambda: sys.stdin.readline().rstrip()

v, e = map(int, input().split())

parent = [i for i in range(v + 1)]

edges = []
for _ in range(e):
    node1, node2, weight = map(int, input().split())
    edges.append((node1, node2, weight))

edges.sort(key=lambda x: x[2])


def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]


def union(node1, node2):
    node1 = find(node1)
    node2 = find(node2)

    if node1 < node2:
        parent[node2] = node1
    else:
        parent[node1] = node2


def same_parent(node1, node2):
    return find(node1) == find(node2)


min_weight = 0
for node1, node2, weight in edges:
    if not same_parent(node1, node2):
        union(node1, node2)
        min_weight += weight

print(min_weight)

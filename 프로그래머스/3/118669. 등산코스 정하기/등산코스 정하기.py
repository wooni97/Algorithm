
from collections import defaultdict
from queue import PriorityQueue
import sys


def solution(n, paths, gates, summits):
    def get_min_intensity():
        queue = PriorityQueue()
        INF = sys.maxsize

        visited = [float('inf')] * (n + 1)


        for gate in gates:
            queue.put((0, gate))
            visited[gate] = 0

        while not queue.empty():
            intensity, node = queue.get()

            if node in summits_set or intensity > visited[node]:
                continue

            for time, next_node in graph[node]:
                new_intensity = max(intensity, time)

                if new_intensity < visited[next_node]:
                    visited[next_node] = new_intensity
                    queue.put((new_intensity, next_node))

        min_intensity = [0, float('inf')]
        for summit in summits:
            if visited[summit] < min_intensity[1]:
                min_intensity[0] = summit
                min_intensity[1] = visited[summit]

        return min_intensity

    summits.sort()
    summits_set = set(summits)
    graph = defaultdict(list)

    for node1, node2, time in paths:
        graph[node1].append((time, node2))
        graph[node2].append((time, node1))

    return get_min_intensity()
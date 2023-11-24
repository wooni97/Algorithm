from collections import defaultdict, deque

def solution(n, path, order):
    
    visited = [False] * n
    graph = defaultdict(list)
    
    for node1, node2 in path :
        graph[node1].append(node2)
        graph[node2].append(node1)
        
    orders = {}
    
    for pre, post in order :
        orders[post] = pre

    
    queue = deque()
    queue.append(0)
    
    after = {}
    
    while queue :
        visit_node = queue.popleft()
        
        if visit_node in orders and visited[orders[visit_node]] == False :
            after[orders[visit_node]] = visit_node
            continue
        
        visited[visit_node] = True
        
        for next in graph[visit_node] :
            if not visited[next] :
                queue.append(next)
        
        if visit_node in after :
            queue.append(after[visit_node])
    
    visit_count = visited.count(True)
    return n == visit_count
def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x: (x[2]))
    print("costs:", costs)
    parent = [i for i in range(n)]
    
    connect = set([costs[0][0]])
    print(connect)
    while len(connect) != n :
        for node1, node2, cost in costs:

            if node1 in connect and node2 in connect: 
                continue 
            if node1 in connect or node2 in connect :
                if parent[node1] != parent[node2] :
                    connect.update([node1, node2]) 
                    answer += cost
                    if parent[node1] < parent[node2] :
                        parent[node2] = parent[node1]
                    else :
                        parent[node1] = parent[node2]
                    break
            
              
        


    
    
    return answer
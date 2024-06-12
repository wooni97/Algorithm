from collections import defaultdict

def solution(edges):
    answer = [0, 0, 0, 0]
    
    in_edge = defaultdict(list)
    out_edge = defaultdict(list)
    
    for edge in edges:
        out_node, in_node = edge
        
        out_edge[out_node].append(in_node)
        in_edge[in_node].append(out_node)
    
    #총 그래프 갯수
    total_graph_cnt = 0
    
    # 생성 정점 : 나가는 간선 2개 이상 존재, 들어오는 간선 X
    for key, value in out_edge.items():
        if len(value) >= 2 and key not in in_edge:
            total_graph_cnt = len(value)
            answer[0] = key
            
            for v in value:
                in_edge[v].remove(key)
    
    del out_edge[answer[0]]
    
    # print(in_edge)
    # print(out_edge)
    
    # 막대 모양 그래프 : 들어오는 간선이 없는 정점 하나 존재, 나가는 간선이 없는 정점 하나 존재
    # 나가는 간선이 없는 정점의 갯수를 찾는다(들어오는 간선이 없는 정점의 갯수를 찾는것도 가능)
    for key, value in in_edge.items():
        if len(value) == 0 and key not in out_edge: 
            answer[2] += 1
            continue
        
        if len(value) == 1 and key not in out_edge:
            answer[2] += 1
            continue
    
    # 8자 모양 그래프 : 하나의 정점을 제외하면 모든 정점이 들어오는 간선 하나 존재, 나가는 간선 하나 존재
    # 하나의 정점은 들어오는 간선 2 개 나가는 간선 2 개
    # 들어오는 간선이 2개, 나가는 간선이 2개인 정점의 갯수를 찾는다.
    for key, value in out_edge.items():
        if len(value) == 2 and len(in_edge[key]) == 2:
            answer[3] += 1
    
    # 도넛 모양 그래프 : 모든 정점이 들어오는 간선과 나가는 간선이 각각 하나씩 존재한다.
    # 전체 그래프 갯수에서 막대 모양, 8자 모양 그래프의 갯수를 빼면 된다.
    answer[1] = total_graph_cnt - (answer[2] + answer[3])
    
    return answer
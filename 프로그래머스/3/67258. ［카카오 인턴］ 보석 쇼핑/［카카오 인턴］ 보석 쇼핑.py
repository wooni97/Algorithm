import sys

def solution(gems):
    
    answer = [1, len(gems)]
    
    INF = sys.maxsize
    MIN = INF
    n = len(gems)
    gems_set = set(gems)
    end = 0 
    
    gem_dict = {}
    
    gem_dict[gems[0]] = 1 
    
    for start in range(n) :
        while end < n and len(gem_dict) < len(gems_set) :
            end += 1
            
            if end != n :
                
                if gems[end] not in gem_dict :
                    gem_dict[gems[end]] = 1
                else :
                    gem_dict[gems[end]] += 1
        
        if end == n :
            break
        
        if end - start < answer[1] - answer[0] :
            answer = [start + 1, end + 1]
            
        gem_dict[gems[start]] -= 1
        if gem_dict[gems[start]] == 0 :
            del gem_dict[gems[start]]
      
    return answer
